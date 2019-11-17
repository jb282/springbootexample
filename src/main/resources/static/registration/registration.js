var app = angular.module("registration", []);

app.controller("RegistrationCtrl", function ($http) {
    var controller = this;
    controller.users = [];

    /**
     * Pulls data from Registration form
     * Creates User Object
     * Sends Object to Backend
     */
    controller.newUser = function () {
        var username = $('#username').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        var newUser = {
            username: username,
            password: password,
            password2: password2
        };
        $http.post("/newUser", newUser).then(function () {
            window.location.assign("/login/login.html")
        }, function (reason) {
            if (reason.data === 1) {
                controller.passwordErr();
            } else {
                controller.usernameErr();
            }
        })
    };

    controller.usernameErr = function () {
        $("#alert").append("<div class='alert alert-danger alert-dismissible'>" +
            "<strong>Error!</strong> Username to short or invalid</div>");
        setTimeout(function () {
            $("#alert").empty();
        }, 4000)
    };

    controller.passwordErr = function () {
        $("#alert").append("<div class='alert alert-danger'>" +
            "<strong>Error!</strong> Passwords do not match</div>");
        setTimeout(function () {
            $("#alert").empty();
        }, 4000)
    };

});