@var editUrl=editUrl!; //  示例menu/edit/showlayer
@var delUrl=delUrl!;
@var addUrl=addUrl!;
@var treeData=treeData!;
@var form=form!'search-form';
@var searchBtn=searchBtn!'search-btn';
@var searchInput=searchInput!'search-input';
@var searchAllBtn=searchAllBtn!'search-all-btn';
@var height = height!'0';
@var width = width!'50%';
@var reloadUrl = reloadUrl!false;
@var rootNodeName = rootNodeName!"全部";
@var addTitle = addTitle!"添加资源";

<script type="text/javascript">
	var setting = {
		view:{
			expandSpeed:100,
			selectedMulti : false,
			fontCss:function(treeId, treeNode) {
				return (!!treeNode.highlight) ? {"font-weight":"bold","color":"red"} : {"font-weight":"normal","color":"#333"};
			}
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "parentId"
			}
		},
		callback: {
			onClick: onClickNode,
			beforeDrag: function(){return false;}
		}
	};
	
	
	//划过显示添加按钮,添加
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='添加' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			$.cuslayer({
				mode:'page',
				title:'${addTitle}',
				height:"${height}",
				width:"${width}",
				url:"${ctxPath!}/"+'${addUrl}',
				data:{"parentId":treeNode.id}
			});
			return false;
		});
	};
	
	
	//节点点击事件
	function onClickNode(event, treeId, treeNode) {
		$("#tree_node").val(treeNode.id);
		$("#${form}").find("input[name=name]").val("");
		var treeObj = $.fn.zTree.getZTreeObj("treeMenu");
		$("#${form}").find("input[name=id]").val(treeNode.id);
		if(treeNode.code != undefined){//dict
			$("#${form}").find("input[name=type]").val(treeNode.code);
		}else{
			$("#${form}").find("input[name=type]").val("");
		}
		
		paging("${form}",1); //刷新表单
		for(var i=0, l=nodeList.length; i<l; i++) {
			nodeList[i].highlight = false;				
			treeObj.updateNode(nodeList[i]);
		}
	};
	
	var key = $("#${searchInput}"),nodeList = [];
	function searchNode(e) {
		// 取得输入的关键字的值
		var value = $.trim(key.get(0).value);
		
		// 按名字查询
		var keyType = "name";
		if (key.hasClass("empty")) {
			value = "";
		}
		
		// 如果要查空字串，就退出不查了。
		if (value === "") {
			return;
		}
		updateNodes(false);
		nodeList = treeObj.getNodesByParamFuzzy(keyType, value);
		updateNodes(true);
	};
	function updateNodes(highlight) {
		for(var i=0, l=nodeList.length; i<l; i++) {
			nodeList[i].highlight = highlight;				
			treeObj.updateNode(nodeList[i]);
			treeObj.expandNode(nodeList[i].getParentNode(), true, false, false);
		}
	};
	
	var treeObj;
	$(function(){
		//树结构初始化
		nodeList=[]; //清除缓存
		var treeData = ${treeData};
		@if(auth.hasAllDataScope() || auth.isSuper()){
			var root = {id:0,name:"${rootNodeName}",open:true};
			treeData[treeData.length] = root;
		@}
		$.fn.zTree.init($("#treeMenu"), setting,treeData);
		treeObj = $.fn.zTree.getZTreeObj("treeMenu");
		// 默认展开一级节点
		var nodes = treeObj.getNodesByParam("level", 0);
		for(var i=0; i<nodes.length; i++) {
			treeObj.expandNode(nodes[i], true, false, false);
		}
		
		$("#${searchAllBtn}").click(function(){
			$("#${form}").find("input[name=id]").val("");
			$("#${form}").find("input[name=name]").val("");
			$("#${form}").find("input[name=type]").val("");
			paging("${form}",1);
			var node = treeObj.getNodeByParam("id", 0);
			treeObj.selectNode(node,false);
			if(undefined != nodeList) {
				for(var i=0, l=nodeList.length; i<l; i++) {
					nodeList[i].highlight = false;				
					treeObj.updateNode(nodeList[i]);
				}
			}
		}).trigger("click");
		
		$("#${searchBtn}").click(function(e){
			$("#${form}").find("input[name=id]").val("");
			var treeObj = $.fn.zTree.getZTreeObj("treeMenu");
			treeObj.cancelSelectedNode();
			paging("${form}",1);
			searchNode(e);
		});
		
	});
	
</script>
