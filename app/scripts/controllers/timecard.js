'use strict';

/**
 * @ngdoc function
 * @name sampleApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the sampleApp
 */
angular.module('hrApp')
  .controller('TimeCardController', function ($scope, $location, userService) {
      $scope.name = userService.getUser();

        var userName = document.getElementsById('username').value;
        userService.setUser(userName);
        console.log(userName);
        $location.path("/timecard");
      });
  });
