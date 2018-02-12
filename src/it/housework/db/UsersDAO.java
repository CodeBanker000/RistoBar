/**
 * 
 */
package it.housework.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.housework.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Gives the CRUD method for the table users: create, retrieve, update and
 * delete 
 * 
 * @author  Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class UsersDAO
{
    /** Logger object */
    private static final Logger log = LogManager.getLogger(UsersDAO.class);
    
    /** Object Connection */
    private static Connection conn;
    
    /**
     * Read tb_users for search the user that makes the login
     * 
     * @param user
     * @param pass
     * @return 
     */
    public static User read(String user, String pass)
    {
        UsersDAO.conn = DBconnect.getConnection();

        User result = null;

        final String sql = "SELECT tb_users.user, tb_users.admin " +
                           "FROM tb_users WHERE tb_users.user = ? " + 
                           "AND tb_users.pass = ?";
    
        try {
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, user);
            st.setString(2, pass);

            ResultSet rs = st.executeQuery();
            
            log.debug(rs);
            
            if (rs.next()) {
                User usr = new User(
                    rs.getString("user"),
                    rs.getBoolean("admin")
                );
                    
                result = usr;
            } else {
                result = null;
            }
            
            log.debug(result);
            
            rs.close();
            conn.close();
        } catch (SQLException e) {
            log.fatal(e);
        }

        return result;
    }

}