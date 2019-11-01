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
    private static final String FIND_BY_ID_QUERY = "SELECT * from orders WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO orders(sender_id, receiver_id, package_id, payment_id, route_id sent_date, receive_date)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM orders";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM orders Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE orders SET sender_id=?, receiver_id=?, package_id=?, payment_id=?, route_id=?, sent_date=?, receive_date=? WHERE id = ?";

    public OrderDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }


    @Override
    public Optional<Order> findByRouteId(Long id) {
        return Optional.empty();
    }

    @Override
    protected OrderEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return OrderEntity.builder()
                .withSenderId(resultSet.getLong("sender_id"))
                .withReceiverId((resultSet.getLong("receiver_id")))
                .withPackageId(resultSet.getLong("package_id"))
                .build();
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, OrderEntity item) throws SQLException {
        preparedStatement.setLong(2, item.getSenderId());
        preparedStatement.setLong(3, item.getReceiverId());
        preparedStatement.setLong(4, item.getPackageId());
        preparedStatement.setLong(5, item.getPaymentId());
        preparedStatement.setDate(6, item.getSentDate());
        preparedStatement.setDate(7, item.getReceiveDate());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, OrderEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1,entity.getId());
    }
}
