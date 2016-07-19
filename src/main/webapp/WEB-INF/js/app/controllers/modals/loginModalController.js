angular.module('springSecurityApp')
        .controller('LoginModalCtrl', ["$scope", "$modalInstance", "$http", function ($scope, $modalInstance, $http) {

        	$scope.init = function(){
            //init controller
        	};

          //sign in
        	$scope.signin = function(){

              //set auth header (backend hard coded to only allow bryan / secret)
        	    var headers = {
        	    		authorization : "Basic " + btoa("bryan:secret")
        	    };

              //attempt login
        	    $http.get('user', {headers : headers}).success(function(res) {

                //should save result in a front end auth service (for now just logs that login was successful)
        	    	console.log(res);
        	    	$modalInstance.close(res);
        	    }).error(function(err) {
        	    	$modalInstance.dismiss(err);
        	    });

        	};

          //cancel out of login modal
        	$scope.cancel = function(){
        		$modalInstance.dismiss();
        	};

        	$scope.init();

        }]);
