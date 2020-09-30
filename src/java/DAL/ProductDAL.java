/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lrandom
 */
public class ProductDAL extends Connection{
    java.sql.Connection conn;
    public ProductDAL() {
       this.conn = connect();
    }
    
    public ArrayList<Product> getProducts(){
       ArrayList<Product> products = new ArrayList<>();
       String sql = "SELECT * FROM products";
        try {
          PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
          ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
             Product product = new Product();
             product.setId(resultSet.getInt("id"));
             product.setName(resultSet.getString("name"));
             product.setPreview(resultSet.getString("preview"));
             product.setPrice(resultSet.getDouble("price"));
             product.setContent(resultSet.getString("content"));
             products.add(product);
          }
        } catch (Exception e) {
           return null;
        }
        return products;
    }
    
    public Product getProductById(int id){
       Product product = new Product();
       String sql = "SELECT * FROM products WHERE id = ?";
        try {
          PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
          preparedStatement.setInt(1,id);
          ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
             product.setId(resultSet.getInt("id"));
             product.setName(resultSet.getString("name"));
             product.setPreview(resultSet.getString("preview"));
             product.setPrice(resultSet.getDouble("price"));
             product.setContent(resultSet.getString("content"));
           
          }
        } catch (Exception e) {
            return null;
        }
        return product;
    }
}
