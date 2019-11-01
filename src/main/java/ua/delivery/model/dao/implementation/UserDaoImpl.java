package ua.delivery.model.dao.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.dao.exception.DataBaseRuntimeException;
import ua.delivery.model.domain.User;
import ua.delivery.model.domain.UserCredentials;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class UserDaoImpl extends AbstractCrudDaoImpl<UserEntity> implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudDaoImpl.class);
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * from users WHERE email = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT * from users WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO users(email, password, name, surname, date_of_birth, role)";
    private static final String UPDATE_QUERY =
            "UPDATE users SET email =?, password=?, name=?, surname=?, date_of_birth =? WHERE id = ?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM users Where id = ?";


    public UserDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return findByStringParam(email, FIND_BY_EMAIL_QUERY);
    }


    @Override
    public void deleteAllById(Set<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, UserEntity item) throws SQLException {
        preparedStatement.setString(1, item.getUserCredentials().getEmail());
        preparedStatement.setString(2, item.getUserCredentials().getPassword());
        preparedStatement.setString(3, item.getName());
        preparedStatement.setString(4, item.getSurname());
        preparedStatement.setDate(5, (Date) item.getDateOfBirth());
        preparedStatement.setString(6, item.getRole().toString());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, UserEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(7, entity.getId());
    }


    @Override
    protected UserEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return UserEntity.builder()
                .withId(resultSet.getLong("id"))
                .withName(resultSet.getString("name"))
                .withSurname(resultSet.getString("surname"))
                .withUserCredentials(new UserCredentialsEntity(resultSet.getString("email"), resultSet.getString(("password"))))
                .withDateOfBirth(resultSet.getDate("date_of_birth"))
                .build();
    }


}
