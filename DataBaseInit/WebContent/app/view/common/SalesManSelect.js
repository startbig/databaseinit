Ext.define('Genomics.view.common.SalesManSelect',{
	extend : 'Ext.container.Container',
	alias : 'widget.SalesManSelectField',
	layout : 'hbox',
	width : 250,
	labelWidth : 55,
	initComponent : function(){
		Ext.apply(this,{
			margin : this.padding,
			padding : '',
			items : [{
				xtype : 'textfield',
				fieldLabel : '签约业务员',
				name : this.name,
				labelWidth : this.labelWidth,
				width : this.width-55,
				labelAlign : 'right',
				readOnly : this.readOnly,
				padding : '0 5 0 0',
				codeVal : '',
				getValue : function(){
					var prefix = "";
					if(this.codeVal){
						prefix = "-"; 
					}
					if(!this.value){
						return "";
					}
					var val = this.codeVal+prefix+this.value;
					return val;
				},
				getRawValue: function() {
					if(this.value){
						return  this.getValue();
			        }else{
			        	return '';
			        }
			    }
			},{
				xtype : 'button',
				text : '选择',
				width : 50,
				listeners : {
					click : function(btn){
						var store = Ext.create('Ext.data.Store',{
							fields : ['id','realName','mobileNum','msnQq','departmentName','zoneId'],
							proxy : {
								type : 'ajax',
								url : extPath+'business/findSalesMan.do',
								reader : {
									type : 'json',
									root: 'root',
								    totalProperty:'total'
								}
							},
							pageSize: 10,
							autoLoad: true	
						});
						Ext.create('Ext.window.Window',{
							title : '选择业务员',
							width : 500,
							height : 350,
							layout : 'fit',
							items : {
								xtype : 'grid',
								store : store,
								columns : [
									{header:gridTitleOrderNo,xtype : 'rownumberer',width : 40},
									{header:'姓名',dataIndex:'realName',width:120,align : 'center'},
									{header:'手机',dataIndex:'mobileNum',width:100,align : 'center'},
									{header:'Msn/Qq',dataIndex:'msnQq',width:100,align : 'center'},
									{header:'部门',dataIndex:'departmentName',width:150,align : 'center'},
									{header:'片区',dataIndex:'zoneId',width:100,align : 'center'}
								],
								bbar: Ext.create('Ext.PagingToolbar', {
									store : store,
						            displayInfo: true,
						            pageSize: 10,
						            displayMsg: '当前显示 {0} - {1} 条     总共{2}条',
						            emptyMsg: "没有记录",
						            beforePageText : '第',
						            afterPageText : '页   共{0}页',
						            firstText: '第一页',
						            prevText: '前一页',
						            nextText: '后一页',
						            lastText: '最后一页',
						            refreshText: '刷新'
						        }),
						        listeners : {
									itemdblclick : function(thisCmp,rec){
										btn.previousNode('textfield').codeVal = rec.get('id');
										btn.previousNode('textfield').setValue(rec.get('realName'));
										thisCmp.up('window').close();
									}
								}
							}
						}).show();
					}
				}
			}]
		});
		this.callParent(arguments);
	}
});