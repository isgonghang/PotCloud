<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>设备状态监控</title>
    <meta name="keywords" content="设备状态监控">
    <meta name="description" content="设备状态监控">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <!-- Morris -->
    <link href="css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
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
                        <span class="simple_tag">温度：35℃<%=(String)request.getAttribute("data")%></span>
                        <span class="simple_tag">定时：00：09：35</span>
                        <span class="simple_tag">压力:5Kpa</span>
                        <span class="simple_tag">食谱：食谱二</span>
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
                    <div class="ibox-content text-center p-md">

                        <h4 class="m-b-xxs">手机控制信息</h4>
                        <span class="simple_tag">温度：35℃</span>
                        <span class="simple_tag">定时：00：09：35</span>
                        <span class="simple_tag">食谱：食谱二</span>
                        <span class="simple_tag">用户：苗涛</span>
                        <span class="simple_tag">位置：西安</span>
                        <span class="simple_tag">连接时间：35分钟前</span>
                        <div class="m-t-md">
                            <p>点击以下图片查看效果：</p>
                            <div class="p-lg">
                                <a href="javascript:;">
                                    <img class="img-responsive img-shadow" src="img/index.jpg" alt="">
                                </a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>


    </div>


    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>


    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
    <!--统计代码，可删除-->

</body>

</html>