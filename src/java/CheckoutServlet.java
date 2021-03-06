/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAL.OrderDAL;
import Model.Cart;
import Model.Product;
import Model.User;
import config.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lrandom
 */
public class CheckoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckoutServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        
        User user = (User)session.getAttribute("user");
        if(user==null){
            //ko dang nhap 
            response.sendRedirect(Constants.BASE_NAME+ "login");
            return;
        }
        if(session.getAttribute(Cart.CART_NAME)==null){
              request.getRequestDispatcher("/").forward(request, response);
        }
        Cart cart = new Cart(request.getSession());
        ArrayList<Product> products = cart.getProducts();
            request.setAttribute("products", products);
            request.setAttribute("totalPrice", cart.getTotalPrice());
            request.setAttribute("cartItems", cart.getItems());
            request.setAttribute("user", user);
            request.getRequestDispatcher("WEB-INF/checkout.jsp").forward(request, response);
    }
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            response.sendRedirect(Constants.BASE_NAME+"login");
            return;
        }
        
        String fullname = (String)request.getAttribute("fullname");
        String address = (String)request.getAttribute("address");
        String phone = (String)request.getAttribute("phone");
        int paymentMethod = (int)request.getAttribute("payment_method");
        double total = (double)request.getAttribute("total_price");
        
        OrderDAL.Payload payload = new OrderDAL.Payload();
        payload.name = fullname;
        payload.address = address;
        payload.phone = phone;
        payload.total = total;
        payload.user_id = user.getId();
        
        OrderDAL dal = new OrderDAL();
        int insertId =  dal.insert(payload);
        
        if(insertId==0){
            //lỗi ko đc
        }else{
            //insert vao order detail
        }
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
