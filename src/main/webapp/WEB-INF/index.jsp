<!doctype html>
<html ng-app="springSecurityApp">
  <head>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Lance Fallon">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
    <!-- bower -->
    <link rel="stylesheet" href="bower/bootstrap/dist/css/bootstrap.css">
    <link rel="stylesheet" href="bower/bootstrap/dist/css/bootstrap-theme.css">
    
    <script src="bower/jquery/dist/jquery.min.js"></script>
    <script src="bower/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower/angular/angular.min.js"></script>
    <script src="bower/angular-animate/angular-animate.min.js"></script>
    <script src="bower/angular-bootstrap/ui-bootstrap-tpls.js"></script>
    <script src="bower/angular-mocks/angular-mocks.js"></script>
    <script src="bower/angular-resource/angular-resource.min.js"></script>
    <script src="bower/angular-route/angular-route.min.js"></script>
    <script src="bower/angular-sanitize/angular-sanitize.min.js"></script>
    
    <!-- Custom stylesheets -->
    <link rel="stylesheet" href="style/css/app.css">
    
    <!-- Angular -->
    <script src="js/app/app.js"></script>
    
    <!-- Controllers -->
    <script src="js/app/controllers/homeController.js"></script>
    <script src="js/app/controllers/headerController.js"></script>
    <script src="js/app/controllers/modals/loginModalController.js"></script>
    
    <!-- Services -->
    <script src="js/app/services/httpRequestInterceptor.js"></script>
    <script src="js/app/services/configService.js"></script>
    
    <!-- Directives -->

    <title>SpringSecurity</title>

  </head>
  <body>
  	<div ng-include="'templates/partial/header.html'"></div>
    <div ng-view></div>
    <div ng-include="'templates/partial/footer.html'"></div>
  </body>
</html>
