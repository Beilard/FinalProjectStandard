package ua.delivery.model.dao.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.exception.DataBaseRuntimeException;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudDaoImpl.class);
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * from users WHERE email = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT * from users WHERE id = ?";
    private static final String SAVE_USER_QUERY =
            "INSERT INTO users(id, email, password, name, surname, date_of_birth, role) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String DELETE_BY_QUERY = "DELETE FROM users Where id = ?";


    public UserDaoImpl(DBConnector connector) {
        super(connector);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_QUERY);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapResultToEntity(resultSet);
        } catch (SQLException e) {
            LOGGER.error("There is an DB search error when looking by email " + email);
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public void save(User item) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_QUERY);

            preparedStatement.setLong(1, item.getId());
            preparedStatement.setString(2, item.getUserCredentials().getEmail());
            preparedStatement.setString(3, item.getUserCredentials().getPassword());
            preparedStatement.setString(4, item.getName());
            preparedStatement.setString(5, item.getSurname());
            preparedStatement.setDate(6, (Date) item.getDateOfBirth());
            preparedStatement.setString(7, item.getRole().toString());
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("An error while creating a user object " + item.getUserCredentials().getEmail());
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return findById(id, FIND_BY_ID_QUERY);
    }

    @Override
    public List<User> findAll() {
        return findAll(FIND_ALL_QUERY);
    }

    @Override
    public void update(Long id, User item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        deleteById(id, DELETE_BY_QUERY);
    }

    @Override
    public void deleteAllById(Set<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    protected Optional<User> mapResultToEntity(ResultSet resultSet) throws SQLException {
        return resultSet.next() ?
                Optional.ofNullable(User.builder()
                        .withId(resultSet.getLong("id"))
                        .withName(resultSet.getString("name"))
                        .withSurname(resultSet.getString("surname"))
                        .withUserCredentials(new UserCredentials(resultSet.getString("email"), resultSet.getString(("password"))))
                        .withDateOfBirth(resultSet.getDate("date_of_birth"))
                        .build())
                : Optional.empty();
    }


}
