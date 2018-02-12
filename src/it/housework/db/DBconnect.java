/**
 *
 */
package it.housework.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.DataSources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Handle the connection for PostgreSQL, create a static object that contains
 * connection pool
 *
 * @author Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class DBconnect
{
    /** Logger object */
    private static final Logger log = LogManager.getLogger(DBconnect.class);
    
    /** position of driver jdbc of postgreSQL */
    private final static String JDBC_URL = "jdbc:postgresql://localhost:5432/db_ristobar_dev";

    /** username to connect to database server */
    private final static String USER = "postgres";

    /** password to connect to database server */
    private final static String PASS = "mtank";

    /** Object :: DataSource */
    private static DataSource ds;

    /**
     * Create the connection to the database if throws an excetion return null
     *
     * @return the connection or null
     */
    public static Connection getConnection()
    {
        //create the DataSource
        if (ds == null) {
            try {
                ds = DataSources.pooledDataSource(
                         DataSources.unpooledDataSource(JDBC_URL, USER, PASS));
            } catch (SQLException e) {
                log.fatal(e);
                System.exit(1);
            }
        }

        //create the connection
        try {
            Connection c = ds.getConnection();
            return c;
        } catch (SQLException e) {
            log.fatal(e);
            return null;
        }
    }
}