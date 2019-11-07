package ua.delivery.model.dao.implementation;

import ua.delivery.model.dao.PackageDao;
import ua.delivery.model.entity.PackageEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PackageDaoImpl extends AbstractCrudDaoImpl<PackageEntity> implements PackageDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * from packages WHERE id = ?";
    private static final String SAVE_QUERY =
            "INSERT INTO packages(type, weight)";
    private static final String FIND_ALL_QUERY = "SELECT * FROM packages";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM packages WHERE id = ?";
    private static final String UPDATE_QUERY =
            "UPDATE packages SET type = ?, weight = ? WHERE id = ?";

    public PackageDaoImpl() {
        super(SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected PackageEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new PackageEntity(resultSet.getLong("id"), resultSet.getString("type"),
                resultSet.getDouble("weight)"));
    }

    @Override
    protected void insert(PreparedStatement preparedStatement, PackageEntity item) throws SQLException {
        preparedStatement.setString(2, item.getType());
        preparedStatement.setDouble(3, item.getWeight());
    }

    @Override
    protected void updateValues(PreparedStatement preparedStatement, PackageEntity entity) throws SQLException {
        insert(preparedStatement, entity);
        preparedStatement.setLong(1, entity.getId());
    }
}
