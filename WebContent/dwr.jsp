<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="keywords" content="设备状态监控">
    <meta name="description" content="设备状态监控">
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!--Morris -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet"> 
	<title>设备状态监控</title>
	<!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>
    <script type='text/javascript' src='/Pot/dwr/util.js'></script>
    <script type='text/javascript' src='/Pot/dwr/engine.js'></script>
    <script type='text/javascript' src='/Pot/dwr/interface/DwrPush.js'></script>
    <script type="text/javascript" src="./js/jquery.min.js"></script>
    <script>

    $(document).ready(function(){
        alert('can get here!');
        // 页面加载的时候进行反转的激活
        /* dwr.engine.setActiveReverseAjax(true); */
        dwr.engine.setActiveReverseAjax(true) ;

        // 点击页面按钮的时候触发的方法
        $("#control-submit").click(function(){
            // 此类即为根据java文件生成的js文件

            //获取输入控制数据
            var temperature_submit = $("#temperature-submit").val();
            var pressure_submit = $("#pressure-submit").val();
            var time_submit = $("#time-submit").val();
            var user_submit = $("#user-submit").val();
            var location_submit = $("#location-submit").val();

            //将数据生成对象，然后转化为json格式
            var dataObj = {};
            dataObj.temperature = temperature_submit;
            dataObj.pressure = pressure_submit;
            dataObj.time = time_submit;
            dataObj.user = user_submit;
            dataObj.location = location_submit;
            var dataJSON = JSON.stringify(dataObj);
            console.log(dataJSON)
            DwrPush.Send(dataJSON);
        });
    });

    //////////////////////////////////////用于后台调取的函数
    function callback(msg){
        //alert('test！');
        alert("数据提交成功");
        var json_str = JSON.parse(msg)
        console.log(json_str);
        $("#temperature-input").html(json_str.temperature);
        $("#pressure-input").html(json_str.pressure);
        $("#time-input").html(json_str.time);
        $("#user-input").html(json_str.user);
        $("#location-input").html(json_str.location);
    }
    </script>
</head>
<body class="gray-bg"> 
<ul id="ul">

</ul>

<br/>
<hr>
<input type="text" id="data" name='data' />&nbsp;&nbsp;&nbsp;&nbsp;
<input type='button' id="button" value="publish">

    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-content text-center p-md">
                        <h2><span class="text-navy">压力锅实时状态信息</span></h2>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-content text-center p-md">

                        <h4 class="m-b-xxs">压力锅设备信息&nbsp;&nbsp;<span class="label label-primary">新</span></h4>
                        <span class="simple_tag">温度：<span id="temperature-input">35</span>℃</span>
                        <span class="simple_tag">压力:<span id="pressure-input">1</span>Kpa</span>
                        <span class="simple_tag">定时：<span id="time-input">0</span>s</span>
                        <span class="simple_tag">食谱：食谱二</span>
                        <span class="simple_tag">用户：<span id="user-input">巩航</span></span>
                        <span class="simple_tag">位置：<span id="location-input">西安</span></span>
                        <span class="simple_tag">连接时间：35分钟前</span>
                        <span class="simple_tag">状态：正常烹饪中</span>
                        <div class="m-t-md">
                            <p>点击以下图片查看实时数据：</p>
                            <div class="p-lg ">
                                <a href="index_v5.html" target="_blank">
                                    <img class="img-responsive img-shadow" src="img/index_4.jpg" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="col-sm-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>设备状态控制 <small>压力锅信息控制</small></h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="form_basic.html#">选项1</a>
                                </li>
                                <li><a href="form_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form method="get" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">温度</label>
                                <div class="col-sm-10">
                                    <input type="text" id="temperature-submit" placeholder="0~100℃" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">压力</label>
                                <div class="col-sm-10">
                                    <input type="text" id="pressure-submit" placeholder="0~35Kpa" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">定时</label>
                                <div class="col-sm-10">
                                    <input type="text" id="time-submit" placeholder="0~36000s" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">用户</label>
                                <div class="col-sm-10">
                                    <input type="text" id="user-submit" placeholder="输入用户" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">位置</label>
                                <div class="col-sm-10">
                                    <input type="text" id="location-submit" placeholder="您所在位置" class="form-control">
                                </div>
                            </div>
                            <div class="hr-line-dashed"></div>

                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-2">
                                    <button id="control-submit" class="btn btn-primary" type="button">确认提交</button>&nbsp;&nbsp;
                                    <button class="btn btn-white" type="button">取消</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


        </div>


    </div>


    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>
</html>