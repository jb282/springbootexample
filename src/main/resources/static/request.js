var app = angular.module("request", []);

app.controller("RequestCtrl", function ($http) {
    var controller = this;
    controller.beitraege = [];


    controller.getAllPersons = function () {
        $http.get("/getAllBeitraege").then(function (value) {
            controller.beitraege = value.data;
        }, function (reason) {
            window.alert("Error");
        })
    };

    controller.newBeitrag = function () {
        var landName = $('#landName').val();
        var produktName = $('#produktName').val();

        var newBeitrag = {
            landName: landName,
            produktName: produktName
        };
        $http.post("/newBeitrag", newBeitrag)
    };

});