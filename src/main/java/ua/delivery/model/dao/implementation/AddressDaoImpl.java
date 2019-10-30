package ua.delivery.model.dao.implementation;

import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.domain.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AddressDaoImpl extends AbstractCrudDaoImpl<Address> implements AddressDao {
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * from users WHERE email = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT * from users WHERE id = ?";
    private static final String SAVE_USER_QUERY =
            "INSERT INTO users(id, email, password, name, surname, date_of_birth, role) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";
    private static final String DELETE_BY_QUERY = "DELETE FROM users Where id = ?";

    public AddressDaoImpl(DBConnector connector) {
        super(connector);
    }

    @Override
    public void save(Address item) {

    }

    @Override
    public Optional<Address> findById(Long id) {
        return findById(id, FIND_BY_ID_QUERY);
    }

    @Override
    public List<Address> findAll() {
        return findAll(FIND_ALL_QUERY);
    }

    @Override
    public void update(Long aLong, Address item) {

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
    protected Optional<Address> mapResultToEntity(ResultSet resultSet) throws SQLException {
        return Optional.empty();
    }
}
