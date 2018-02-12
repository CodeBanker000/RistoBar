/**
 * 
 */
package it.housework.models;

/**
 * JavaBean of Outlet gets from the database,
 * the object contains all the data extract from the database
 * @author mtank
 *
 */
public class Outlet 
{
	private int id;
	private String outlet;
	private boolean visible;
	
	/**
	 * Construct of Class
	 */
	public Outlet() {};
	
	/**
	 * Construct of Class with the parameter
	 * 
	 * @param id 	   id of outlet
	 * @param outlet   name of outlet
	 * @param visible  decide if the outlet has to be visible or not
	 */
	public Outlet(int id, String outlet, boolean visible) 
	{
		this.id = id;
		this.outlet = outlet;
		this.visible = visible;
	}

	/**
	 * @return the outlet
	 */
	public String getOutlet() 
	{
		return outlet;
	}

	/**
	 * @param outlet the outlet to set
	 */
	public void setOutlet(String outlet) 
	{
		this.outlet = outlet;
	}

	/**
	 * @return the visible
	 */
	public boolean isVisible() 
	{
		return visible;
	}

	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) 
	{
		this.visible = visible;
	}

	/**
	 * @return the id
	 */
	public int getId() 
	{
		return id;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Outlet [id=" + id + ", outlet=" + outlet + ", visible=" + visible + "]";
    }	
}
