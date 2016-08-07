<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>交付中心信息管理系统</title>
<link href="<%=basePath %>css/login.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/custom.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/global.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="<%=basePath %>css/font-awesome.css">
<script type="text/javascript" src="<%=basePath %>resources/jquery/jquery-1.7.2.js"></script>
<!--[if IE 8]>
    <style type="text/css">
    body{
        background-image : none;
        filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='image/bg_login.jpg', sizingMethod='scale');
    }
    </style>
 <![endif]-->
<script type="text/javascript">
 function submittest(e){
	 if(e.keyCode==13) 
	 { 
	 var button=document.getElementById("login_submit"); 
	 button.onclick(); 
	 }  
 }

</script> 
</head>
<body>
	 <div class="window">
		<!-- 登录框 -->
		<form id='loginForm' action="login" method="post"
			onsubmit="return checkData()" onkeydown="return submittest(event)" >
			<div class='login'>
				<div class="warning_txt" id="warning_txt_lgn">${errorInfo}</div>
				<div class="head">
					<span>Sign In</span>
				</div>
				<div class="login_form">
					<ul>
						<li><i class="icon-user"></i> <input id='login_user'
							name='loginName' type='text' placeholder="华大邮箱账号" ></li>
						<li><i class="icon-key"></i> <input id='login_password'
							name='loginPass' type='password' placeholder="密码"></li>
					</ul>
				</div>
				<input type="submit" value="Login In" class="btn_submit" id="login_submit"
					onclick="displayerrorDiv()">
				<!--    <div class='btn_submit'  id="btn_login">
                    <span class='icon_submit'>
                        <i class="icon-signin"></i>
                        <i class="icon-refresh icon-spin"></i>
                    </span>
                    登 录
                </div> -->
				<div class='tips'>
					推荐使用<a href="chrome_installer.exe">谷歌浏览器</a>，享受更畅快的浏览体验!
				</div>
			</div>
		</form> 
		<!-- 注册框 -->
	<!-- 	<div class="deg">
			<div class="warning_txt" id="warning_txt_reg"></div>
			<div class="head">
				<span>资料补全</span>
				<div class="close" id="close">
					<img src="image/close_bg.png" width="28">
				</div>
			</div>
			<div class="deg_form">
				<ul>
					<li><i class="icon-user"></i> <input id='input_degName'
						type='text' placeholder="请输入真实姓名"></li>
					<li><i class="icon-map-marker"></i> <select id='zoneSelect'></select>
					</li>
					<li><i class="icon-sitemap"></i> <input id="input_group"
						type='text' placeholder="请选择责权(模糊搜索)"></li>
				</ul>

				<div class="groupWrap">
					<table id='groupGrid'></table>
				</div>

			</div>
			<div class="btn_submit" id="btn_reg">
				<span class='icon_submit'> <i class="icon-ok"></i>
				</span> 提 交
			</div>
		</div>
	</div> -->
	
	<script type="text/javascript" src="<%=basePath %>app/login.js"></script>
</body>
</html>
