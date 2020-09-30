<%-- 
    Document   : home.jsp
    Created on : Sep 26, 2020, 8:36:27 PM
    Author     : Lrandom
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <jsp:include page='./commons/header.jsp' />
    <body>
        <jsp:include page="./commons/nav.jsp"/>
        <br>
        <br>
        <div class="container wrapper">
            <div class="row">
                <table class="table no-border">
                    <thead>
                    <tr>
                     <td>Tên sp</td>
                     <td>Giá 1 sp</td>
                     <td>SL</td>
                     <td>Tổng giá</td>
                     <td></td>
                    </tr>
                    </thead>
                    <tbody>
                <c:set var="index" value="0"/>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.getName()}</td>
                        <td>
                          <fmt:formatNumber type="currency" value="${product.getPrice()}"/>
                        </td>
                        <td>${cartItems.get(index).getQuantity()}</td>
                        <td>
                            <fmt:formatNumber value="${cartItems.get(index).getQuantity()*product.getPrice()}" type="currency"/>
                        </td>
                        <td>
                            <a class="btn btn-primary">+</a>
                            <a class="btn btn-primary">-</a>
                        </td>
                         <c:set var="index" value="${index=index+1}"/>
                 
                    </tr>
                </c:forEach>   
                    </tbody>
                    
                    <tfoot>
                        <tr>
                            <td colspan="5">
                                Tổng giá
                                <strong>
                            <fmt:formatNumber value="${totalPrice}" type="currency"/>
                                </strong>
                                </td>
                        </tr>
                    <tfoot>
                </table>
            </div>
        </div>
        <jsp:include page="./commons/footer.jsp"/>         
    </body>
</html>
