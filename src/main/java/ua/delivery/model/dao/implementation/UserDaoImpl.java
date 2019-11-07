package ua.delivery.model.dao.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.UserDao;
import ua.delivery.model.domain.Role;
import ua.delivery.model.entity.UserCredentialsEntity;
import ua.delivery.model.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private static final String FIND_BY_SURNAME = "SELECT * FROM users WHERE surname = ?";


    public UserDaoImpl() {
        super(SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return findByStringParam(email, FIND_BY_EMAIL_QUERY);
    }

    @Override
    public Optional<UserEntity> findBySurname(String surname) {
        return findByStringParam(surname, FIND_BY_SURNAME);
    }


    @Override
    public void deleteAllById(Set<Long> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, UserEntity item) throws SQLException {
        preparedStatement.setString(2, item.getUserCredentials().getEmail());
        preparedStatement.setString(3, item.getUserCredentials().getPassword());
        preparedStatement.setString(4, item.getName());
        preparedStatement.setString(5, item.getSurname());
        preparedStatement.setString(6, "user");
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, UserEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1, entity.getId());
    }


    @Override
    protected UserEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return UserEntity.builder()
                .withId(resultSet.getLong("id"))
                .withName(resultSet.getString("name"))
                .withSurname(resultSet.getString("surname"))
                .withUserCredentials(new UserCredentialsEntity(resultSet.getString("email"), resultSet.getString(("password"))))
                .withRole(resultSet.getString("role").equals("user") ? Role.USER : Role.ADMIN)
                .build();
    }


}
