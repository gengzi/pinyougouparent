// 品牌服务的controller
app.controller("brandController",function ($scope,$controller,brandService) {

    $controller('baseController',{$scope:$scope});//继承

    //查询所有
    $scope.findAll = function () {
       brandService.findAll().success(function (response) {
            $scope.list = response;
        });
    }


    $scope.serachEntity = {};

    //查询分页数据
    $scope.search = function (pageNum,pageSize) {
        brandService.search(pageNum,pageSize,$scope.serachEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;
            }
        );
    }


    //更新品牌
    $scope.save = function (){
        var methodName='add';//方法名称
        if($scope.entity.id!=null){//如果有ID
            methodName='update';//则执行修改方法
        }
        brandService.save(methodName,$scope.entity).success(
            function(response){
                // 请求成功执行代码
                if(response.success == true){
                    $scope.reloadList();//重新加载
                }else{
                    alert("请求失败，请稍后再试");
                }
            }
        )}

    /**
     * 查找一条品牌的信息
     * @param id
     */
    $scope.findOne = function (id) {
        brandService.findOne(id).success(
            function(response){
                $scope.entity= response;
            }
        )};


    /**
     * 关闭按钮事件
     */
    $scope.shutdown = function () {
        alert($scope.entity.name);
    }



    /**
     * 删除复选框选中的品牌信息
     */
    $scope.delete = function () {
        brandService.delete($scope.ids).success(
            function (response) {
                // 请求成功执行代码
                if(response.success == true){
                    $scope.reloadList();//重新加载
                }else{
                    alert("请求失败，请稍后再试");
                }
            }
        );
    }
});