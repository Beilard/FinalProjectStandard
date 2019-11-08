package ua.delivery.model.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.delivery.model.exception.DataBaseRuntimeException;

import java.sql.Connection;
import java.sql.SQLException;


public class DBConnector {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBConnector.class);
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setUrl("jdbc:mysql://localhost:3306/main_schema");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        dataSource.setMinIdle(10);
        dataSource.setMaxIdle(15);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    public DBConnector() {
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("There is a connection error to the DB", e);
            throw new DataBaseRuntimeException(e);
        }
    }
}
