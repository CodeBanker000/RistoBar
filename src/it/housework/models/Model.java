/**
 * 
 */
package it.housework.models;

import it.housework.db.UsersDAO;

/**
 * Create the model and given the method to talk with the DAO
 * @author mtank
 */
public class Model 
{
    /**
     * Construct of the class
     */
    public Model () {}
    
    /**
     * Search the user by the username and the password, if finds the row
     * the method return JavaBean User
     * 
     * @param user name of user
     * @param pass password of user
     * @return the User object
     */
    public User findUser(String user, String pass)
    {
        return UsersDAO.read(user, pass);
    }
	
}