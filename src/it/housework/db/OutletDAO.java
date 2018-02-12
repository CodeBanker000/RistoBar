/**
 * 
 */
package it.housework.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.housework.models.Outlet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gives the CRUD method for the table outlet: create, retrieve, update and
 * delete 
 * 
 * @author  Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class OutletDAO
{
    
    /**
     * Construct of the class, gives the connection 
     */
    public OutletDAO () {}
    
    /**
     * 
     * @param outlet
     * @param visible
     * @return
     * @throws SQLException 
     */
    public int create(String outlet, boolean visible) throws SQLException
    {
        Connection conn = DBconnect.getConnection();
        
        final String sql = "INSERT INTO public.tb_outlet (outlet_name, visible) VALUES (?, ?)";
        
        int rs = 0;
        try {

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, outlet);
            st.setBoolean(2, visible);
            rs = st.executeUpdate();


            conn.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public List<Outlet> read()
    {
        List<Outlet> list = new ArrayList<>();
        
        Connection conn = DBconnect.getConnection();
        
        final String sql = "SELECT * FROM tb_outlet";
                                   
        try {
             PreparedStatement st = conn.prepareStatement(sql);
                
                ResultSet rs = st.executeQuery();
                
                if (rs.next()) {                
                    Outlet us = new Outlet(rs.getInt("id_outlet"), 
                                           rs.getString("outlet_name"),
                                           rs.getBoolean("visible"));
                    
                    list.add(us);
                } else {
                    list = null;
                }
                
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
    
    
    
    public int update(Integer id, String outlet, boolean visible)
    {
        Connection conn = DBconnect.getConnection();
        
        final String sql = "UPDATE public.tb_outlet SET outlet_name = ?, visible = ? WHERE id_outlet = ?";
        
        int rs = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, outlet);
            st.setBoolean(2, visible);
            st.setInt(3, id);
            
            rs = st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    public int delete(Integer id)
    {
        Connection conn = DBconnect.getConnection();
        
        final String sql = " DELETE FROM public.tb_outlet WHERE id_outlet = ?";
        
        int rs = 0;
        
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setInt(1, id);
            
            rs = st.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}