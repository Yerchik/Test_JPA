<%--
  Created by IntelliJ IDEA.
  User: Yerchik
  Date: 22.05.2017
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<h1 id="credentials"></h1>
<sec:authorize access="hasRole('ROLE_USER')">
    <div>
        <p><a href="#" onclick="addShow()">Add</a></p>
        <div id="add" hidden>
            <label for="amount">Amount:</label>
            <input name="amount" id="amount" type="number"> <br>

            <label for="description">Description:</label>
            <input name="description" id="description" type="text"><br>

            <label for="year">Year:</label>
            <select name="year" id="year">
            </select>
            <label for="month">Month:</label>
            <select name="month" id="month">
            </select>
            <label for="day">Day:</label>
            <select name="day" id="day">
            </select><br>

            <label for="currencyMarking">select a currency: <select name="currencyMarking" id="currencyMarking">
            </select></label><br>
            <div id="errorMessage"></div>
            <button id="addButton" onclick="addSpending()">Add!</button>
        </div>
        <p><a href="#" onclick="listShow()">List</a></p>
        <div id="list" hidden>
            <div id="alldates">


            </div>
        </div>
        <p><a href="#" onclick="clearShow()">Clear</a></p>
        <div id="clear" hidden>
            <label for="date">Select date:</label>
            <select name="date" id="date"></select>
            <br>
            <button id="clearButton" onclick="clearDate()">Clear!</button>
        </div>
        <p>Total by <label for="currencyTotal"><select name="currencyTotal" id="currencyTotal">
        </select></label></p>
        <div id="total" hidden></div>
    </div>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<p>Add currency</p>
<label for="type">type:</label>
<input name="type" id="type">
<label for="marking">marking:</label>
<input name="marking" id="marking">
    <button id="addcurrency" onclick="addCurrency()">Add!</button>
    </sec:authorize>

    <p><a href="/sign-in?logout">logout</a></p>


    <script src="/resources/JS/js/jquery-1.11.1.min.js"></script>
    <script src="/resources/JS/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="/resources/JS/js/bootstrap.min.js"></script>
    <script src="/resources/JS/js/modernizr.min.js"></script>
    <script src="/resources/JS/js/pace.min.js"></script>
    <script src="/resources/JS/js/retina.min.js"></script>
    <script src="/resources/JS/js/jquery.cookies.js"></script>
    <script src="/resources/JS/js/custom.js"></script>
    <script src="/resources/JS/home.js"></script>

</body>
</html>
