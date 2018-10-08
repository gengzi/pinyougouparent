// 品牌服务
app.service('brandService',function ($http) {

    //查询所有
    this.findAll = function () {
        return $http.get("../brand/findAll.do");

    }

    //条件查询的分页显示
    this.search = function (pageNum,pageSize,serachEntity) {
       return $http.post("../brand/findPage.do?pageNum="+pageNum+"&pageSize="+pageSize,serachEntity);
    }

    //新建或者更新
    this.save = function (methodName,entity) {
        return $http.post("../brand/"+methodName+".do",entity);
    }

    //查找一个品牌信息
    this.findOne = function (id) {
        // return $http.get("../brand/findOne.do?id="+id);

        $http({
            method: "GET",
            url: "../brand/findOne.do",
            params: {
                id: id
            }
        });
    }
    //删除
    this.delete =function(ids){
        return $http({
            method: "POST",
            url: "../brand/delete.do",
            data: {
                ids: ids
            },
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }, //将其变为 form-data 参数形式
            transformRequest: function(obj) {
                var str = [];
                for (var s in obj) {
                    str.push(encodeURIComponent(s) + "=" + encodeURIComponent(obj[s]));
                }
                return str.join("&");
            }
        });
    }


    /**
     *  获取下拉框中的品牌信息
     */
    this.selectOptionsList = function () {
        return $http.get("../brand/selectOptionsList.do");
    }




});