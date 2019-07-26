function clickme(i){
	var tip = "";
	switch(i){
		case 1:
			tip = "上传附件超过20M";
		break;
		case 4:
			tip = "发布信息提交成功，请等待管理员审核！";
		break;
		case 5:
			tip = "发不失败";
		break;
		case 6:
			tip = "正在加载中，请稍后...";
		break;
	}
	ZENG.msgbox.show(tip, i,3000);
}


function clickhide(){
	ZENG.msgbox._hide();
}

function clickmsg(i){
	var tip = "";
	switch(i){
		case 1:
			tip = "服务器繁忙，请稍后再试。";
		break;
		case 2:  
			tip = "请输入新闻标题！";
		break;
		case 4:
			tip = "上报成功！";
		break;
		case 5:
			tip = "上报失败";
		break;
		case 6:
			tip = "正在加载中，请稍后...";
		break;
		
	}
		ZENG.msgbox.show(tip, i, 3000);
}

function clickautohidedown(i){
	var tip = "";
	switch(i){
		case 1:
			tip = "您还未登录，请先登录！";
		break;
	}
	ZENG.msgbox.show(tip, i, 1500);
}

function msgAlert(i,neirong,time){
	var tip = "";
	switch(i){
		case 1:
			tip = neirong;
			break;
		case 4:
			tip = neirong;
		break;	
		case 5:
			tip = neirong;
		break;	
	}	
	ZENG.msgbox.show(tip, i, time==undefined?3000:time);
}