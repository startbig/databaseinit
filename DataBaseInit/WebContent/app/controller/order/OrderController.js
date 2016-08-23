Ext.define("app.controller.order.OrderController", {
	extend: 'Ext.app.ViewController',
	alias: 'controller.ordercontroller',
	requires: [
		'Ext.window.Window',
		'Ext.window.Toast',
		'Ext.form.*'
	],
	insertOrder: function() {
//		var brandStore = Ext.create('app.store.BrandStore', {
//			fields: ["brandName", "id"]
//		});
//		var formPanle=Ext.create('Ext.form.Panel', {
//			url:'order/insertOrder',
//			height: 350,
//			id:'orderCardFrom',
//			layout: {
//				type: 'column',
//				align: 'stretch'
//			},
//			fieldDefaults : {
//				margin : '5 5 5 5',
//				labelWidth : 60,
//			},
//			bodyPadding: 15,
//			defaultType: 'textfield',
//			items: [
//			{
//				name: 'startrentTime',
//				fieldLabel: '起租时间',
//				xtype: 'datefield',
//   				format:"Y-m-d",
//   			    columnWidth: 0.5
//			}, {
//				name: 'endrentTime',
//				fieldLabel: '退租时间',
//				xtype: 'datefield',
//	   			format:"Y-m-d",
//	   		    columnWidth: 0.5
//			}, {
//				name: 'customer',
//				fieldLabel: '客户',
//	   		    columnWidth: 0.5
//			}, {
//				name: 'customerName',
//				fieldLabel: '客户姓名',
//	   		    columnWidth: 0.5
//			}, {
//				name: 'customerPhone',
//				fieldLabel: '客户电话',
//	   		    columnWidth: 0.5
//			}, {
//				name: 'customerAddress',
//				fieldLabel: '客户地址',
//	   		    columnWidth: 0.5
//			}, {
//				name: 'remark',
//				fieldLabel: '备注',
//				xtype: 'textarea',
//					columnWidth: 1
//			}]
//		});
//		brandStore.load();
//		var modelStore = Ext.create('app.store.ModelStore', {
//			fields: ["modelName", "id"]
//		});
//		var mystore = Ext.create('app.store.DeviceStore');
//		mystore.load();
//		var myGrid = Ext.create('Ext.grid.Panel', {
//			forceFit: true,
//			store: mystore,
//			height: 350,
//			border: true,
//			split: true,
//			bbar: Ext.create('app.view.common.CommonPaggingTool', {
//				store: mystore
//			}),
//			dockedItems: [{
//				dock: 'top',
//				xtype: 'toolbar',
//				items: [{
//						xtype: 'form',
//						layout: 'vbox',
//						items: [{
//							xtype: 'container',
//							layout: 'hbox',
//							items: [{
//									name: 'brandId',
//									xtype: 'combobox',
//									store: brandStore,
//									labelWidth : 40,
//									editable: false,
//									labelAlign: 'left',
//									displayField: "brandName",
//			                        style: 'margin-left: 10px;',
//									valueField: "id",
//									emptyText: "--请选择--",
//									queryMode: "local",
//									allowBlank: false,
//									fieldLabel: '品牌',
//									listeners: {
//										select: function() {
//											var modelCombobox = Ext.getCmp("modelComboboxData");
//											modelCombobox.reset();
//											modelStore.proxy.extraParams = {
//												'brandId': this.getValue()
//											};
//											modelStore.load();
//										}
//									}
//								}, {
//									id: 'modelComboboxData',
//									name: 'modelId',
//									xtype: 'combobox',
//									store: modelStore,
//									labelWidth : 40,
//			                        style: 'margin-left: 10px;',
//									editable: false,
//									displayField: "modelName",
//									valueField: "id",
//									emptyText: "--请先选择品牌--",
//									queryMode: "local",
//									labelAlign: 'left',
//									allowBlank: false,
//									fieldLabel: '型号'
//								}
//
//							]
//						}]
//					}
//					, {
//						xtype: 'button',
//						text: '搜索',
//						glyph: 0xf002,
//						style: 'margin-left:66px',
//						handler: this.searchGaid
//					}, {
//						xtype: 'button',
//						text: '重置',
//						glyph: 0xf021,
//						handler: this.searchReset
//					}
//				]
//			}],
//			columns: [{
//				header: '',
//				xtype: 'rownumberer'
//			}, {
//				header: '状态',
//				align: 'left',
//				dataIndex: 'status',
//				renderer: function(v) {
//					if (v == '0') {
//						return '未入库';
//					} else if (v == '1') {
//						return '已入库';
//					}
//				}
//			}, {
//				header: '品牌',
//				align: 'left',
//				dataIndex: 'brandName'
//			}, {
//				header: '型号',
//				align: 'left',
//				dataIndex: 'modelName'
//			}, {
//				header: '镜头编号',
//				align: 'left',
//				dataIndex: 'deviceNum'
//			}, {
//				header: '成色',
//				align: 'left',
//				dataIndex: 'deviceCondition'
//			}, {
//				header: 'uv镜',
//				align: 'left',
//				dataIndex: 'uvmirror'
//			}]
//		});
//
//		var panel = new Ext.Panel({
//			frame: true,
//			layout: 'card',
//			activeItem: 0,
//			bodyStyle: 'padding:15px',
//			split: true,
//			defaults: {
//				border: true
//			},
//			bbar: [{
//					id: 'move-prev',
//					text: '上一步',
//					handler: function(btn) {
//						navigate(btn.up("panel"), "prev");
//					},
//					hidden: true
//				},
//				'->', {
//					id: 'move-next',
//					text: '下一步',
//					handler: function(btn) {
//						navigate(btn.up("panel"), "next");
//					}
//				}, {
//					id: 'order-card-sumbit',
//					text: '完成',
//					handler: this.orderSumit,
//					hidden: true
//				}
//			],
//			items: [myGrid,formPanle
//			]
//		});
//		var window = Ext.create('Ext.window.Window', {
//			modal: true,
//			title: '设备预配',
//			width: 700,
//			height: 450,
//			closable: true,
//			border: true,
//			split: true,
//			modelValidation: true,
//			items: panel
//		}).show();
//		var navigate = function(panel, direction) {
//			    if(!panel.down('grid').getSelection()[0]){
//                    app.Constant.warningMsgBox('请选择设备后再进行操作!');
//			    	return
//			    }
//				var layout = panel.getLayout();
//				layout[direction]();
//				if (layout.getPrev()) {
//					Ext.getCmp('move-prev').setVisible(true);
//				} else {
//					Ext.getCmp('move-prev').setVisible(false);
//
//				}
//				if (!layout.getNext()) {
//					Ext.getCmp('move-next').setVisible(false);
//					Ext.getCmp('order-card-sumbit').setVisible(true);
//
//				} else {
//					Ext.getCmp('move-next').setVisible(true);
//					Ext.getCmp('order-card-sumbit').setVisible(false);
//				}
//				//            Ext.getCmp('move-prev').setDisabled(!layout.getPrev());
//				//            Ext.getCmp('move-next').setDisabled(!layout.getNext());
//			}
					this.operationDevice('add');
	},
	updateOrder: function(ctx) {
		var records = ctx.up('grid').getSelection()[0];
		this.operationDevice('edit', records);
	},
	operationDevice: function(type, rec) {
		var brandStore=Ext.create('app.store.BrandStore',{
    	    fields: ["brandName", "id"]
		});
    	
    	brandStore.load();
    	var modelStore=Ext.create('app.store.ModelStore',{
    	    fields: ["modelName", "id"]
		});
		var customerStore=Ext.create('app.store.CustomerStore',{
    	    fields: ["customerNum","customerName","customerPhone", "id"]
		});
		customerStore.load();
		var formPanle=Ext.create('Ext.form.Panel', {
		url:'order/insertOrder',
//		height: 350,
		id:'orderCardFrom',
		layout: {
			type: 'column',
			align: 'stretch'
		},
		fieldDefaults : {
			margin : '5 5 5 5',
			labelWidth : 60,
		},
		bodyPadding: 15,
		defaultType: 'textfield',
		items: [
		  { 
			name:'customerId',
			xtype: 'combobox',
            store: customerStore,
            editable:true,
            hideTrigger: true, 
            minChars:2, 
            queryParam: 'customerName',
            displayField: "customerNum",
            tpl: Ext.create('Ext.XTemplate',
                    '<tpl for=".">',
                        '<div class="x-boundlist-item">{customerNum} - {customerName}- {customerPhone}</div>',
                    '</tpl>'
            ),
            valueField: "id",
            queryMode: "remote",
		    allowBlank: false,
		    fieldLabel: '客户号',
  		    columnWidth: 0.5,
  			listeners:{
				select:function(){
					var records = this.displayTplData[0];
					var form=this.up('form').getForm();;
					form.findField("customerName").setValue(records.customerName);
					form.findField("customerPhone").setValue(records.customerPhone);
					form.findField("customerPlace").setValue(records.customerPlace);
					form.findField("customerAddress").setValue(records.customerAddress);

				}
			}
		},{
			name: 'customerName',
			fieldLabel: '姓名',
		    columnWidth: 0.5
		},{
			name: 'customerPhone',
			fieldLabel: '电话',
			columnWidth: 0.5
		},{
			name: 'customerPlace',
			fieldLabel: '地点',
			columnWidth: 0.5
		},{
			name: 'customerAddress',
			fieldLabel: '地址',
			columnWidth: 1
		},{
			name:'brandId',
			xtype: 'combobox',
	            store: brandStore,
	            editable: false,
	            displayField: "brandName",
	            valueField: "id",
	            emptyText: "--请选择--",
	            queryMode: "local",
			    allowBlank: false,
			    columnWidth: 0.5,
			fieldLabel: '品牌',
			listeners:{
				select:function(){
					var modelCombobox=Ext.getCmp("modelComboboxData");  
					modelCombobox.reset(); 
					modelStore.proxy.extraParams = {
	                           'brandId': this.getValue()
	                };
					modelStore.load();
				}
			}
		},{ 
			id:'modelComboboxData',
			name:'modelId',
			xtype: 'combobox',
	            store: modelStore,
	            editable: false,
	            displayField: "modelName",
	            valueField: "id",
	            emptyText: "--请先选择品牌--",
	            queryMode: "local",
			    allowBlank: false,
			    columnWidth: 0.5,
			    fieldLabel: '型号',
			    listeners:{
					select:function(){
						var brandId=Ext.getCmp("modelComboboxData").getValue();
						var modelId=this.getValue();
						
					}
				}
		},{
			name: 'startrentTime',
			fieldLabel: '起租时间',
			xtype: 'datefield',
				format:"Y-m-d",
			    columnWidth: 0.5
		}, {
			name: 'endrentTime',
			fieldLabel: '退租时间',
			xtype: 'datefield',
   			format:"Y-m-d",
   		    columnWidth: 0.5
		}, {
			name: 'remark',
			fieldLabel: '备注',
			xtype: 'textarea',
				columnWidth: 1
		}]
	});
		var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 600,
			height: 390,
			closable: true,
			modelValidation: true,
			title: type == 'add' ? '新增' : '修改',
			items: formPanle
//			{
//				xtype: 'form',
//				url: type == 'add' ? 'order/insertOrder' : 'order/updateOrder',
//				bodyPadding: 10,
//				border: false,
//				layout: {
//					type: 'vbox',
//					align: 'stretch'
//				},
//				defaultType: 'textfield',
//				items: [{
//					name: 'id',
//					hidden: true
//				}, {
//					xtype : 'gridComboSelector',
//					comboGrid : Ext.create('app.view.customer.CustomerSelect',{}),
//					fieldLabel : '片区名称',
//					queryMode : 'local',
//					name : 'customerId',
//					displayField : 'customerNum',// 显示角色名称
//					valueField : 'id',// 存角色id
//					editable : false,
//					labelAlign : 'right',
//					allowBlank : false,
//					blankText : "该输入项为必输项"
//				}, {
//					name: 'startrentTime',
//					fieldLabel: '起租时间'
//				}, {
//					name: 'endrentTime',
//					fieldLabel: '退租时间'
//				}, {
//					name: 'customer',
//					fieldLabel: '客户'
//				}, {
//					name: 'customerName',
//					fieldLabel: '客户姓名'
//				}, {
//					name: 'customerPhone',
//					fieldLabel: '客户电话'
//				}, {
//					name: 'customerAddress',
//					fieldLabel: '客户地址'
//				}, {
//					name: 'remark',
//					fieldLabel: '备注'
//				}, {
//					name: 'createUser',
//					fieldLabel: '创建人'
//				}, {
//					name: 'createTime',
//					allowBlank: false
//				}],
//				buttons: [{
//					text: '保存',
//					handler: function() {
//						var form = window.items.get(0).getForm();
//						if (form.isValid()) {
//							form.submit({
//								method: 'post',
//								waitMsg: '上传中...',
//								success: function(form, action) {
//									var grid = Ext.ComponentQuery.query('orderpanel')[0];
//									grid.getStore().load();
//									window.close();
//									app.Constant.showMsg(app.Constant.addSuccessMsg);
//								},
//								failure: function(form, action) {
//									var msg = action.result.msg;
//									if (msg) {
//										showToast(msg)
//									}
//									showToast(app.Constant.systemErrorMsg);
//								}
//							})
//						}
//					}
//				}, {
//					text: '重置',
//					handler: function(ctx) {
//						ctx.up('window').down('form').reset();
//					}
//				}, {
//					text: '取消',
//					handler: function() {
//						window.close();
//					}
//				}]
//			}
		});
		if (rec) {
			var form = window.down('form');
			form.loadRecord(rec)
		}
		window.show();
	},
	orderSumit: function(ctx) {
		var device=ctx.up('panel').down('grid').getSelection()[0];
		var window=ctx.up('panel').up('window');
		var form=	Ext.getCmp('orderCardFrom');
		if (form.isValid()) {
			form.submit({
				method: 'post',
			    params:{'deviceId' : device.id},
				waitMsg: '上传中...',
				success: function(form, action) {
					var grid = Ext.ComponentQuery.query('leftorder')[0];
					grid.getStore().load();
					window.close();
					app.Constant.showMsg(app.Constant.addSuccessMsg);
				},
				failure: function(form, action) {
					var msg = action.result.msg;
					if (msg) {
						showToast(msg)
					}
					showToast(app.Constant.systemErrorMsg);
				}
			})
		}
	},
	searchGaid:function(ctx){
        var store = ctx.up('toolbar').up('grid').getStore(),
        form = ctx.up('toolbar').down('form'),
        values = form.getForm().getValues();  
        Ext.apply(store.proxy.extraParams, values);
        store.loadPage(1);
	},
	searchReset:function(ctx){
		var form=ctx.up('toolbar').down('form');
		form.reset();
	}
})