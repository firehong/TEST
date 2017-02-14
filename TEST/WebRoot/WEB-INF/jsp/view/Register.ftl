<!DOCTYPE html>
<html>
  <head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
	<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="http://cdn.bootcss.com/select2/4.0.3/css/select2.css" rel="stylesheet">

	<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script src="http://cdn.bootcss.com/select2/4.0.3/js/select2.js"></script>
	<script type="text/javascript">
	     $(document).ready(function() {
			  $(".js-example-basic-multiple js-states form-control").select2();
			  
		      $("#btn").click(function(){
		          $("#ac").submit();
		      });
		  	 
		 });		 
	
	</script>
</head>
  
<body>
  <div style="margin-left: 35%">
   <form role="form" action="add.do" id="ac" method="post">
	   <div class="form-group">
		<label for="name">名称</label>
		<input type="text" class="form-control" id="name"  style="width: 350px;"
			name="name"   placeholder="请输入名称">
	   </div>
	   <div class="form-group">
		<label for="name">备注</label>
		<input type="text" class="form-control" id="name"  style="width: 350px;"
			name="note"   placeholder="请输入备注">
	   </div>
	   <div class="form-group">
	        <label for="name">用户类型</label>
	        <select id="sel_menu" class="js-example-basic-multiple js-states form-control" 
	        name="type"   style="width: 350px;">
                <option value="1">普通用户</option>
                <option value="2">会员</option>
            </select>
	   </div>

	  <button type="submit" id="btn" class="btn btn-default">提交</button>
   </form>  
  </div>    
</body>
</html>
