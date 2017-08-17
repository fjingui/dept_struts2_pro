<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>池州分公司</title>

<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/homecss.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/ichart.1.2.1.min.js"></script>
<script src="js/home.js"></script>
<script>
function getCurDate()
{
var d = new Date();
var week;
switch (d.getDay()){
case 1: week="星期一"; break;
case 2: week="星期二"; break;
case 3: week="星期三"; break;
case 4: week="星期四"; break;
case 5: week="星期五"; break;
case 6: week="星期六"; break;
default: week="星期天";
}
var date = new Date();  //创建对象  
var year = date.getFullYear();     //获取年份  
var month =date.getMonth()+1;   //获取月份  返回0-11  
var days = date.getDate(); // 获取日  
//var w = date.getDay/);   //获取星期几  返回0-6   /0=星期天)  
var hours = date.getHours();  
var minutes = date.getMinutes()  
var secends = date.getSeconds(); 
var ndate = year+"年"+month+"月"+days+"日 "+hours+":"+minutes+":"+secends;
var divT=document.getElementById("showtime");
var curweek=document.getElementById("cur_week");
divT.innerHTML= ndate;
curweek.innerHTML=week
}
setInterval("getCurDate()",100);
</script>

</head>
<body>
<div class="container-fluid">

<div class="row">

<div class="col-md-9">
<div class=" main-title"> <i class="glyphicon glyphicon-stats"></i> 酬金构成分析</div>
<div class="row">

<div class="col-md-3" >
<div class="board">
<span>15.3</span><br>
酬金总额
</div>
</div>
<div class="col-md-3" >
<div class="board">
<span>15.3</span><br>
收入提成
</div>
</div>
<div class="col-md-3" >
<div class="board">
<span>15.3</span><br>
发展酬金
</div>
</div>
<div class="col-md-3" >
<div class="board">
<span>15.3</span><br>
其他收入
</div>
</div>
</div>
<div id="canvasDiv"></div>
<div class="talbe-tile"><i class="glyphicon glyphicon-sort-by-attributes-alt"></i> 当月酬金排名top10 <span class="small">单位：万元</span></div>
<table>
<thead><th>月份</th><th>三级单元</th><th>营业部</th><th>包区</th><th>承包人</th><th>总酬金</th><th>排名</th></thead>
<tbody>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
<tr><td>201707</td><td>东至县分公司</td><td>洋湖农村营业部</td><td>里街包区</td><td>吴民生</td><td>20.7</td><td>5</td></tr>
</tbody>
</table>
<div class="table-foot">数据来源：酬金团队</div>

</div>

<div class="col-md-3" >

<div class="user" >
<div ><span class="glyphicon glyphicon-user"></span> 方金贵&nbsp;&nbsp;欢迎你</div> 
<div id="showtime"></div>
<div style="text-indent:3em" id=cur_week> </div>
</div>
<div class="divider"> </div>
<div class="hour-data">
<div class="data-h">实时发展播报</div>
<p>【2017三季度】截止01日15时:全市发展完成情况如下：
移动170/宽带30/ITV37/不限量纯新增17/不限量改签38/爱家20/综合完成率31.8%</p>
<div class="parti-data">1、市电渠：9/0/0/1/1/0/60.0%</div>
<div class="parti-data">2、贵池区：32/5/8/3/8/4/48.9%</div>
<div class="parti-data">3、东至：44/7/11/3/10/9/35.6%</div>
<div class="parti-data">4、政企：12/8/1/0/3/2/33.2%</div>
<div class="parti-data">5、城市：13/5/9/2/4/2/33.1%</div>
<div class="parti-data">6、青阳：25/3/4/7/2/1/26.7%</div>
<div class="parti-data">7、市渠道：17/1/1/1/4/0/22.2%</div>
<div class="parti-data">8、九华山：2/0/2/0/1/0/21.7%</div>
<div class="parti-data">9、石台：10/1/1/0/3/2/15.9%</div>
<div class="parti-data">10、校园：2/0/0/0/0/0/2.7%</div>

</div>

</div>

</div>

</div>
</body>
</html>