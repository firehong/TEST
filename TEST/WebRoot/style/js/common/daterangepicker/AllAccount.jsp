<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AllAccount.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" /> 
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css" /> 
    <link rel="stylesheet" type="text/css" media="all" href="daterangepicker-bs3.css" />
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.js"></script> 
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.dataTables.min.js"></script> 
     <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="daterangepicker.js"></script>
    <script type="text/javascript" language="javascript" src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script> 
    <script type="text/javascript" src="moment.js"></script>

  </head>
  
<body>
  <div id="container">
    <table id="example" class="table table-striped table-bordered"> 
    <thead>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>备注</th>
            <th>状态</th>
            <th>创建时间</th>
            <th>最后操作时间</th>
            <th>帐号类型</th>
            
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allAccount }" var="account">
           <tr>           
	            <td>${account.code }</td>
	            <td>${account.name }</td>
	            <td>${account.note }</td>
	            <td>${account.status }</td>
	            <td>${account.created }</td>
	            <td>${account.updated }</td>
	            <td>${account.type }</td>
           </tr>
        </c:forEach>
    </tbody>
   </table>
   </div>
      <div class="well">

               <div class="dropdown" style="display: inline-block;">
                 <a data-toggle="dropdown" class="btn btn-primary" href="#">Regular dropdown</a>
                 <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                   <li><a href="#">item</a></li>
                 </ul>
               </div>

               <div id="reportrange2" class="btn" style="display: inline-block; background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                  <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                  <span></span> <b class="caret"></b>
               </div>

               <script type="text/javascript">
               $(document).ready(function() {
                  $('#reportrange2 span').html(moment().subtract('days', 29).format('MMMM D, YYYY') + ' - ' + moment().format('MMMM D, YYYY'));
                  $('#reportrange2').daterangepicker();
               });
               </script>

            </div>
</body>   
</html>
