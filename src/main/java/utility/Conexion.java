package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {

    private final BasicDataSource snowflake = setupDataSource("snowflake");
    private final BasicDataSource postgresql = setupDataSource("postgresql");
    private final BasicDataSource mySql = setupDataSource("mySql");
    private final BasicDataSource db2 = setupDataSource("db2");

    private BasicDataSource setupDataSource(String dbType) {
        BasicDataSource ds = null;
        Properties props;
        InputStream in = Conexion.class.getClassLoader().getResourceAsStream("connection.properties");

        try {
            props = new Properties();
            ds = new BasicDataSource();

            props.load(in);

            switch (dbType) {
                case "snowflake":
                    this.settingSnowflake(ds, props);
                    break;
                case "postgresql":
                    this.settingPostgre(ds, props);
                    break;
                case "mySql":
                    this.settingMySql(ds, props);
                    break;
                case "db2":
                    this.settingDb2(ds, props);
                    break;
                default:
                    throw new IllegalArgumentException("Motor de Base de Datos Desconocido: " + dbType);
            }

            ds.setInitialSize(5);
            ds.setMaxTotal(100);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace(System.out);
        }

        return ds;
    }

    private BasicDataSource settingSnowflake(BasicDataSource ds, Properties props) {
        ds.setDriverClassName(props.getProperty("snowflake.jdbcDriver"));

        String jdbcUrl = props.getProperty("snowflake.jdbcUrl")
                .replace("${jdbcDatabase}", props.getProperty("snowflake.jdbcDatabase"))
                .replace("${jdbcSchema}", props.getProperty("snowflake.jdbcSchema"))
                .replace("${jdbcWarehouse}", props.getProperty("snowflake.jdbcWarehouse"));

        ds.setUrl(jdbcUrl);
        ds.setUsername(props.getProperty("snowflake.jdbcUser"));
        ds.setPassword(props.getProperty("snowflake.jdbcPassword"));
        return ds;
    }

    private BasicDataSource settingPostgre(BasicDataSource ds, Properties props) {
        ds.setDriverClassName(props.getProperty("postgresql.jdbcDriver"));

        String postgrejdbcUrl = props.getProperty("postgresql.jdbcUrl")
                .replace("${jdbcDatabase}", props.getProperty("postgresql.jdbcDatabase"));
        ds.setUrl(postgrejdbcUrl);
        ds.setUsername(props.getProperty("postgresql.jdbcUser"));
        ds.setPassword(props.getProperty("postgresql.jdbcPassword"));
        return ds;
    }

    private BasicDataSource settingMySql(BasicDataSource ds, Properties props) {
        ds.setDriverClassName(props.getProperty("mySql.jdbcDriver"));

        String mysqljdbcUrl = props.getProperty("mySql.jdbcUrl")
                .replace("${jdbcDatabase}", props.getProperty("mySql.jdbcDatabase"));
        ds.setUrl(mysqljdbcUrl);
        ds.setUsername(props.getProperty("mySql.jdbcUsername"));
        ds.setPassword(props.getProperty("mySql.jdbcPassword"));
        return ds;
    }

    private BasicDataSource settingDb2(BasicDataSource ds, Properties props) {
        ds.setDriverClassName(props.getProperty("db2.jdbcDriver"));

        String db2jdbcUrl = props.getProperty("db2.jdbcUrl")
                .replace("${jdbcDatabase}", props.getProperty("db2.jdbcDatabase"));

        ds.setUrl(db2jdbcUrl);
        ds.setUsername(props.getProperty("db2.jdbcUser"));
        ds.setPassword(props.getProperty("db2.jdbcPassword"));
        return ds;
    }

    public Connection getConnectionSnowflake() throws SQLException {
        return snowflake.getConnection();
    }

    public Connection getConnectionPostgreSQL() throws SQLException {
        return postgresql.getConnection();
    }

    public Connection getConnectionMySQL() throws SQLException {
        return mySql.getConnection();
    }

    public Connection getConnectionDB2() throws SQLException {
        return db2.getConnection();
    }

}
