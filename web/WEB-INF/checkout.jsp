<%-- 
    Document   : checkout
    Created on : Oct 3, 2020, 8:08:48 PM
    Author     : Lrandom
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="bundle.Main"/>
<!DOCTYPE html>
<html>
      <jsp:include page='./commons/header.jsp' />
    <body>
         <jsp:include page="./commons/nav.jsp"/>
         <div class="container">
             <br>
             <br>
             <form class="checkout-form" method="POST">
             <h4 class="title">
                 <fmt:message key="order_info"/>
             </h4>
             
             <ul>
                 <c:set var="index" value="0"/>
                 
                 <c:forEach items="${products}" var="product">
                     <li><strong>${product.getName()}</strong>&nbsp;x 
                         &nbsp;${cartItems.get(index).getQuantity()}
                         = 
                         <fmt:formatNumber type="currency" value="${product.getPrice()
                                                  *cartItems.get(index).getQuantity()}"/>
                         <input type="hidden" name="id" value="${product.getId()}"/>
                         <input type="hidden" name="quantity" value="${product.getPrice()
                                                  *cartItems.get(index).getQuantity()}"/>
                     </li>
                  <c:set var="index" value="${index=index+1}"/>
                 
                 </c:forEach>
                     
             </ul>
             
             <div>
                  <div class="form-group">
                   <label>Name</label>
                   <input type="text" class="form-control" name="name" placeholder="Enter Receiver Name">
                  </div>
                 
                  <div class="form-group">
                   <label>Address</label>
                   <input type="text" class="form-control" name="address" placeholder="Enter Address">
                  </div>
                 
                  <div class="form-group">
                   <label>Phone</label>
                   <input type="number" class="form-control" name="phone" placeholder="Enter Phone">
                  </div>
             </div>
             
             <div class="payment-method">
                 Phương thức thanh toán
                 <div> 
                     <input type="radio" value="1" name="payment_method"/>
                     <label>COD</label>
                 
                 </div>
                 
                 <div>
                     <input type="radio" value="2" name="payment_method"/>
                     <label>Paypal</label>

                 </div>
                 
                 <div>
                     <input type="radio" value="3" name="payment_method"/>
                     <label>Stripe</label>

                 </div>
             </div>
             
             <div>Phí ship: 
                 <fmt:formatNumber type="currency" value="65"/>
             </div>
             <div>VAT:
                 <fmt:formatNumber type="percent" value="0.1"/>
             </div>
             <div>Tiền hàng: ${totalPrice}</div>
             <div>Tổng tiền: 
                 <fmt:formatNumber type="currency" value="${((totalPrice*10)/100) + totalPrice + 65 }"/>
                 </div>
             
             <br>
             <button class="btn btn-primary">Make Order</button>
             </form>
             
         </div>
             <br>
             <br>
         <jsp:include page="./commons/footer.jsp"/>     
    </body>
    
    <style>   
        form.checkout-form{
            width:500px;
            margin:0px auto;
            padding:10px;
            box-shadow:3px 4px 7px 1px #61616126;
            webkit-box-shadow:3px 4px 7px 1px #61616126;
        }
        
        form.checkout-form .title{
            text-align: center;
        }
        
        form.checkout-form ul{
            padding:0px;
            margin:0px;
        }
        
        form.checkout-form ul li{
            list-style: none;
            padding:10px;
            border-bottom:1px dotted #cdcdcd;
        }
        
        form.checkout-form .payment-method{
            margin-bottom:10px;
            border-bottom:1px solid #cdcdcd;
        }
    </style>
</html>
