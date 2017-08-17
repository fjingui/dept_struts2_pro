/**
 * 
 */
			$(function(){
				var data = [
				         	{
				         		name : '酬金总额',
				         		value:[78,83.3,86.3,74,90,84],
				         		color:'#1385a5'
				         	},
				         	{
				         		name : '收入提成',
				         		value:[60,80,105,125,108,120],
				         		color:'#c56966'
				         	},
				         	{
				         		name : '发展酬金',
				         		value:[20,50,52,61,59,71],
				         		color:'#d56966'
				         	},
				         	{
				         		name : '其他收入',
				         		value:[14,22,52,32,26,37],
				         		color:'#f56966'
				         	}
				         ];
				var chart = new iChart.ColumnMulti2D({
						render : 'canvasDiv',
						data: data,
						labels:["201701","201702","201703","201704","201705","201706"],
						title : '五级包区酬金趋势',
						subtitle : '酬金构成逐月比较,单位:万元',
						footnote : '数据来源：销售中心',
						width : 800,
						height : 400,
						background_color : '#ffffff',
						legend:{
							enable:true,
							background_color : null,
							border : {
								enable : false
							}
						},
						coordinate:{
							background_color : '#f1f1f1',
							scale:[{
								 position:'left',	
								 start_scale:0,
								 end_scale:140,
								 scale_space:20
							}],
							width:600,
							height:260
						}
				});
				chart.draw();
			});