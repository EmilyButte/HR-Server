'use strict';

angular.module('hrappApp')
  .controller('TimeCardCtrl', function ($scope, $http, userService) {

      $scope.name = userService.getUser();

      $scope.getTimeCards = function(){

        $http({
          method: 'GET',
          url: 'http://localhost8080/timecarddb/search/findByUsername?user_name=' + $scope.name
        }).
        then (function(response) {
          $scope.timecards = response.data._embedded.timecards;
        });
      };

      $scope.submitTimeCards = function() {
        var start = document.getElementsById("start");
        var end = document.getElementsById("end");

        var toPost = {
          id: 0,
          startTime: start.value,
          endTime: end.value
        };

        $http({
          method: 'POST',
          url: 'http://localhost8080/timecards',
          data: toPost
        }).
        then(function (response) {
          start.value = "";
          end.value = "";
          if(response.data.message === "Error. Time could not be parsed") {
            $scope.error = "Invalid time format.";
          }
        }, function (response) {
          $scope.error = "Something went wrong.";
        });
      };
  });
