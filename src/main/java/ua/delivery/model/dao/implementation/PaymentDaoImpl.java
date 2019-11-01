package ua.delivery.model.dao.implementation;

import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.PaymentDao;
import ua.delivery.model.entity.PaymentEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDaoImpl extends AbstractCrudDaoImpl<PaymentEntity> implements PaymentDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * from payment WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO payments(order_id, amount, date, is_complete)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM payments";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM payments Where id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE payments SET order_id = ?, amount = ?, date = ?, is_complete =? WHERE id= ?";

    public PaymentDaoImpl(DBConnector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected PaymentEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return PaymentEntity.builder()
                .withId(resultSet.getLong("id"))
                .withOrderId(resultSet.getLong("order_id"))
                .withAmount(resultSet.getDouble("amount"))
                .withDate(resultSet.getDate("date"))
                .withComplete(resultSet.getBoolean("is_complete"))
                .build();
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, PaymentEntity item) throws SQLException {
        preparedStatement.setLong(2, item.getOrderId());
        preparedStatement.setDouble(3, item.getAmount());
        preparedStatement.setDate(4, item.getDate());
        preparedStatement.setBoolean(5, item.isComplete());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, PaymentEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1, entity.getId());
    }
}
