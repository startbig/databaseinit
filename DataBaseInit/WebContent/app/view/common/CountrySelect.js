Ext.define('Genomics.view.common.CountrySelect',{
	extend : 'Ext.container.Container',
	alias : 'widget.countrySelectField',
	layout : 'hbox',
	width : 250,
	labelWidth : 55,
	fieldLabel : '所在国家',
	initComponent : function(){
		Ext.apply(this,{
			margin : this.padding,
			padding : '',
			items : [{
				xtype : 'textfield',
				fieldLabel : this.fieldLabel,
				name : this.name,
				labelWidth : this.labelWidth,
				width : this.width-55,
				readOnly : this.readOnly,
				allowBlank : this.allowBlank,
				labelAlign : 'right',
				padding : '0 5 0 0',
				codeVal : '',
				listeners : this.txtListeners,
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
							fields : ['territoryCode','cnName','engName','status','createTime'],
							proxy : {
								type : 'ajax',
								url : extPath+'business/findCountry.do',
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
							title : '选择国家',
							width : 500,
							height : 350,
							layout : 'fit',
							items : {
								xtype : 'grid',
								store : store,
								columns : [
									{header:gridTitleOrderNo,xtype : 'rownumberer',width : 40},
									{header:'国家编码',dataIndex:'territoryCode',width:75,align : 'center'},
									{header:'中文名称',dataIndex:'cnName',width:200,align : 'center'},
									{header:'英文名称',dataIndex:'engName',width:200,align : 'center'},
									{header:'状态',dataIndex:'status',width:75,align : 'center'},
									{header:'同步时间',dataIndex:'createTime',width:150,align : 'center'}
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
										btn.previousNode('textfield').codeVal = rec.get('territoryCode');
										btn.previousNode('textfield').setValue(rec.get('cnName'));
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