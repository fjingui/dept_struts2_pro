<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售管理平台</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/shopman.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>

<div class="header">
	<div class="header_left"> 
		<div class="logo"><img src="img/logo.jpg" /></div> 
    	<div class="title">农特产品销售管理平台</div>
    </div>
	<div class="header_right">    	   
       <div class="operate"> 欢迎您:<span id="empeename" style="color: Red; font-family: Tahoma"></span> <a>注销</a>  <a>修改密码</a> </div> 
	</div>  
    <div style="clear:both"></div>
</div>

<div id="navbar" class="nav-menu">
   <ul id="menus" class="">
   
     <li id="item1"><a href="#">首页</a></li>
     
     <li id="item2"><a href="#">数据管理</a>
        <ul > 订单管理
          <li><a href="#">订单查询</a>
        </ul>
        <ul >销售品管理
          <li><a href="#">添加销售品</a> </li>
          <li><a href="#">修改销售品</a> </li>
        </ul>
         <ul >销售品图片管理
          <li><a href="#">添加图片</a> </li>
          <li><a href="#">删除图片</a> </li>
        </ul>
        <ul >商家管理
          <li><a href="#">添加商家</a> </li>
          <li><a href="#">修改商家</a> </li>
        </ul>
         <ul >用户资料管理
          <li><a href="#">修改用户资料</a> </li>
        </ul>
      </li>
      
      <li id="item3"><a href="#">日志查询</a></li>
   </ul>
  </div>
  
 <div id="content"><a href="#"></a> </div> 

</body>
</html>