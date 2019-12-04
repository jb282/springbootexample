var app = angular.module("profil", []);
app.controller("ProfilCtrl", function ($http) {
    var controller = this;

    function getUrlVars() {
        var vars = {};
        var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
            vars[key] = value;
        });
        return vars;
    }

    controller.getUser = function () {
        var id = $('#id').val();

        $http.get("/getUser/"+ getUrlVars()["id"]).then(function (value) {
            controller.user = value.data;
        }, function (reason) {
            window.alert("Error");
        })
    };


});