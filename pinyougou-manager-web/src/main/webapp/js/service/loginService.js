//服务层
app.service('loginservice',function($http){

    //读取列表数据绑定到表单中
    this.getName = function(){
        return $http.get('../login/name.do');
    }

});
