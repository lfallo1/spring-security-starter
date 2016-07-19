(function () {
    'use strict';

    angular.module('springSecurityApp').service('ConfigService', ConfService);

    ConfService.$inject = ['$http'];
    function ConfService($http) {

    	var settings = [];

        var service = {};

        service.initConfig = function () {
            //initialize app with any necessary configurations
        };

        service.getConfig = function(){
        	return settings;
        };

        return service;
    }

})();
