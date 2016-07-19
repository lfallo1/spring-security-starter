angular.module('springSecurityApp')
        .controller('LoginModalCtrl', ["$scope", "$modalInstance", "$http", function ($scope, $modalInstance, $http) {

        	$scope.init = function(){
        		$scope.credentials = {};
        	};

          //sign in
        	$scope.signin = function(){

                //set auth header
        	    var headers = {
        	    		authorization : "Basic " + btoa($scope.credentials.username + ":" + $scope.credentials.password)
        	    };

              //attempt login
        	    $http.get('user', {headers : headers}).then(function(res) {

        	    	//should save result in a front end auth service (for now just resolves with user object)
        	    	$modalInstance.close(res.data.principal);
        	    },function(err) {
        	    	$scope.error = "Invalid credentials";
        	    });

        	};

          //cancel out of login modal
        	$scope.cancel = function(){
        		$modalInstance.dismiss();
        	};

        	$scope.init();

        }]);
