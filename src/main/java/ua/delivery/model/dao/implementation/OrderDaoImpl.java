package ua.delivery.model.dao.implementation;

import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.OrderDao;
import ua.delivery.model.domain.Order;
import ua.delivery.model.entity.OrderEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class OrderDaoImpl extends AbstractCrudDaoImpl<OrderEntity> implements OrderDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * from addresses WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO addresses(id, email, password, name, surname, date_of_birth, role)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM addresses";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM addresses Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE addresses SET email =?, password=?, name=?, surname=?, date_of_birth =? WHERE id = ?";

    public OrderDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }


    @Override
    public Optional<Order> findByRouteId(Long id) {
        return Optional.empty();
    }

    @Override
    protected OrderEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, OrderEntity entity) throws SQLException {

    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, OrderEntity entity) throws SQLException {

    }
}
