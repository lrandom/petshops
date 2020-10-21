/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Product;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lrandom
 */
public class UserDAL extends Connection{
    public static final String TABLE_NAME = "users";
    java.sql.Connection conn;
    public UserDAL() {
       this.conn = connect();
    }
    
    public User getById(int id){
       User user = new User();
       String sql = "SELECT * FROM "+TABLE_NAME+" WHERE id = ?";
        try {
          PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
          preparedStatement.setInt(1,id);
          ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
             user.setId(resultSet.getString("id"));
             user.setUsername(resultSet.getString("username"));
          }
        } catch (Exception e) {
            return null;
        }
        return user;
    }
    
    public User getByUserNameAndPassword(String username, String password){
       User user = new User();
       String sql = "SELECT * FROM "+TABLE_NAME+" WHERE username = ? AND password = ?";
        try {
          PreparedStatement preparedStatement = 
                  this.conn.prepareStatement(sql);
          preparedStatement.setString(1,username);
          preparedStatement.setString(2,helpers.Helper.getMd5(password));
          ResultSet resultSet = preparedStatement.executeQuery();
          
          //check co du lieu hay khong
          if(!resultSet.isBeforeFirst()){
              return null;
          }
          
          //neu có du lieu
          while(resultSet.next()){
             user.setId(resultSet.getString("id"));
             user.setUsername(resultSet.getString("username"));
             user.setPhone(resultSet.getString("phone"));
             user.setFullname(resultSet.getString("fullname"));
             user.setAddress(resultSet.getString("address"));
          }
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
