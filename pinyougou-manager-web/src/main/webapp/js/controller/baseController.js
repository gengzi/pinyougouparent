// 基础的controller
app.controller("baseController",function ($scope) {
    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    }

    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        //$scope.findPage( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);

    }


    $scope.ids= [];

    /**
     * 更新复选框的信息
     */
    $scope.updateSelection = function ($event,id) {
        if($event.target.checked){
            $scope.ids.push(id); //添加到数组
        }else{
            var idx = $scope.ids.indexOf(id);
            $scope.ids.splice(idx,1); //删除
        }
        alert($scope.ids);
    }
});