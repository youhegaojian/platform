var xData = [];
var yData1 = [];
var yData2 = [];
var yData3 = [];
var yData4 = [];
var yData5 = [];
var yData6 = [];
var fileData = [];
var rec_analyse_Data = [];
var rec_analyse_ext_Data = [];
var takeTime = [];
var param = {};
var title;
var myChart = {};
$(function() {
	selectInit();
	myChart = echarts.init(document.getElementById('main'));
//	lineInit();
});

var selectInit = function() {
	$.ajax({
		type : "post",
		url : 'echarts_line_list',
		dataType : "json",
		success : function(data) {
			var select = $("#data_source");
			let cont = '';
			var select_month = data.monthList;
			for (var i = 0; i < select_month.length; i++) {
				cont = cont + '<option value="' + select_month[i].month + '">'
						+ select_month[i].month + '</option>';
			}
			param.month = select_month[0].month;
			lineInit(param);
			select.append(cont);
			layui.use('form', function() {
				var form = layui.form;
				form.render('select');
				form.on('select(data_source)', function(data) {
					param.month = data.value;
					lineInit(param);
				});
			});
		}
	});
}

var lineInit = function(param) {
	var month = $("#data_source").val();
	$.ajax({
				type : "post",
				url : 'echarts_line_list',
				dataType : "json",
				data : param,
				success : function(data) {
					if (data != null) {
						xData = [];
						yData1 = [];
						yData2 = [];
						yData3 = [];
						yData4 = [];
						yData5 = [];
						yData6 = [];
						// 获取map对象进行遍历
						var my_map_x = data.detailList;
						$.each(my_map_x, function(i, v) {
							xData.push(v.time);
						});
						var my_map_y = data.yList;
						$.each(my_map_y, function(i, v) {
							if (v.type == "001") {
								if (v.count != 0) {
									yData1.push(v.count);
								} else {
									yData1.push(0);
								}

							}
							if (v.type == "002") {
								if (v.count != 0) {
									yData2.push(v.count);
								} else {
									yData2.push(0);
								}

							}
							if (v.type == "003") {
								if (v.count != 0) {
									yData3.push(v.count);
								} else {
									yData3.push(0);
								}

							}
							if (v.type == "004") {
								if (v.count != 0) {
									yData4.push(v.count);
								} else {
									yData4.push(0);
								}

							}
							if (v.type == "005") {
								if (v.count != 0) {
									yData5.push(v.count);
								} else {
									yData5.push(0);
								}

							}
							if (v.type == "006") {
								if (v.count != 0) {
									yData6.push(v.count);
								} else {
									yData6.push(0);
								}

							}
						});
						chartInit(yData1, yData2, yData3, yData4, yData5,
								yData6, xData);
					}
				}
			});
}

function char_bar_init(taskTime, xData, legendData, yData) {

	var seriesData = [];
	for (var i = 0; i < legendData.length; i++) {

		var series = {
			name : legendData[i],
			type : 'bar',
			yAxisIndex : 0,
			data : yData[i]
		};

		seriesData.push(series);
	}

	seriesData.push({
		name : '耗时(min)',
		type : 'line',
		yAxisIndex : 1,
		data : taskTime
	});

	var option = {
		title : {
			text : title,
			align : 'center',
			padding : [ 2, 430 ]
		},
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			top : '15%',
		},
		legend : {
			padding : 40,
			data : legendData
		},
		toolbox : {
			show : true,
			feature : {
				mark : {
					show : true
				},
				dataView : {
					show : true,
					readOnly : false
				},
				magicType : {
					show : true,
					type : [ 'line', 'bar' ]
				},
				restore : {
					show : true
				},
				saveAsImage : {
					show : true
				}
			}
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : xData,
			axisLabel : {
				rotate : 60
			}
		} ],
		yAxis : [ {
			name : '数据量',
			type : 'value',
		}, {
			name : '耗时(min)',
			type : 'value',
			splitLine : { // 是否显示y轴刻度线
				show : false
			}
		} ],
		series : seriesData
	};
	myChart.clear();
	myChart.setOption(option);
}

function chartInit(yData1, yData2, yData3, yData4, yData5, yData6, xData) {
	var option1 = {
		title : {
			text : '作业趋势折线图',
			align : 'center',
			padding : [ 20, 450 ]
		},
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			top : '30%',
			containLabel : true
		},
		legend : {
			padding : 70,
			data : [ '专利关键字提取', '论文关键词提取', '科研项目关键词提取', '词性还原', '论文学科提取',
					'英文期刊论文国家提取' ]
		},
		toolbox : {
			show : true,
			feature : {
				magicType : {
					show : true,
					type : [ 'stack', 'tiled' ]
				},
				saveAsImage : {
					show : true
				}
			}
		},
		xAxis : {
			type : 'category',
			boundaryGap : false,
			data : xData,
			axisLabel : {
				rotate : 60
			}
		},
		yAxis : {
			name : '任务次数',
			type : 'value'
		},
		series : [ {
			name : '专利关键字提取',
			type : 'line',
			smooth : true,
			data : yData1,
			itemStyle: {
	            color: '#9932CC'
		    }
		}, {
			name : '论文关键词提取',
			type : 'line',
			smooth : true,
			data : yData2,
			itemStyle: {
	            color: 'red'
		    }
		}, {
			name : '科研项目关键词提取',
			type : 'line',
			smooth : true,
			data : yData3,
			itemStyle: {
	            color: '#EEEE00'
		    }
		}, {
			name : '词性还原',
			type : 'line',
			smooth : true,
			data : yData4,
			itemStyle: {
	            color: 'blue'
		    }
		}, {
			name : '论文学科提取',
			type : 'line',
			smooth : true,
			data : yData5,
			itemStyle: {
	            color: '#9ACD32'
		    }
		}, {
			name : '英文期刊论文国家提取',
			type : 'line',
			smooth : true,
			data : yData6,
			itemStyle: {
	            color: '#BBFFFF'
		    }
		} ]
	};

	myChart.clear();
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option1);
	myChart.on('click', function(params) {
		title = params.seriesName;
		var type;
		switch (params.seriesName) {
		case "专利关键字提取":
			type = '001';
			break;
		case "论文关键词提取":
			type = '002';
			break;
		case "科研项目关键词提取":
			type = '003';
			break;
		case "词性还原":
			type = '004';
			break;
		case "论文学科提取":
			type = '005';
			break;
		case "英文期刊论文国家提取":
			type = '006';
			break;
		}

		$.ajax({
			type : "post",
			url : 'echarts_bar_list',
			dataType : "json",
			data : {
				time : params.name,
				type : type
			},
			success : function(data) {
				xData = [];
				yData = {};
				takeTime = [];
				legendData = [];
				// 用来去除重名情况
				idData = [];

				if (data != null) {

					$.each(data, function(i, v) {
						if (v.takeTime > 0) {
							takeTime.push(v.takeTime);
						} else {
							takeTime.push(0);
						}

						if (idData.indexOf(v.fileId) == -1) {
							idData.push(v.fileId);
							xData.push(v.filename);
						}

						if (legendData.indexOf(v.tabName) == -1) {
							legendData.push(v.tabName);
						}

					});

					for (var i = 0; i < legendData.length; i++) {
						var yArr = [];
						$.each(data, function(j, v) {
							if (v.tabName == legendData[i]) {
								yArr.push(v.finishRec);
							}
						});
						yData[i] = yArr;
					}

					char_bar_init(takeTime, xData, legendData, yData);
				}
			}
		});
	});
}
