package ru.vachok.ftpplus;



import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

/**
 Параметры для БД <b>MySQL</b>.

 @since 01.05.2018 (19:01) */
class DataSourceSelector {
    private static final Logger LOGGER = Const.LOGGER;
    /**
     Отправить {@link Properties} в базу на РКГ.РУ

     @param typeName class.getTypeName. Кто сэтает {@link Properties}
     @param property ключ
     @param valueof  значение
     */
    public static void setProperties(String typeName, String property, String valueof) {
        String sqlStr = "UPDATE u0466446_liferpg.properties SET  property='?', valueofproperty='?', timeset='?'  WHERE javaid = '?';";
        try (
                Connection connection = new DataSourceSelector().conReg().getConnection();
                Statement statement = connection.createStatement();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr)
        ) {
            preparedStatement.setString(1, property);
            preparedStatement.setString(2, valueof);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setString(3, typeName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    /**
     Данные для соединения с БД на REG.RU

     @return datasource connection
     */
    private MysqlDataSource conReg() {
        MysqlDataSource conReg = new MysqlDataSource();
        conReg.setServerName("server202.hosting.reg.ru");
        conReg.setDatabaseName("u0466446_liferpg");
        conReg.setPassword("36e42yoak8");
        conReg.setUser("u0466446_kudr");
        conReg.setAutoClosePStmtStreams(true);
        return conReg;
    }
    /**
     Данные для соединения с БД на a161.eatmeat.ru

     @param dbName имя схемы БД.
     @return datasource connection
     */
    public MysqlDataSource conA161(String dbName) {
        MysqlDataSource conA161 = new MysqlDataSource();
        conA161.setServerName("a161.eatmeat.ru");
        conA161.setDatabaseName(dbName);
        conA161.setPassword("36e42yoak8");
        conA161.setUser("kudr");
        conA161.setAutoClosePStmtStreams(true);
        return conA161;
    }
    /**
     {@link Properties} из базы

     @param typeName имя типа, запросившего {@link Properties}
     @return {@link Properties}
     */
    public Properties getProperties(String typeName) {
        Properties properties = new Properties();
        DataSourceSelector ds = new DataSourceSelector();
        try (Connection connection = ds.conReg().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from u0466446_liferpg.properties where javaid like ?;")) {
            preparedStatement.setString(1, typeName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String property = resultSet.getString("property");
                    String valueofproperty = resultSet.getString("valueofproperty");

                    properties.setProperty(property, valueofproperty);
                    LOGGER.log(WARNING, () -> property + " = " + valueofproperty);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.INFO, () -> Arrays.toString(e.getStackTrace()) + " is e.getStackTrace().toString() | " + "DataSourceSelector.java ID == 95 ||");
        }
        LOGGER.log(INFO, () -> "properties set is++ " + properties.size() + " | " + "MyDataSource.getProperties current str.ID == 37 --is");
        return properties;
    }
}