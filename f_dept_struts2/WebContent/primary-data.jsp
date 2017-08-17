<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c" %> 
<% String path=request.getContextPath();
   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/fdatastyle.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<script>

  $(function () { 
	  $("button").click(function(){
	  $.getJSON("json/queryjson",
		  {mons: $("select:last").val()},
		 function(data){  
			  var trs="";
		//	  var jdata=eval("("+data+")");
			  $.each(JSON.parse(data),function(n,value){
			  trs+="<tr><td>"+value.month_id+"</td> <td>"+value.dept_id+"</td><td>"+value.dept_name+"</td><td>"+value.total_fen+"</td><td>"+value.charge+"</td> </tr>";
			  })
		  $("tbody").empty().append(trs);
		  })
	  
})
	}) 
	/* $(function () { 
		  $("button").click(function(){
			  alert(123);
			  $.ajax({
				  type: "post",
                  url: "json/queryjson",
                  dataType: "json",
                  data: {mons: $("select:last").val()},
                  success: function(data){
                	  var trs="";
              			  $.each(data,function(n,value){
              			  trs+="<tr><td>"+value.month_id+"</td> <td>"+value.dept_id+"</td><td>"+value.dept_name+"</td><td>"+value.total_fen+"</td><td>"+value.charge+"</td> </tr>";
              			  alert(456);
              			  });
              		  $("table").empty().append(trs);
                  }
				  });
			  alert(789);
			  });
		  }); */
</script>
<body>

<div class="body-left"> 
 <select class="form-control">
 ${sessionScope.dept} 
</select>  

 <select class="form-control">
 ${sessionScope.months} 
</select>  

<button type="button" class="btn btn-info" id="month">
查询</button>
</div>

<div class="body-right">

<table class="table table-hover " > 
<thead><tr><th>月份</th><th>营业部ID</th> <th>营业部</th> <th>KPI得分</th><th>收入</th></tr></thead>
<tbody >
<c:forEach items="${sessionScope.list}" var="tbean" >
<tr><td>${tbean.month_id}</td>  <td>${tbean.dept_id}</td><td>${tbean.dept_name}</td><td>${tbean.total_fen}</td><td>${tbean.charge}</td> </tr>
</c:forEach>
</tbody>
</table>

</div>

</body>
</html>