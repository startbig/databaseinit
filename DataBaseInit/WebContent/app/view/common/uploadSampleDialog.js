Ext.define('Genomics.view.common.uploadSampleDialog',{
	extend : 'Ext.window.Window',
	title : '上传样品基本信息文件',
	layout : 'fit',
	width : 500,
	height : 400,
	items : [{
		xtype : 'panel',
		region : 'north',
		autoScroll : true,
		html : "<div id='queueSampleId' margin-left=20/>",
		height:250
	},{
		xtype: 'panel',
		region : 'center',
		id:'uploadSampleShowMsg',
		height:50,
		html:''
	}],
	listeners : {
		afterrender : function(){
			$(function() {
			    $("#file_upload_test").uploadify({
			        height : 16,
			        width : 89,
			        swf : extPath+'/uploadify/uploadify.swf',
			        uploader  : extPath+'/upload/sampleImport.action',
			        auto: false, //不自动提交
			        queueID : 'queueSampleId',
			        fileTypeDesc: '仅能上传excel文件',     //文件类型描述  
			        fileTypeExts: '*.xls;*.xlsx;',     //上传文件类型
			        fileSizeLimit: '1MB', //文件最大大小  
			        progressData : 'all',
			        fileObjName: 'myFile',
//			        'formData':{'id':1,'name':'irwin'}, //附加数据
			        buttonText: '添加文件',
//			        buttonImage : extPath+'/uploadify/selectFile3.png',
			        removeCompleted:false,
			        onSelectError: function(file, errorCode, errorMsg){ //file选择失败后触发  
			    		this.queueData.errorMsg = "超过文件上传大小限制(1M)";
			      	},  
			      	onFallback: function(){ //flash报错触发  
			      		alert("请您先安装flash控件");  
			      	},  
			      	onUploadSuccess: function(file, data, response){ //上传成功后触发  
				         if("sizeError" == data){  
				             alert("文件大小不能超过1M");  
				         } else if("typeError" == data){
				             alert("不支持的文件类型");  
				         } else if(data == 'success'){
				        	 Ext.getCmp('uploadSampleShowMsg').body.update('<div style="color:red;padding:10 10;">上传成功!</div>');
				        	 showMsg("上传成功!");
				         }else{
				        	 Ext.getCmp('uploadSampleShowMsg').body.update('<div style="color:red;padding:10 10;">上传失败!错误原因如下:</div>');
				        	 showMsg("上传失败!");
				         }
			      	}
			    });
			});
		}
	},
	tbar : [{
		xtype : 'panel',
		bodyStyle: 'background:transparent',
		border : false,
		padding : '0 0 0 0',
		height : 18,
		html : '<input type="file" id="file_upload_test" name="myFile">'
	}],
	buttons : [{
		text : '开始上传',
		listeners : {
			click : function(){
				$('#file_upload_test').uploadify('upload','*');
			}
		}
	},{
		text : '清空队列',
		listeners : {
			click : function(){
				$('#file_upload_test').uploadify('cancel','*');
			}
		}
	},{
		text : '关闭',
		listeners : {
			click : function(thisCmp){
				thisCmp.up('window').close();
			}
		}
	}]
});