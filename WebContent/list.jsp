<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$.get(
			"CompanyServlet",
			{m:"list"},
			function(data){
				for(var i=0;i<data.length;i++){
					var d=data[i];
					$("#tb").append("<tr><td>"+d.id+"</td><td>"+d.name+"</td><td>"+d.sname+"</td><td><img src='"+d.filepath+"'/></td><td><button onclick=update('"+d.id+"')>修改</button></td><td><button onclick=del('"+d.id+"')>删除</button></td></tr>")
				}
			},
			"json"
			);
	});
	function update(id){
		location.href="update.jsp?id="+id;
	}
	function del(id){
		if(confirm("你确定删除id为"+id+"的公司吗?")){
		$.post(
		"CompanyServlet",
		{m:"del",id:id},
		function(d){
			alert(d?"删除成功":"删除失败");
			location.href="list.jsp";
		},
		"json"
		);
		}
	}
</script>
<style type="text/css">
	img {
		width: 100px;
		height: 80px;
	}
	table {
	padding-top:50px;
	margin: 20px;
	margin: auto;
	border=1px; 
	cellspacing=0px;
	color: black;
}
	#zhu{
	margin-left: 750px;
	}
</style>
</head>
<body>
<table id="tb">
	<tr>
		<th>公司序号</th>
		<th>公司名称</th>
		<th>公司法人名称</th>
		<th>公司照片</th>
		<th>操作</th>
		
	</tr>
</table><br/><br/>
<form action="add.jsp">
			<input type="submit" value="注册" id="zhu"/>
		</form>
</body>
</html>