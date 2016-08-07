<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${loginUser eq null}">
	<script type="text/javascript">
		document.location.href="login.jsp";
	</script>
</c:if>
<c:if test="${loginUser ne null}">
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DataBaseInit</title>
<!-- 引入Font Awesome的css文件 -->
<link type="text/css" rel="stylesheet" href="css/font-awesome.css">
<link rel="stylesheet" href="css/custom.css">
<script type="text/javascript" src="resources/jquery/jquery-1.7.2.js"></script>
<script type="text/javascript" src="app/auxiliary/Auxiliary.js"></script>
<script type="text/javascript">
	// 提示消息
	    var addSuccessMsg = '<s:text name="ext.alert.msg.addsuccess"/>';//添加成功
	    var editSuccessMsg = '<s:text name="ext.alert.msg.updatesuccess"/>';//修改成功
	    var deleteSuccessMsg = '<s:text name="ext.alert.msg.deletesuccess"/>';//删除成功
	    var deleteConfirmMsg = '<s:text name="ext.alert.msg.deleteConfirm"/>';//确认删除
	    var dataIsUse = '<s:text name="ext.alert.msg.dataIsUse"/>';//数据已被使用
	    var alertMsg = '<s:text name="ext.alert.msg.alertmsg"/>';//操作提示
	    var errorMsg ='<s:text name="ext.alert.msg.useerror"/>';// '操作失败!'
	    var connTimeOutMsg = '<s:text name="ext.alert.msg.conntimeout"/>';//连接超时
	    var requesterror = '<s:text name="ext.alert.requesterror"/>';//非法请求
	    //var hasLoginOutMsg = '已退出登录!';
	    var unSelectedMsg = '<s:text name="ext.alert.msg.unselect"/>';//'请选择需要操作的记录!'
	    var gridTitleOrderNo='<s:text name="ext.grid.tilte.orderno"/>';//序号
	    var gridTitleCreateUser='<s:text name="ext.grid.tilte.createuser"/>';//创建人
	    var gridTitleCreateTime='<s:text name="ext.grid.tilte.createtime"/>';//创建时间
	    var gridTitleUpdateUser='<s:text name="ext.grid.tilte.updateuser"/>';//修改人
	    var gridTitleUpdateTime='<s:text name="ext.grid.tilte.updatetime"/>';//修改时间
	    var queryalertmanysizemsg='<s:text name="query.alert.manysize.msg"/>';//维度控制提示

	// 获得用户信息

	function getLoginUser() {
	      return {
	        userId        :   '${loginUser.id}',        // 主键，用户ID
	        loginName     :   '${loginUser.loginName}',     // 登陆账号
	        passWord      :   '${loginUser.loginPass}',      // 密码
	        userName      :   '${loginUser.userName}',      // 真实姓名
	        userEmail     :   '${loginUser.emailAddress}'    // E-mail
	      }
	}

</script>
<!-- The line below must be kept intact for Sencha Cmd to build your application -->
<script id="microloader" type="text/javascript" src="bootstrap.js"></script>
</head>
<body class="loading_body">
    <div id="loading_wrap" class="loading_wrap"><img src="resources/image/loading.gif"></div>
</body>
   </html>
</c:if>