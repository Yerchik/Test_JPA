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

    <title>Sign up</title>

    <link href="/resources/css/style.default.css" rel="stylesheet">

</head>

<body>
<div id="bah" hidden>HHHHHHHHAAAAAAAA</div>
<h4 >Create a new account</h4>
<p >Please enter your credentials below</p>

<div id="errorMessage"></div>


    <label for="name">Name:</label>
    <input name="name" id="name" type="text"> <br>

    <label for="secondName">Second name:</label>
    <input name="secondName" id="secondName" type="text"><br>

    <label for="login">Login:</label>
    <input name="login" id="login" type="text"><br>

    <label for="password">Password:</label>
    <input name="password" id="password" type="password"><br>

    <label for="passwordConfirm">repeat password:</label>
    <input name="passwordConfirm" id="passwordConfirm" type="password"><br>



    <button type="submit" onclick="signUp()">Registration!</button><br>
<a href="/sign-in" class="btn btn-primary btn-block">Already a Member? Sign In</a>


<script src="/resources/JS/js/jquery-1.11.1.min.js"></script>
<script src="/resources/JS/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/resources/JS/js/bootstrap.min.js"></script>
<script src="/resources/JS/js/modernizr.min.js"></script>
<script src="/resources/JS/js/pace.min.js"></script>
<script src="/resources/JS/js/retina.min.js"></script>
<script src="/resources/JS/js/jquery.cookies.js"></script>
<script src="/resources/JS/js/custom.js"></script>
<script src="/resources/JS/signUp.js" ></script>
</body>
</html>
