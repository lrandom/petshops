<%-- 
    Document   : home.jsp
    Created on : Sep 26, 2020, 8:36:27 PM
    Author     : Lrandom
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css"/>
    </head>
    <body>
        <div class="container wrapper">

            <div class="row">
                <%
                    ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
                    for (Product product : products) {
                %>

                <div class="col-md-4 col-xs-12">
                    <div class="card product-item" style="width: 18rem;">
                        <img class="card-img-top" src="<%=product.getPreview()%>" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title"><%=product.getName()%></h5>
                            <div class="price"><%=product.getPrice() %></div>
                            <p class="card-text"><%=product.getContent()%></p>
                            <a href="#" class="btn btn-primary">Add to cart</a>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>

        </div>
    </body>
</html>
