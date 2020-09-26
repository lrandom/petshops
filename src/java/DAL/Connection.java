/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.DriverManager;

/**
 *
 * @author Lrandom
 */
public class Connection {

    public static final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/test";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "koodinh";
    private static java.sql.Connection conn;
    public static java.sql.Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn
                    = DriverManager.getConnection(
                            MYSQL_CONNECTION,
                            DB_USERNAME,
                            DB_PASSWORD);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static boolean disconnect(){
        if(conn!=null){
            try {
                conn.close();  
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    };
}
