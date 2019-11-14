package ua.delivery.model.dao.implementation;

import org.apache.log4j.Logger;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.OrderDao;
import ua.delivery.model.entity.OrderEntity;
import ua.delivery.model.exception.DataBaseRuntimeException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractCrudDaoImpl<OrderEntity> implements OrderDao {
    private static final Logger LOGGER = Logger.getLogger(OrderDaoImpl.class);
    private static final String FIND_BY_ID_QUERY = "SELECT * from orders WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO orders(sender_id, recipient_name,, recipient_surname, package_id, payment_id, route_id, sent_date, receive_date)" +
                    " VALUES(?, ?, ?, ?, ?, ?, ?,? )";
    private static final String FIND_ALL_QUERY = "SELECT * FROM orders";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM orders Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE orders SET sender_id=?, receiver_id=?, package_id=?, payment_id=?, route_id=?, sent_date=?, receive_date=? WHERE id = ?";
    private static final String FIND_BY_ROUTE = "SELECT * FROM orders WHERE id = ?";
    private static final String FIND_ALL_BY_SENDER = "SELECT * FROM orders WHERE sender_id = ?";

    public OrderDaoImpl() {
        super(SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }


    @Override
    public List<OrderEntity> findAllBySender(Long id) {
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_SENDER)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<OrderEntity> orders = new ArrayList<>();
                while (resultSet.next()) {
                    orders.add(mapResultSetToEntity(resultSet));
                }
                return orders;
            }
        } catch (SQLException e) {
            LOGGER.error("There has been an error while getting orders by id list");
            throw new DataBaseRuntimeException(e);
        }
    }

    @Override
    public Optional<OrderEntity> findByRouteId(Long id) {
        return findByLongParam(id, FIND_BY_ROUTE);
    }

    @Override
    protected OrderEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return OrderEntity.builder()
                .withSenderId(resultSet.getLong("sender_id"))
                .withRecipientName(resultSet.getString("recipient_name"))
                .withRecipientSurname(resultSet.getString("recipient_surname"))
                .withPackageId(resultSet.getLong("package_id"))
                .withPaymentId(resultSet.getLong("payment_id"))
                .withRoute(resultSet.getLong("route_id"))
                .build();
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, OrderEntity item) throws SQLException {
        preparedStatement.setLong(1, item.getSenderId());
        preparedStatement.setString(2, item.getRecipientName());
        preparedStatement.setString(3, item.getRecipientSurname());
        preparedStatement.setLong(4, item.getPackageId());
        preparedStatement.setLong(5, item.getPaymentId());
        preparedStatement.setLong(6, item.getRoute());
        preparedStatement.setDate(7, Date.valueOf(item.getSentDate()));
        preparedStatement.setDate(8, Date.valueOf(item.getReceiveDate()));
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, OrderEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1,entity.getId());
    }
}
