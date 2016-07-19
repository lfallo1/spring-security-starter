'use strict';
/**
 * Main module of the application.
 */
angular.module('springSecurityApp', [
            'ngAnimate',
            'ngRoute',
            'ngSanitize',
            'ngResource',
            'ui.bootstrap'
        ])
        .config( ['$httpProvider', '$interpolateProvider', '$routeProvider', function($httpProvider, $interpolateProvider, $routeProvider) {
            $httpProvider.interceptors.push('httpRequestInterceptor');
            $httpProvider.defaults.useXDomain = true;
            delete $httpProvider.defaults.headers.common['X-Requested-With'];

            $routeProvider
                    .when('/', {
                        templateUrl: 'templates/home.html',
                        controller: 'HomeCtrl',
                    }).
                    otherwise({
                        redirectTo: '/'
                    });
        }])
        .run(['$rootScope', 'ConfigService', function ($rootScope, ConfigService) {

        		//initial configuration properties
        		ConfigService.initConfig();

        }]);
