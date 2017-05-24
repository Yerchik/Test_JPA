<%--
  Created by IntelliJ IDEA.
  User: Yulian
  Date: 20.03.2017
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign in</title>

    <link href="/resources/css/style.default.css" rel="stylesheet">

</head>

<body class="signin">


<section>

    <div>
        <h4>Already a Member?</h4>
        <p>Sign in to your account</p>
        <form action="/sign-in-processing" method="post">
            <p>Input your credential:</p>

            <label for="login">Login:</label>
            <input name="username" id="login" type="text" placeholder="Login" required = "true">

            <label for="password">Password:</label>
            <input name="password" id="password" type="password" placeholder="Password" required="true">

            <button type="submit">Sign in!</button>

            <br><div id="errorMessage" hidden><div  >
                <strong>Oh snap!</strong> Wrong login or password<br>
            </div></div>

        </form>

        <p><a href="/sign-up" class="btn btn-primary btn-block">Not yet a Member? Create Account Now</a></p>
    </div>
</section>

<script src="/resources/JS/js/jquery-1.11.1.min.js"></script>
<script src="/resources/JS/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/resources/JS/js/bootstrap.min.js"></script>
<script src="/resources/JS/js/modernizr.min.js"></script>
<script src="/resources/JS/js/pace.min.js"></script>
<script src="/resources/JS/js/retina.min.js"></script>
<script src="/resources/JS/js/jquery.cookies.js"></script>
<script src="/resources/JS/js/custom.js"></script>
<script src="/resources/JS/signIn.js" ></script>
</body>
</html>
