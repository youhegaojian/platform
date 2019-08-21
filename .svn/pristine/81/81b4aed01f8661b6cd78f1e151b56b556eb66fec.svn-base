$(function() {
	tableInit();
});
function tableInit(){
	layui.use(['layer', 'table'], function(){
		var layer = layui.layer
		,table = layui.table;
		table.render({
		    elem : '#demo'
		    ,title : '任务表'
		    ,url : 'defineScheList/'
		    ,page : true //开启分页
		    ,cols: [
		    	[ //表头
					{type: 'numbers',title:'序号'},
					{field: 'taskName', title: '任务类型', sort : true,
					  templet:function(row){
						 return '<a style="cursor:pointer;" onclick="openWin(\''+row.type+'\')" >'+row.taskName+'</a>'
					  }},
					{field: 'className', title: '调用的类名称',sort : true},
					{field: 'methodName', title: '类方法名称', sort : true},
					{field: 'period', title: '周期', sort : true,hide:true },
					{fixed: 'right', title: '操作', align:'center',
						templet:function(row){
							return '<a style="cursor:pointer;color:#93BB28;" onclick="immiexecute(\''+row.type+'\')" >执行批次</a>'
						}
					}
		    	]
			]

		});
		  
	})
}
		
function immiexecute(type) {
	var data={};
	data.taskid=$("#taskid").val();
	data.type=type;
	$.ajax({
		type : 'post',
		url : 'addTask/',
		dataType : 'json',
		data : data,
		success : function(data) {
			if(data!=null){
				var url = "sche/sche_list?type="+data.type;
				var index = Math.ceil(Math.random()*1000);
				var title = '作业列表';

				parent.x_admin_add_to_tab(title,url,true);
				//window.open("sche_list?type="+data.type);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.info(XMLHttpRequest.status);
			console.info(XMLHttpRequest.readyStat);
			console.info(textStatus);
		}
	});
}

var openWin = function(type){

	var url = "sche/sche_list?type="+type;
	var index = Math.ceil(Math.random()*1000);
	var title = '作业列表';

	parent.x_admin_add_to_tab(title,url,true);

}
