package it.housework.db;

import java.sql.SQLException;

public class TestOutletDAO
{

    public static void main(String[] args) throws SQLException
    {
        long start, end;
        
        start = System.nanoTime();
        OutletDAO dao = new OutletDAO();
        end = System.nanoTime();
        System.out.format("Metodo conn: %d ms \n", (end-start) / 1000000);
        
               
        start = System.nanoTime();
        dao.create("cao", true);
        end = System.nanoTime();
        System.out.format("Metodo crea: %d ms \n", (end-start) / 1000000);
        
        start = System.nanoTime();
        dao.update(15, "ciao", false);
        end = System.nanoTime();
        System.out.format("Metodo update: %d ms \n", (end-start) / 1000000);
        
        start = System.nanoTime();
        dao.delete(13);
        end = System.nanoTime();
        System.out.format("Metodo update: %d ms \n", (end-start) / 1000000);
        
        
    }

}
