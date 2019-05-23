<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
	img {
		width: 100px;
		height: 80px;
	}
	.con{
			width: 450px;
			height: 300px;
			border: 1px solid black;
			margin: auto;
			margin-top: 100px;
			padding: 15px;
		}
</style>
<script type="text/javascript">
	$(function(){
		//取得请求参数
		var id="${param.id}";
		$.get(
				"CompanyServlet",
				{m:"getById",id:id},
				function(d){
					$("#id").val(d.id);
					$("#name").val(d.name);
					$("#sname").val(d.sname);
					$("#img1").attr("src",d.filepath);
				},
				"json"
			);
	});
	function update() {
		//得到form表单DOM对象
		var form1=document.getElementById("form1");
		//模仿浏览器对表单的提交
		var formData=new FormData(form1);
		$.ajax({
			url:"CompanyServlet?m=update",
			type:"POST",
			data:formData,
			contentType:false,
			processData:false,
			success:function(data){
				alert(data?"修改成功":"修改失败");
				location.href="list.jsp";
			},
			dataType:"json"
		});
	}
</script>
</head>
<body>
	<div class="con">
		<form id="form1">
			 	<input type="hidden" name="id"  id="id"/><br>
				<p>公&nbsp&nbsp&nbsp司&nbsp&nbsp名&nbsp&nbsp称：<input type="text" name="name" id="name"/><br><p/>
				<p>公司法人名称：<input type="text" name="sname" id="sname"/><br><p/>
				<p>公&nbsp&nbsp&nbsp司&nbsp&nbsp照&nbsp&nbsp片：<img id="img1"/><br>
				<br>
				<input type="file" name="filepath" id="filepath"/><br>
				<p><input type="button" value="提交" onclick="update()"/><p/>
		</form>
	</div>
	
		
</form>
</body>
</html>