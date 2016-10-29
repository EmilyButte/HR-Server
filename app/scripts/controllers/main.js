'use strict';

/**
 * @ngdoc function
 * @name sampleApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sampleApp
 */
angular.module('hrappApp')
  .controller('MainCtrl', function ($scope, $location, $http, userService) {

    $scope.error = "";

    $scope.addUser = function() {
      var toPost = {
        id: 0,
        username: $scope.username,
        password: $scope.password
      };

      $http({
        method: 'POST',
        url: 'http://localhost8080/users',
        data: toPost
      }).
      then( function (response) {
        var message = response.data.message;
        if (message === "Success") {
          userService.setUser($scope.username);
          $location.path("/timecards");
        } else {
          $scope.username = "";
          $scope.password = "";
          $scope.error = "User already exists";
        }
      }, function (response) {
        console.log(response);
      });
    };

    $scope.login = function () {

      $http({
        method: 'GET',
        url: 'http://localhost8080/timecarddb/search/findByUsername?user_name=' + $scope.username
      }).
      then(function (response) {
        if(response.data._embedded.users[0] !== undefined) {
          var actualPassword = response.data._embedded.users[0].password;
        }

        if($scope.password === actualPassword) {
          userService.setUser($scope.username);
          $location.path("/timecards");
        } else {
          $scope.error = "Incorrect username or password";
        }
      });
    };
  });
