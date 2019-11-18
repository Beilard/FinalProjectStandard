package ua.delivery.model.dao.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.AddressDao;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.entity.AddressEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressDaoImpl extends AbstractCrudDaoImpl<AddressEntity> implements AddressDao {
    private static final Logger LOGGER = Logger.getLogger(AddressDaoImpl.class);
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM addresses WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO addresses(city, street, building) VALUES(?, ?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM addresses";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM addresses Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE addresses SET email =?, password=?, name=?, surname=?, date_of_birth =? WHERE id = ?";
    private static final String FIND_ALL_BY_CITY = "SELECT * FROM addresses WHERE city = ?";
    private static final String FIND_ALL_CITIES = "SELECT DISTINCT city FROM addresses";

    public AddressDaoImpl() {
        super(SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    public Set<String> findAllCities() {
        Set<String> cities = new HashSet<>();
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_CITIES)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(resultSet.getString(1));
                }
                return cities;
            }
        } catch (SQLException e) {
            LOGGER.error("There has been an error while getting set of cities");
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public List<AddressEntity> findAllByCity(String city) {
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_CITY)) {
            preparedStatement.setString(1, city);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<AddressEntity> addresses = new ArrayList<>();
                while (resultSet.next()) {
                    addresses.add(mapResultSetToEntity(resultSet));
                }
                return addresses;
            }
        } catch (SQLException e) {
            LOGGER.error("There has been an error while getting cities list by find all");
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    protected AddressEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new AddressEntity(resultSet.getLong("id"), resultSet.getString("city"),
                resultSet.getString("street"), resultSet.getInt("building"));
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, AddressEntity entity) throws SQLException {
        preparedStatement.setString(1, entity.getCity());
        preparedStatement.setString(2, entity.getStreet());
        preparedStatement.setInt(3, entity.getBuildingNumber());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, AddressEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1, entity.getId());
    }

}
