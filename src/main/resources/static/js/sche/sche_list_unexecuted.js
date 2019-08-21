$(function() {
	tableInit();
});
function tableInit(){
	layui.use(['layer', 'table', 'form'], function(){
		var layer = layui.layer
		,table = layui.table
		,form = layui.form;
		var tableInst = table.render({
		    elem : '#sche_list_unexecuted'
		    ,title : '任务表'
		    ,url : 'unexecutedScheList/'
		    ,page : true //开启分页
		    ,cols: [
		    	[ //表头
					{type: 'numbers',title:'序号'},
					{field: 'id', title: '作业id', sort : true},
					{field: 'plType', title: '作业类型',sort : true},
					{field: 'userId', title: '用户名', sort : true},
					{field: 'downloadTime', title: '上传时间', sort : true,
					}
		    	]
			]

		});
		form.on('select(pltype)', function(data){
			  var param = {};
			  param.pltype = data.value;
			  tableInst.reload({				  
				  where: param //设定异步数据接口的额外参数
			  }); 
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
