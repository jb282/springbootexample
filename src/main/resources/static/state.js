var app = angular.module('state', ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/home");

    $stateProvider
        .state('home', {
            url: "/home",
            templateUrl: "home.html"
        })
        .state('request', {
            url: "/request",
            templateUrl: "request.html"
        })
        .state('profil', {
            url: "/profil",
            templateUrl: "profil.html"
        })
});