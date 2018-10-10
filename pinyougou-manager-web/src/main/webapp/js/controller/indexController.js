//控制层
app.controller('indexController' ,function($scope,$controller,loginservice){

    $controller('baseController',{$scope:$scope});//继承

    //读取列表数据绑定到表单中
    $scope.getName =function(){
        loginservice.getName().success(
            function(response){
                $scope.loginName = response.loginName;
            }
        );
    }

});
