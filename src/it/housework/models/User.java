/**
 * 
 */
package it.housework.models;

/**
 * @author mtank
 *
 */
public class User {
	
	private String name;
	final private Boolean admin;
	
	/**
	 * @param name
	 * @param admin
	 */
	public User(String name, Boolean admin) {
		this.name = name;
		this.admin = admin;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}
}
