package ua.delivery.model.dao.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.dao.CrudDao;
import ua.delivery.model.dao.DBConnector;
import ua.delivery.model.dao.exception.DataBaseRuntimeException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E, Long> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCrudDaoImpl.class);
    private static final String FIND_BY_QUERY = "";
    private static final String DELETE_BY_QUERY = "";


    protected final DBConnector connector;

    public AbstractCrudDaoImpl(DBConnector connector) {
        this.connector = connector;
    }

    protected Optional<E> findById(Long id, String query) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return mapResultToEntity(resultSet);
        } catch (SQLException e) {
            LOGGER.error("An error occurred while trying to find by id" + id);
            throw new DataBaseRuntimeException(e);
        }
    }

    public List<E> findAll(String query) {
        List<E> entities = new LinkedList<>();
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(mapResultToEntity(resultSet).get());
            }
        } catch (SQLException e) {
            LOGGER.error("SQL exception while finding all in User DB");
        }
        return entities;
    }

    public void deleteById(Long id, String query) {
        try (Connection connection = connector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("An error occurred while trying to remove by id");
            throw new DataBaseRuntimeException(e);
        }
    }

    protected abstract Optional<E> mapResultToEntity(ResultSet resultSet) throws SQLException;
}
