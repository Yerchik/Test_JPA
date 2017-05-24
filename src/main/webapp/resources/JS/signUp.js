/**
 * Created by Yerchik on 23.05.2017.
 */

function signUp() {

    if(validate()){
        cleanErrorMessages()
        $.ajax({
            url:'/sign-up',
            method:'POST',
            contentType:'application/json',
            data: JSON.stringify(getUserObject()),
            success:function () {
                window.location.assign("/sign-in");
                cleanErrorMessages();
            }
        });
        setTimeout( function showSignUpErrorMessage() {
            var html = "<div class='alert alert-danger'>"
                +"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"
                +"<strong>Oh snap!</strong> Somebody has used this Email or Login."
                +"</div>"
            $("#errorMessage").append(html);
        }, 4500);
    }
}

function validate() {
    var object = getUserObject();
    var nameAndSecondNameRegex = /[^0-9]/;
    var loginRegex = /^([а-яґєії`´ʼ’ʼ’]+)/ui;

    if(object.name == "" || !object.name.match(nameAndSecondNameRegex)){
        cleanErrorMessages();
        showErrorMessage("Name");
        return false;
    }
    if(object.secondName == "" || !object.secondName.match(nameAndSecondNameRegex)){
        cleanErrorMessages();
        showErrorMessage("Secondname");
        return false;
    }
    if(object.login == "" || object.login.match(loginRegex)){
        cleanErrorMessages();
        showErrorMessage("Login");
        return false;
    }
    if(object.password != $("#passwordConfirm").val() || object.password == ""){
        cleanErrorMessages();
        showErrorMessage("Password");
        return false;
    }
    return true;

}

function getUserObject() {
    return {name:$("#name").val(), secondName: $("#secondName").val(), login: $("#login").val(), password: $("#password").val()};
}

function showErrorMessage(message) {

    var html = "<div >"
        +"<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;</button>"
        +"<strong>Oh snap!</strong> Change a <a href='#' class='alert-link'>"+message+"</a> and try submitting again."
        +"</div>"
    $("#errorMessage").append(html);
}

function cleanErrorMessages() {
    $("#errorMessage").empty();
}

