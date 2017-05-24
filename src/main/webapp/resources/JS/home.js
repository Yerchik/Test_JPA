/**
 * Created by Yerchik on 24.05.2017.
 */

$(document).ready(function () {

    $.ajax({
        url: '/user/info',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            $("#credentials").text(response.name + " " + response.secondName);
        }
    })

    $.ajax({
        url: '/getAllCurrency',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            var s1 = document.querySelector("#currencyMarking").options;
            var s2 = document.querySelector("#currencyTotal").options;
            for (var i = 0; i < s1.length; i++) {
                s1[i] = null;
            }
            for (var i = 0; i < s2.length; i++) {
                s2[i] = null;
            }
            for (var j = 0; j < response.length; j++) {
                s1[j + 1] = new Option(response[j].typeOfCurrency, response[j].marking, true);
                s2[j + 1] = new Option(response[j].marking, response[j].typeOfCurrency, true);
            }

        }
    })
    date();


})

function date() {
    var s1 = document.querySelector("#year").options;
    var s2 = document.querySelector("#month").options;

    for (var i = 1; i < 4; i++) {
        s1[i] = new Option(2015 + i, 2015 + i, true);
    }

    for (var i = 1; i < 13; i++) {
        s2[i] = new Option(i, i, true);
    }
}

$("#month").on('change', function () {
    var s = document.querySelector("#day").options;
    if (document.getElementById('month').value == 1 || document.getElementById('month').value == 3 || document.getElementById('month').value == 5
        || document.getElementById('month').value == 7 || document.getElementById('month').value == 8 || document.getElementById('month').value == 10
        || document.getElementById('month').value == 12) {
        clearDay();
        for (var i = 1; i < 32; i++) {
            s[i] = new Option(i, i, true);
        }
    }
    else if (document.getElementById('month').value == 2) {
        clearDay();
        for (var i = 1; i < 29; i++) {
            s[i] = new Option(i, i, true);
        }
    }
    else {
        clearDay();
        for (var i = 1; i < 31; i++) {
            s[i] = new Option(i, i, true);
        }
    }
})
function clearDay() {
    var s = document.querySelector("#day").options;
    for (var i = 1; i <= s.length; i++) {
        s[i] = null;
    }

}

function addShow() {
    clearAdd();
    $("#add").slideToggle(300);

}

function listShow() {
    $("#alldates").empty();
    $.ajax({
        url: '/getAllDates',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                getListByDate(response[i]);
            }
            $("#list").slideToggle();
        }
    })
}

function getListByDate(date) {
    $.ajax({
        url: '/getByDates/' + date,
        method: 'GET',
        contentType: 'application/json',
        success: function (response2) {
            $("#alldates").append(date + "<br>");
            for (var i = 0; i < response2.length; i++) {
                $("#alldates").append(response2[i].amount + " " + response2[i].currency + " " + response2[i].description + "<br>");
            }
        }
    })
}

function clearShow() {
    var s = document.querySelector("#date").options;
    for (var i = 1; i <= s.length; i++) {
        s[i] = null;
    }
    $.ajax({
        url: '/getAllDates',
        method: 'GET',
        contentType: 'application/json',
        success: function (response) {
            for (var i = 0; i < response.length; i++) {
                s[i + 1] = new Option(response[i], response[i], true);
            }
            $("#clear").slideToggle(300);
        }
    })
}

function addSpending() {
    if (validateAdd()) {
        $.ajax({
            url: '/add/',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(getSpending()),
            success: function () {
                cleanErrorMessages();
                alert('Added!')
                $("#add").hide();
            }
        });
    }
}

function getSpending() {
    return {
        amount: $("#amount").val(), year: $("#year").val(), month: $("#month").val(), day: $("#day").val(),
        description: $("#description").val(), currency: $("#currencyMarking").val()
    };
}

function validateAdd() {
    var object = getSpending();
    if (object.amount != '' && object.year != '' && object.currency != '' && object.day != '' &&
        object.description != '' && object.month != '') {
        return true;
    }
    else {
        showErrorMessage();
    }
}
function showErrorMessage() {

    var html = "<div >"
        + "<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"
        + "<strong>Oh snap!</strong> fill all lines"
        + "</div>"
    $("#errorMessage").append(html);
}

function cleanErrorMessages() {
    $("#errorMessage").empty();
}

function clearAdd() {
    document.getElementById('amount').value = '';
    document.getElementById('year').value = '';
    document.getElementById('month').value = '';
    document.getElementById('day').value = '';
    document.getElementById('description').value = '';
    document.getElementById('currencyMarking').value = '';
}


function clearDate() {
    $.ajax({
        url: '/clearDate/' + document.getElementById('date').value,
        method: 'POST',
        contentType: 'application/json',
        success: function () {
            alert('Date cleared')
            $("#clear").hide();
        }
    })
}

$("#currencyTotal").on('change', function () {
    $("#total").empty()
    if (document.getElementById('currencyTotal').value != '') {
        $.ajax({
            url: '/total/' + document.getElementById('currencyTotal').value,
            method: 'GET',
            contentType: 'application/json',
            success: function (response) {
                $("#total").append(response);
                $("#total").show(300);
            }
        })
    }
})

function addCurrency() {
    if (validateCurrency()) {
        $.ajax({
            url: '/addCurrency',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(getCurrency()),
            success: function () {
                alert("Added!")
            }
        });
    }
}

function getCurrency() {
    return {typeOfCurrency: $("#type").val(), marking: $("#marking").val()}
}

function validateCurrency() {
    var object = getCurrency();
    if (object.marking != "" && object.typeOfCurrency != "") {
        return true
    }
    else {
        return false;
    }
}