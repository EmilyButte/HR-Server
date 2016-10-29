'use strict';

/**
 * @ngdoc function
 * @name sampleApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sampleApp
 */
angular.module('hrApp')
  .controller('MainCtrl', function ($scope, $location, userService) {
    $scope.storeName = function() {
      var name = document.getElementsById('username').value;
      userService.setUser(name);
      console.log(name);
      $location.path("/timecard");
    };
});
