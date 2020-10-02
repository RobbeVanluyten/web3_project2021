<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<span>Home</span>
			</h1>
			<nav>
				<ul>
					<li id="actual"><a href="Servlet">Home</a></li>
					<li><a href="Servlet?command=Overview">Overview</a></li>
					<li><a href="Servlet?command=Register">Register</a></li>
				</ul>
			</nav>
			<h2>Home</h2>

		</header>
		<main> Sed ut perspiciatis unde omnis iste natus error sit
		voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque
		ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae
		dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit
		aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos
		qui ratione voluptatem sequi nesciunt.

		<c:choose>
			<c:when test="${person!= null}">
			<p>Welcome, ${person.firstName}</p>
			<form method="post" action="Servlet?command=LogOut" novalidate="novalidate">
				<input type="submit" value="Log Out">
			</form>
			</c:when>
			<c:otherwise>
				<c:if test="${error !=null}">
					<p class="alert-danger">
						${error}
					</p>
				</c:if>
				<form method="post" action="Servlet?command=LogIn" novalidate="novalidate">
					<!-- novalidate in order to be able to run tests correctly -->
					<p><label for="logInPersonid">Your User id</label>
						<input type="text" id="logInPersonid" name="logInPersonid" required></p>
					<p><label for="logInPassword">Your Password</label>
						<input type="text" id="logInPassword" name="logInPassword" required ></p>
					<p><input type="submit" id="logIN" value="Log In"></p>

				</form>
			</c:otherwise>
		</c:choose>

		</main>
		<footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
	</div>
</body>
</html>