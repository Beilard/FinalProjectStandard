package ua.delivery.model.dao.implementation;

import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.domain.Address;
import ua.delivery.model.entity.AddressEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AddressDaoImpl extends AbstractCrudDaoImpl<AddressEntity> implements AddressDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * from addresses WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO addresses(city, street, building)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM addresses";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM addresses Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE addresses SET email =?, password=?, name=?, surname=?, date_of_birth =? WHERE id = ?";

    public AddressDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected AddressEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new AddressEntity(resultSet.getLong("id"), resultSet.getString("city"),
                resultSet.getString("street"), resultSet.getInt("building"));
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, AddressEntity entity) throws SQLException {
        preparedStatement.setString(2, entity.getCity());
        preparedStatement.setString(3, entity.getStreet());
        preparedStatement.setInt(4, entity.getBuildingNumber());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, AddressEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1, entity.getId());
    }
}
