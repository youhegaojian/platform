var type = null;
$(function() {
	htmlInit();
});

var htmlInit = function(){
	if(parseUrl()!= undefined){
		type = parseUrl()['type'];
	}
	tableInit(type);
}

setTimeout('htmlInit()',60*1000); //指定1分钟刷新一次

function tableInit(type) {
	var param = {};
	param.type = type;
	
	layui.use([ 'layer', 'table'], function() {
		var layer = layui.layer
		, table = layui.table;
		var tabInst = table.render({
			elem : '#demo',
			title : '任务表',
			url : 'ScheList/',
			where : param,
			page : true,
			cols : [[
				{type: 'numbers', title:'序号',},
				{
					field : 'taskId',
					title : '任务号',
					sort : true,
					templet : function(data) {
						return '<a style="cursor:pointer;" onclick="viewDetail(\''
								+ data.taskId
								+ '\')">'
								+ data.taskId
								+ '</a>'
					}
				}, {
					field : 'type',
					title : '任务类型',
					sort : true,
					templet : function(row){
						return translateType(row.type);
					}
				}, 
				{
					field : 'beginTime',
					title : '任务开始时间',
					sort : true
				}, {
					field : 'endTime',
					title : '任务结束时间',
					sort : true
				}, {
					field : 'state',
					title : '状态',
					sort : true,
					edit:true,
					templet : function(row){
						return translateStatus(row.state);
					}
				}
			]]
		});
		table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
			  if (obj.data.state=="3"||obj.data.state=="报错") {
				obj.data.state=="3";
			  }else if(obj.data.state=="4"||obj.data.state=="完成"){
				  obj.data.state=="4";
			  }else if(obj.data.state=="1"||obj.data.state=="等待执行"){
				  obj.data.state=="1";
			  }else if(obj.data.state=="2"||obj.data.state=="执行中"){
				  obj.data.state=="2";
			  }
			  $.ajax({
					type : 'post',
					url : 'UpdateScheduleState/',
					dataType : 'json',
					data :obj.data,
					success : function(data) {
						if(data){
							layer.msg("修改成功");
							htmlInit();
						}else{
							layer.msg("修改失败");
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.info(XMLHttpRequest.status);
						console.info(XMLHttpRequest.readyStat);
						console.info(textStatus);
					}
				});
			});
		
	})

}
var viewDetail = function(taskId) {

	var url = "sche/detail_list?task_id="+taskId;
	var title = '作业明细列表';

	parent.x_admin_add_to_tab(title,url,true);

};


/**
 * 将状态值转化为含义
 * @param status 0:未开始；1:等待执行；2:执行中；3:报错；4：完成
 */
function translateStatus(status){
	if(status==='0'){
		return "<span style='color:#FF9933'> 未开始</span>";
	}else if(status==='1'){
		return "<span style='color:#FF9933'> 等待执行</span>";
	}else if(status==='2'){
		return "<span style='color:#4DB361' > 执行中</span>";
	}else if(status==='3'){
		return "<span style='color:#CC3333' > 报错</span>";
	}else if(status==='4'){
		return "<span style='color:#4DB361' > 完成</span>";
	}
}

function translateType(type){
	if(type==='001'){
		return "<span> 专利关键字提取</span>";
	}else if(type==='002'){
		return "<span> 论文关键词提取</span>";
	}else if(type==='003'){
		return "<span> 科研项目关键词提取</span>";
	}else if(type==='004'){
		return "<span> 词性还原</span>";
	}else if(type==='005'){
		return "<span> 论文学科提取</span>";
	}else if(type==='006'){
		return "<span> 英文期刊论文国家提取</span>";
	}
}


function parseUrl() {
	var url = location.href;
	var i = url.indexOf('?');
	if (i === -1)
		return;
	var queryStr = url.substr(i + 1);
	var arr1 = queryStr.split('&');
	var arr2 = new Object();
	for (i in arr1) {
		var ta = arr1[i].split('=');
		arr2[ta[0]] = ta[1];
	}
	return arr2;
}
