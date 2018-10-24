 //控制层 
app.controller('itemCatController' ,function($scope,$compile,$controller   ,itemCatService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=itemCatService.update( $scope.entity ); //修改  
		}else{
			serviceObject=itemCatService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		itemCatService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		itemCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    //查询商品分类信息
    $scope.findByParentId =function(parentId,parentName){
        itemCatService.findByParentId(parentId).success(
            function(response){

                //当parentid 为 0 面包屑导航默认
				if(response.length > 0){
                    $scope.list = response;
				}
				//当响应数据不是空，响应数据的parentid不是 0 ，就去添加面包屑导航，为了使得动态添加的html起作用，需要使用到 $compile来处理
				if(response.length > 0 && response[0].parentId != 0){

                    var html = '<li><a href="javascript:void(0);" ng-click="breadcrumbs($event,'+parentId+')"  >'+parentName+'</a></li>';
                    var $html = $compile(html)($scope);
					$(".breadcrumb").append($html);
				}
				//当继续点击查看下级分类，没有数据了。 就不再展示了
				if(response.length <= 0){
					alert("没有了");
				}
				console.log(response);
            }
        );
    }

    //面包屑导航
    $scope.breadcrumbs =function($event,parentId){
        itemCatService.findByParentId(parentId).success(
            function(response){
				//删除当前点击 面包屑导航的后面的 导航栏
                $($event.target).parent().next().empty().remove();

                //当parentid 为 0 面包屑导航 不用改
                if(response.length > 0){
                    $scope.list = response;
                }

                console.log(response);
            }
        );
    }







});	
