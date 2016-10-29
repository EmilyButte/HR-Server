'use strict';

/**
 * @ngdoc overview
 * @name sampleApp
 * @description
 * # sampleApp
 *
 * Main module of the application.
 */
angular
  .module('hrappApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/timecards', {
        templateUrl: 'views/timecards.html',
        controller: 'TimeCardCtrl',
        controllerAs: 'timecards'
      })
      .when('/notfound', {
        templateUrl: '404.html',
      })
      .otherwise({
        redirectTo: '/notfound'
      });
  });
