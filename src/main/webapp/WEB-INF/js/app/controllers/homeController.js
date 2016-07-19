(function() {
	'use strict';

	angular.module('springSecurityApp').controller('HomeCtrl', [ '$rootScope', '$scope', '$modal', '$http', 'ConfigService',
	                                                       function MainCtrl($rootScope, $scope, $modal, $http, ConfigService) {

			    $scope.signin = function(){
		            var modalInstance = $modal.open({
		                templateUrl: 'templates/modal/loginModal.html',
		                controller: 'LoginModalCtrl',
		                size: 'md'
		            });

		            //handle promise resolve/reject
		            modalInstance.result.then(function (user) {
		                console.log(user);
		                $scope.user = user;
		            }, function (err) {
		                if (err !== undefined && err.emailError) {
		                    $log.error(err.emailError);
		                }
		            });
			    };

			    $scope.logout = function(){
			    	$http.get('logout').then(function(res){
			    		$scope.user = undefined;
			    		console.log(res);
			    	}, function(err){
			    		console.log(err);
			    	});
			    };

				$scope.init = function(){

					//init controller

				};

				$scope.init();

	}]);

})();
