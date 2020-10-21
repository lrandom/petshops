<%-- 
    Document   : login
    Created on : Oct 7, 2020, 8:54:27 PM
    Author     : Lrandom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page='./../commons/header.jsp' />
    <body>
        <jsp:include page="./../commons/nav.jsp"/>
        <div class="container">
            
            <div class="form">
        <form method="POST">
            <div class="form-group">
                <label>Username</label>
                <input type="text" name="username" class="form-control" placeholder="Enter username">
            </div>
            
            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" class="form-control" placeholder="Password">
            </div>
            
            <button type="submit" class="btn btn-primary">
                Submit
            </button>
        </form>
            </div>
        </div>
        
    </body>
    <jsp:include page="./../commons/footer.jsp"/>  
    
    <style>
        .form{
            width:500px;
            margin:0px auto;
            margin-top:100px;
        }
    </style>
</html>
