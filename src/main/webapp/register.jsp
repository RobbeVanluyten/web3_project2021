<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1><span>Sign Up</span></h1>
        <nav>
            <ul>
                <li><a href="Servlet">Home</a></li>
                <li><a href="Servlet?command=Overview">Overview</a></li>
                <li id="actual"><a href="Servlet?command=Register">Register</a></li>
            </ul>
        </nav>
        <h2>
            Register
        </h2>

    </header>
    <main>
        <c:if test="${error!=null}">
            <div class="alert-danger">
                <ul>
                    <c:forEach items="${error}" var="message">

                        <li>${message}</li>

                    </c:forEach>
                </ul>
            </div>
        </c:if>

    <c:if test="${result!=null}">
        <div class="alert-danger">
            <ul>
                <c:forEach items="${result}" var="message">

                    <li>${message}</li>

                </c:forEach>
            </ul>
        </div>
    </c:if>


        <form method="post" action="Servlet?command=Add" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="userid">User id</label>
                <input type="text" id="userid" name="userid" value="${useridPreviousValue}" required></p>
            <p><label for="firstName">First Name</label><input type="text" id="firstName" name="firstName"
                                                               required value="${firstNamePreviousValue}"></p>
            <p><label for="lastName">Last Name</label><input type="text" id="lastName" name="lastName"
                                                             required value="${lastNamePreviousValue}"></p>
            <p><label for="email">Email</label><input type="email" id="email" name="email" required value="${emailPreviousValue}"></p>
            <p><label for="password">Password</label><input type="password" id="password" name="password"
                                                            required value="${passwordPreviousValue}"></p>
            <p><input type="submit" id="signUp" value="Sign Up"></p>

        </form>
    </main>
    <footer>
        &copy; Webontwikkeling 3, UC Leuven-Limburg
    </footer>
</div>
</body>
</html>
