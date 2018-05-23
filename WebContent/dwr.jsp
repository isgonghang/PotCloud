<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首次环境搭建</title>
<script type='text/javascript' src='/Pot/dwr/util.js'></script>
<script type='text/javascript' src='/Pot/dwr/engine.js'></script>
  <script type='text/javascript' src='/Pot/dwr/interface/DwrPush.js'></script>
<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script>

$(document).ready(function(){
    alert('can get here!');
    // 页面加载的时候进行反转的激活
    /* dwr.engine.setActiveReverseAjax(true); */
    dwr.engine.setActiveReverseAjax(true) ;

    // 点击页面按钮的时候触发的方法
    $("#button").click(function(){
        // 此类即为根据java文件生成的js文件
        var data = document.getElementById("data").value;
        DwrPush.Send(data);
    });
});



//////////////////////////////////////用于后台调取的函数
function callback(msg){
    //alert('test！');
    $("#ul").html($("#ul").html()+"<br />"+msg);
}
</script>
</head>
<body>
<ul id="ul">

</ul>

<br/>
<hr>
<input type="text" id="data" name='data' />&nbsp;&nbsp;&nbsp;&nbsp;
<input type='button' id="button" value="publish">

</body>
</html>