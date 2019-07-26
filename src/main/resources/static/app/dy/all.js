// JavaScript Document

$(function(){
	nav_height();
	$(window).resize(function(){
		nav_height();
	});
}); 

function nav_height(){
	if($('#Default2').length>=1){
		if($(window).width()<=1280)
		{
			$('#Default2').height($(window).height()-240);	
		}else{
			$('#Default2').height($(window).height()-249);	
		}
	}
	if($('#Default3').length>=1){
		$('#Default3').height($(window).height()).perfectScrollbar();
	}
}

//小屏幕
$(function(){
ie8f();
	$(window).resize(function(event) {
		ie8f();
	});
});



function ie8f(){
	if($(window).width() <= 1280){
		$("body").addClass('ie8j');
		$("body").removeClass('ie8jj');	
	}else{ if($(window).width() <= 1440){
		$("body").addClass('ie8jj');
		$("body").removeClass('ie8j');
	}
	else{
		$("body").removeClass('ie8j');	
		$("body").removeClass('ie8jj');	
	}
}}


//退出登录
/*退出  */
function remoSession() {
    var removed;
    $.ajax({
        type: "post",
        dataType: 'json',
        url: 'main?method=removeSession',
        async: false,
        success: function (data) {
            removed = data.removed;
            console.info(removed);
            if (removed == "1") {
                window.location.href = 'login.jsp';
            }
        }
    });
}
//各大功能模块显示权限检查
function permissionCheck(){
	//刷新界面时检查权限
	$.ajax({
	    type: "post",
	    dataType: 'json',
	    url: 'main?method=checkSession',
	    async: false,
	    success: function (data) {
	    	status = data.status;
	        labor = data.labor;
	        edit = data.edit;
	        canDownload = data.canDownload;
	        standstardPage = data.standstardPage;
	        report = data.report;
	        if(standstardPage=="1"){
	        	document.getElementById("data_analysis").style.display = '';
	 	        document.getElementById("details").style.display = '';
	 	        document.getElementById("url_report").style.display = '';
	        }
	        if (status == "1") {
	            document.getElementById("systemWatcher").style.display = '';
	        }
	        if (labor == "1") {
	            document.getElementById("artificial").style.display = '';
	        }
	        if (edit == "0") {
	            document.getElementById("admin").href = 'javascript:void(0)';
	        }
	        if (report == "1") {
	            document.getElementById("report_analysis").style.display = '';
	        }
	        /*if(report == "1"){
	        	document.getElementById("report_analysis").style.display = '';
	        }*/
	    }
	});
};
//时间验证模块
function timeCheck(time1,time2){
	if (time1 == "" && time2 == "") {
        alert("请选择时间");
        return false;
    }
 
    if (time1 == null || time1 == "") {
        alert("请选择起始时间");
        return false;
    }
    if (time2 == null || time2 == "") {
        alert("请选择结束时间");
        return false;
    } else {
 
    }
    if (time1 > time2) {
        alert("起始时间不能晚于结束时间");
        return false;
    }
    return true;
}








