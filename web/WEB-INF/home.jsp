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
<%@taglib prefix="u" uri="/WEB-INF/tlds/utils.tld" %>
<fmt:setLocale value="vi-VN"/>
<fmt:setBundle basename="bundle.Main"/>
<!DOCTYPE html>
<html>
    <jsp:include page='./commons/header.jsp' />
    <body>
        
        <jsp:include page="./commons/nav.jsp"/>
        <br>
        <br>
        <div class="container wrapper">

            <div class="row">
              
                <c:forEach items="${products}" var="product">
                         <div class="col-md-4 col-xs-12">
                    <div class="card product-item" style="width: 18rem;">
                        <img class="card-img-top" src="${product.getPreview()}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">${product.getName()}</h5>
                            <div class="price">
                              
                                <fmt:formatNumber type="currency" value="${product.getPrice()}"/>
                            </div>
                            <p class="card-text">${product.getContent()}</p>
                            
                            <a href="add-to-cart?id=${product.getId()}" class="btn btn-primary">
                                <fmt:message key="add_to_cart"/>
                          
                            </a>
                        </div>
                    </div>
                </div>
                                <!--<u:ProductItem item="${product}"/>-->
                                <!--<u:BlockSwearWord content="you are bitch, fuck you"/>-->
                </c:forEach>     
            </div>

        </div>
                
        <jsp:include page="./commons/footer.jsp"/>     
       
    </body>
</html>
