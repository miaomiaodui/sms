<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
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
	function add() {
		//得到form表单DOM对象
		var form1=document.getElementById("form1");
		//模仿浏览器对表单的提交
		var formData=new FormData(form1);
		$.ajax({
			url:"CompanyServlet?m=add",
			type:"POST",
			data:formData,
			contentType:false,
			processData:false,
			success:function(data){
				alert(data);
				alert(data?"添加成功":"添加失败");
				location.href="list.jsp";
			},
			datatype:"json"
		});
	}

</script>
</head>
<body>
<div class="con">
<form id="form1">
	<p>公&nbsp&nbsp&nbsp司&nbsp&nbsp名&nbsp&nbsp称：<input type="text" name="name" id="name"/><br><p/>
	<p>公司法人名称：<input type="text" name="sname" id="sname"/><br><p/>
	<p>公&nbsp&nbsp&nbsp司&nbsp&nbsp照&nbsp&nbsp片：<input type="file" name="filepath" id="filepath"/><br><p/>
	<p><input type="button" value="提交" onclick="add()"/><p/>
	
</form>
</div>
</body>
</html>