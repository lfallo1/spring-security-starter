'use strict';
angular.module('springSecurityApp').factory('httpRequestInterceptor', ['$q', '$location', '$injector', function ($q, $location, $injector) {
	
    return {
        'responseError': function (rejection) {
            return $q.reject(rejection);
        }
    };
}]);
