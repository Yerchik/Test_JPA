/**
 * Created by Yerchik on 23.05.2017.
 */
$(document).ready(function () {

    if (window.location.search == "?error"){
        $("#errorMessage").show(300);
    }
    if (window.location.search != "?error"){
        $("#errorMessage").hide();
    }
})