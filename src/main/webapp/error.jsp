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
            <span>Error</span>
        </h1>
        <nav>
            <ul>
                <li id="actual"><a href="Servlet">Home</a></li>
                <li><a href="Servlet?command=Overview">Overview</a></li>
                <li><a href="Servlet?command=Register">Register</a></li>
            </ul>
        </nav>
       <h2>OEPS</h2>

    </header>
    <main>
    <p>${error}</p>
    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>
</body>
</html>