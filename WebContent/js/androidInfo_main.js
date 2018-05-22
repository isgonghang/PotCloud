//点击手机控制信息下方按钮获取数据

$(document).ready(function(){
	$("#getAndroidInfo").click(function(){
		$.ajax({
			url : "http://localhost:8080/Pot/urlparse",
			type : "GET",
			dataType : "json",
			async : true,
			success : function(data){
				$("#temperature-info").html(data.temperature);
				$("#time-info").html(data.time);
				$("#user-info").html(data.user);
				$("#location-info").html(data.location);
			}
		});
	});
});
