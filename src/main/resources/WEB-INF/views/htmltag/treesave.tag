@var formId = formId!'save-form'; //form表单id
@var reloadUrl = reloadUrl!'false'; //是否url刷新
@var isHide = isHide!'no'; //是否隐藏按钮 默认no
@var subBtnId = subBtnId!(formId+'-save');
@var validId = validId!(strutil.replace(formId,"-",""));
@var config = config!'false';
@var data = data!'';
@var okText = okText!'提 交';
@var callBack = callBack!'';
@var searchBtnId = searchBtnId!'';//查询按钮ID，控制是否全部刷新
@var ulId = ulId!'';//标签ul元素id
@var openIndex = openIndex!'';//打开tab的序号

@if(isHide == "no"){
<div class="width-100 clearfix" tag-save-btn style="bottom: 0px;left: 0px;position:absolute;">
<div class="row">
  	<div class="col-md-4">
	<span class="btn btn-primary btn-sm bigger-110 width-100 "  id="${subBtnId}">
		<i class="ace-icon fa fa-floppy-o align-top bigger-125"></i> ${okText}
	</span>
	</div>
  <div class="col-md-4">
  	<span class="btn btn-yellow btn-sm  width-100 " id="${formId}-reset">
		<i class="ace-icon fa fa-refresh align-top  bigger-125"></i> 重 置
	</span>
  </div>
  <div class="col-md-4">
  	<span class="btn btn-success btn-sm bigger-110 width-100" id="${formId}-cancel">
		<i class="ace-icon fa fa-reply align-top  bigger-125"></i> 返 回
	</span>
  </div>
</div>
	
</div>
@}
<script type="text/javascript">

var count = 0;
$(function(){
	
var ${validId} = $("#${formId}").Validform({
		ajaxPost : true,
		beforeSubmit:function(curform){
			var loadi = layer.load(5,2);
			$("#${formId}").data('loadi',loadi);
		},
		callback:function(data){
			layer.close($("#${formId}").data('loadi'));
			if(data>0) {
			document.getElementById("${formId}").reset(); 
				layer.msg('操作成功', 1, 1,function(){
				layer.closeAll();
					 if("${callBack}" != undefined && "${callBack}".length > 0){
						${callBack};
					}else{
					//自动刷新
						if("${reloadUrl}" == "true"){
						var node=$("#tree_node").val();
							if(node == 1){
								$("#treeMenu_2_a").trigger('click');//特征库维护-第一个子节点点击
							}else if(node == 2){
								$("#treeMenu_3_a").trigger('click');//特征库维护-第二个子节点点击
							}else{
							location.reload();
							}

						}else{//点击按钮数据局部刷新
// 							$curmenu.trigger('click');
							//打开对应tab页面
							if("${ulId}" != undefined && "${openIndex}" != undefined && "${ulId}" != "" && "${openIndex}" != ""){
								openTab("${ulId}","${openIndex}")
							}
							//刷新数据
							if("${searchBtnId}" != undefined && "${searchBtnId}" != ""){
								$("#${searchBtnId}").trigger('click');
							}
							else{
								$curmenu.trigger('click');
							}
						}
					} 
					
				});
			}else{
				layer.msg('操作失败', 3, 1);
			}
		},
		tiptype : function(msg, o, cssctl) {
			if (!o.obj.is("form")) {
				if (o.type != 2) {
				 	if(msg.indexOf("所填信息没有经过验证") >= 0){//触发ajax url
				 		if(count > 0){
				 			layer.alert("请检查必须唯一的值",3,"检验错误");
				 		}else{//第一次直接触发
				 			count++;
					 		$(o.obj).focus();
					 		$(o.obj).blur();
				 		}
				 	}else if(msg.indexOf("请换一个") >=0 || msg.indexOf("占用") >=0){
				 		layer.alert(msg,3,"检验错误");
				 	}else{
						tip.errorTip(msg,o.obj);
				 	}
				}
			}
		},
		tipSweep : true
	});
	/**
	打开与关闭tab
	**/
	function openTab(ulId,openIndex){
//关闭已打开的标签
		$($("#"+ulId+" li[class=active] a").attr("href")).attr("class","tab-pane clearfix");
		$("#"+ulId+" li[class=active]").attr("class","");
//打开指定的标签
		$("#"+ulId+" li:nth-child("+openIndex+")").attr("class","active");
		$($("#"+ulId+" li:nth-child("+openIndex+") a").attr("href")).attr("class","tab-pane active clearfix");
	}
	
	$("#${subBtnId}").click(function() {
		if("${config}" == "true"){
			${tagBody!}
		}
		${validId}.submitForm(false);
		return false;
	}); 
	
	$("#${formId}-cancel").click(function(){
		layer.closeAll();
		return false;
	});
	
	$("#${formId}-reset").click(function(){
		document.getElementById("${formId}").reset();
		return false;
	});
	
	$("#${formId} input,#${formId} textarea").blur(function(){
		layer.closeTips();
		return false;
	})

});
</script>