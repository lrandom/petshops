/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAL.ProductDAL;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lrandom
 */
public class Cart {
    public static final String CART_NAME = "CART";
    ArrayList<CartItem> items;
    ArrayList<Product> products = new ArrayList<>();

    public Cart(HttpSession session) {
        try {
            if(session.getAttribute(CART_NAME)==null){
              this.items = new ArrayList<>();
            }else{
              this.items =(ArrayList<CartItem>)session.getAttribute(CART_NAME);
            }
        } catch (Exception e) {
            this.items = new ArrayList<>();
        }
    }
    
    public void addToCart(CartItem item){
        boolean isExist = false;
        for (int i = 0; i < this.items.size(); i++) {
            CartItem existItem = this.items.get(i);
            //nếu tồn tại sp trong giỏ hàng, tăng sl
            if(item.getId()==existItem.getId()){
                existItem.setQuantity(existItem.getQuantity()+item.getQuantity());
                this.items.set(i, existItem);
                isExist = true;
                break;
            }
        }
        if(!isExist){
          this.items.add(item);
        }
    }
    
    public void removeToCart(int index){
       this.items.remove(index);
    }
    
    public void syncWithSession(HttpSession session){
       session.setAttribute(CART_NAME, this.items);
    }
    
    
    public double getTotalPrice(){
       getProducts();
       double sum = 0;
       for (int i = 0; i < this.items.size(); i++) {
            sum += (items.get(i).getQuantity()*products.get(i).getPrice());
       }
       return sum;
    }
    
    public ArrayList<Product> getProducts(){
       ProductDAL productDAL = new ProductDAL();
       this.products.clear();
       for (int i = 0; i < items.size(); i++) {
            Product product = productDAL.getProductById(items.get(i).getId());
            this.products.add(product);
       }
       return products;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
    
    
}
