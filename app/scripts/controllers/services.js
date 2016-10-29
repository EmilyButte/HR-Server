'use strict';
/**
 * @ngdoc function
 * @name sampleApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the sampleApp
 */
angular.module('hrApp')
  .factory('userService', function () {
    function setUser(user) {
      sessionStorage.setItem("user", user);
    }

    function getUser(){
      return sessionStorage.getItem("user");
    }

    return {
      setUser: setUser,
      getUser: getUser
    };
  });
