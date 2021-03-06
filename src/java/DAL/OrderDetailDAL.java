/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import static DAL.Connection.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lrandom
 */
public class OrderDetailDAL extends Connection{
    public static final String TABLE_NAME = "order_detail";
    java.sql.Connection conn;
    public OrderDetailDAL() {
       this.conn = connect();
    }
    
    public int insert(
       OrderDAL.Payload payload
    ){
        String sql = "INSERT INTO "
                + ""+TABLE_NAME+""
                + "(user_id,total,address,"
                + "phone,name,status"
                + ",date_created) "
                + "VALUES(?,?,?,?,?,?,NOW())";
        try {
            PreparedStatement prp = this.conn.prepareStatement(sql);
            prp.setString(1, payload.user_id);
            prp.setDouble(2, payload.total);
            prp.setString(3, payload.address);
            prp.setString(4, payload.phone);
            prp.setString(5, payload.name);
            prp.setInt(6, 1);
            int affectRow =  prp.executeUpdate();
            if(affectRow==0){
                return 0;
            }
            
            
            try (ResultSet generatedKeys = prp.getGeneratedKeys()) {
             if (generatedKeys.next()) {
                return generatedKeys.getInt("id");
             }
             else {
                throw new SQLException("Creating user failed, no ID obtained.");
             }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
