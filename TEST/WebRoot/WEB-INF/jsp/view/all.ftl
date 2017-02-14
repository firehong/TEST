<!DOCTYPE html>
<html>
  <head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    
	<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" /> 
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css" /> 
    <link rel="stylesheet" type="text/css" media="all" href="../style/js/common/daterangepicker/daterangepicker-bs3.css" />
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.js"></script> 
    <script src="http://cdn.gbtags.com/datatables/1.10.5/js/jquery.dataTables.min.js"></script> 
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" language="javascript" src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="../style/js/common/daterangepicker/moment.js"></script>
    <script type="text/javascript" src="../style/js/common/daterangepicker/daterangepicker.js"></script> 
    <script type="text/javascript" src="../style/js/common/jquery.cookie.js"></script>
    <script type="text/javascript">
       $(document).ready( function () {
		    var table =$('#example').DataTable({
		            "info": false, 
					    ajax: {
					        url: 'http://localhost/TEST/account/all.do',
					        dataSrc: ''
			            },
            "columns": [
		            { "data": "code" },
		            { "data": "name" },
		            { "data": "note" },
		            { "data": "status" },
		            { "data": "created" },
		            { "data": "updated" },
		            { "data": "type" }
               ]
		    });
		    //单行选中
		   $('#example tbody').on("click","tr",function () {
		        if ($(this).hasClass('selected') ) {
		            $(this).removeClass('selected');		    
		            $(this).css("color","rgb(51,51,51)");		            
		        }
		        else {
		            table.$('tr.selected').removeClass('selected');
		            $(this).addClass('selected');
		            $(this).css("color","red");
		        }
 		   });
           //删除
		   $('#delete').click( function () {
		        var tr = $(".selected").children();
		        var code = tr.eq(0).text();
          	    $.ajax({
						url: "dele.do",
						type: "GET",
						data:{"code":code},
						dataType: "text",
						success:function(data){	
				            table.row('.selected').remove().draw(false );
						}
                     });	        
		        
		    });
		   //修改信息 
		   $('#update').click( function () {
		   	    var tr = $(".selected").children();
		        var code = tr.eq(0).text();
		        var name = tr.eq(1).text();
		        var note = tr.eq(2).text();
		        var status = tr.eq(3).text();
		        var str = code+"/"+name+"/"+note+"/"+status;
		        $.cookie('ac',str);		 
		        window.location.href = "update.do"	        
		       
		    });
		  //日期查询  
		  $("#dateselect").click(function(){
		  
		         var date = $("#reservation").val();    
			     var start = date.substring(0,10);
			  
			     var datestart = new Date(Date.parse(start)).getTime();
			     var end = date.substring(13,date.length);
	             var dateend = new Date(Date.parse(end)).getTime();
		         table.ajax.url( 'http://localhost/TEST/account/timeall.do?start='+datestart+
		        '&&end='+dateend ).load();	
		  });
		    
		    		    
		});
    </script>
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

    </tbody>
   </table>
   
   <div class="dropdown" style="display: inline-block;">
     <a data-toggle="dropdown" id="dateselect" class="btn btn-primary" href="javascript:void(0)" >日期查询</a>
   </div>
   <div id="reportrange2" class="btn" style="display: inline-block; background: #fff; cursor: pointer; padding: 5px 10px;">
      <div class="control-group">
        <div class="controls">
           <span id="span"></span><input type="text" readonly="readonly" style="width: 200px" name="reservation" id="reservation" class="form-control" value="2017-01-01 - 2017-02-14" /> 
        </div>
      </div>
   </div>
   
   <div class="dropdown" style="display: inline-block;">
     <a class="btn btn-primary" href="http://localhost/TEST/account/reg.do" >添加新用户</a>
   </div>
   <div class="dropdown" style="display: inline-block;">
     <a class="btn btn-primary" id="delete" href="javascript:void(0)" >删除用户</a>
   </div>
   <div class="dropdown" style="display: inline-block;">
     <a class="btn btn-primary" id="update" href="javascript:void(0)" >修改</a>
   </div>
   <script type="text/javascript">
     $(document).ready(function() {
            $('#reservation').daterangepicker(null, function(start, end, label) {
              console.log(start.toISOString(), end.toISOString(), label);
            });
     });
   </script>
   </div> 
</body>   
</html>
