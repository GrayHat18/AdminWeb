package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private static final BasicDataSource snowflake = setupDataSource("snowflake");
    private static final BasicDataSource postgresql = setupDataSource("postgresql");
    private static final BasicDataSource mySql = setupDataSource("mySql");
    private static final BasicDataSource db2 = setupDataSource("db2");

    private static BasicDataSource setupDataSource(String dbType) {
        BasicDataSource ds = null;
        Properties props;
        InputStream in = Conexion.class.getClassLoader().getResourceAsStream("connection.properties");

        try {
            props = new Properties();
            ds = new BasicDataSource();

            props.load(in);

            switch (dbType) {
                case "snowflake":
                    ds.setDriverClassName(props.getProperty("snowflake.jdbcDriver"));

                    String jdbcUrl = props.getProperty("snowflake.jdbcUrl")
                            .replace("${jdbcDatabase}", props.getProperty("snowflake.jdbcDatabase"))
                            .replace("${jdbcSchema}", props.getProperty("snowflake.jdbcSchema"))
                            .replace("${jdbcWarehouse}", props.getProperty("snowflake.jdbcWarehouse"));

                    ds.setUrl(jdbcUrl);
                    ds.setUsername(props.getProperty("snowflake.jdbcUser"));
                    ds.setPassword(props.getProperty("snowflake.jdbcPassword"));
                    break;
                case "postgresql":
                    ds.setDriverClassName(props.getProperty("postgresql.jdbcDriver"));

                    String postgrejdbcUrl = props.getProperty("postgresql.jdbcUrl")
                            .replace("${jdbcDatabase}", props.getProperty("postgresql.jdbcDatabase"));
                    ds.setUrl(postgrejdbcUrl);
                    ds.setUsername(props.getProperty("postgresql.jdbcUser"));
                    ds.setPassword(props.getProperty("postgresql.jdbcPassword"));
                    break;
                case "mySql":
                    ds.setDriverClassName(props.getProperty("mySql.jdbcDriver"));

                    String mysqljdbcUrl = props.getProperty("mySql.jdbcUrl")
                            .replace("${jdbcDatabase}", props.getProperty("mySql.jdbcDatabase"));
                    ds.setUrl(mysqljdbcUrl);
                    ds.setUsername(props.getProperty("mySql.jdbcUsername"));
                    ds.setPassword(props.getProperty("mySql.jdbcPassword"));
                    break;
                case "db2":
                    ds.setDriverClassName(props.getProperty("db2.jdbcDriver"));

                    String db2jdbcUrl = props.getProperty("db2.jdbcUrl")
                            .replace("${jdbcDatabase}", props.getProperty("db2.jdbcDatabase"));

                    ds.setUrl(db2jdbcUrl);
                    ds.setUsername(props.getProperty("db2.jdbcUser"));
                    ds.setPassword(props.getProperty("db2.jdbcPassword"));
                    break;
                default:
                    throw new IllegalArgumentException("Motor de Base de Datos Desconocido: " + dbType);
            }

            ds.setInitialSize(5);
            ds.setMaxTotal(20);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace(System.out);
        }

        return ds;
    }

    private BasicDataSource settingSnowflake(BasicDataSource ds, Properties props) {

        return ds;
    }

    private BasicDataSource settingPostgre(BasicDataSource ds, Properties props) {

        return ds;
    }

    private BasicDataSource settingMySql(BasicDataSource ds, Properties props) {

        return ds;
    }

    private BasicDataSource settingDb2(BasicDataSource ds, Properties props) {

        return ds;
    }

    public static Connection getConnectionSnowflake() throws SQLException {
        return snowflake.getConnection();
    }

    public static Connection getConnectionPostgreSQL() throws SQLException {
        return postgresql.getConnection();
    }

    public static Connection getConnectionMySQL() throws SQLException {
        return mySql.getConnection();
    }

    public static Connection getConnectionDB2() throws SQLException {
        return db2.getConnection();
    }

}
