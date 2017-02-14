<!DOCTYPE html>
<html>
  <head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">

	<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../style/js/common/jquery.cookie.js"></script>
	
	<script type="text/javascript">
	     $(document).ready(function() {

		     var date = $.cookie('ac').split("/");
		     $.cookie('ac','')
		     $("#code").val(date[0]);
		     $("#name").val(date[1]);
		     $("#note").val(date[2]);
		  	 if(date[3]=="正常")
		  	 {  
		  	   $("input[name='status'][value='1']").parent('label').addClass('active');
		  	 }
		  	 else if(date[3]=="异常")
		  	 {
		  	   $("input[name='status'][value='2']").parent('label').addClass('active');
		  	 }
		  	 else if(date[3]=="锁定")
		  	 {
		  	   $("input[name='status'][value='3']").parent('label').addClass('active');
		  	 }
		 });		 
	
	</script>
</head>
  
<body>
  <div style="margin-left: 35%">
   <form role="form" action="updated.do" id="ac" method="post">
   	   <div class="form-group">
		<label for="name">编号</label>
		<input type="text" class="form-control" id="code"  style="width: 350px;"
			name="code" readonly="readonly">
	   </div>
	   <div class="form-group">
		<label for="name">名称</label>
		<input type="text" class="form-control" id="name"  style="width: 350px;"
			name="name">
	   </div>
	   <div class="form-group">
		<label for="name">备注</label>
		<input type="text" class="form-control" id="note"  style="width: 350px;"
			name="note">
	   </div>
	   <div class="form-group">
	        <label for="name">状态</label>
	   </div>
	  <div class="btn-group" id="color" data-toggle="buttons">
	       <label class="btn btn-default">
	         <input type="radio" class="toggle" name="status" id="status" value="1"> 正常
	       </label>
	       <label class="btn btn-default">
	         <input type="radio" class="toggle" name="status" id="status" value="2"> 异常
	       </label>
	       <label class="btn btn-default">
	         <input type="radio" class="toggle" name="status" id="status" value="3"> 锁定
	       </label>
	   </div><br>
	  <button type="submit" id="btn" class="btn btn-default" style="margin-top:15px ">确认</button>
   </form>  
  </div>    
</body>
</html>
