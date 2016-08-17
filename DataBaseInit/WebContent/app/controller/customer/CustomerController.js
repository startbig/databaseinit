Ext.define("app.controller.customer.CustomerController", {
	extend: 'Ext.app.ViewController',
	alias: 'controller.customercontroller',
	requires: [
		'Ext.window.Window',
		'Ext.window.Toast',
		'Ext.form.*'
	],
	search_record: function(grid, rec) {
			var customerRecordStore=Ext.create('app.store.CustomerRecordStore');
			customerRecordStore.proxy.extraParams = {
	                'customerId': rec.get('id')
	        };
			customerRecordStore.load();
		    var gridPanel=Ext.create('Ext.grid.Panel', {
		    forceFit : true,
		    columnLines:true,
			store:customerRecordStore,
		    columns :[
					{header:'', xtype : 'rownumberer'},
					{header:'修改内容', align : 'left', width:480,dataIndex: 'updateContent'},
					{header:'修改人', align : 'left', dataIndex: 'createUser'},
					{header:'修改时间', align : 'left',width:160, dataIndex: 'createTime'}
					],
			bbar: Ext.create('app.view.common.CommonPaggingTool', {
				 store: customerRecordStore
			})
	      });
		  var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 700,
			height: 350,
			closable: true,
			modelValidation: true,
			title:'查看修改记录',
			items:gridPanel
		  }).show();
	},
	insertCustomer: function(){
		this.operationDevice('add');
	},
	updateCustomer: function(ctx){
		var records = ctx.up('grid').getSelection()[0];
		this.operationDevice('edit',records);
	},
	operationDevice: function(type,rec) {
		var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 400,
			height: 350,
			closable: true,
			modelValidation: true,
			title: type=='add'?'新增':'修改',
			items: {
				xtype: 'form',
				url: type=='add'?'customer/insertCustomer':'customer/updateCustomer',
				bodyPadding: 10,
				border: false,
				layout: {
					type: 'vbox',
					align: 'stretch'
				},
				defaultType: 'textfield',
				items: [
				{
					name:'id',
					hidden:true
				},
				{
					name:'customerNum',
					fieldLabel: '客户号',
					disabled:type=='add'?false: true,
				},
				{
					name:'customerName',
					fieldLabel: '姓名'
				},
				{
					name:'orderNum',
					fieldLabel: '订单数'
				},
				{
					name:'customerPhone',
					fieldLabel: '电话'
				},
				{
					name:'customerAddress',
					fieldLabel: '地址'
				},
				{
					name:'customerQq',
					fieldLabel: 'QQ'
				},
				{
					name:'customerPlace',
					fieldLabel: '地点'
				}
				],
				buttons: [{
					text: '保存',
					handler: function() {
						var form = window.items.get(0).getForm();
						if (form.isValid()) {
						form.submit({
							method: 'post',
							waitMsg: '上传中...',
							success: function(form, action) {
								var grid = Ext.ComponentQuery.query('customerpanel')[0];
								grid.getStore().load();
								window.close();
								app.Constant.showMsg(app.Constant.addSuccessMsg);
							},
							failure: function(form, action) {
								var msg = action.result.msg;
								if(msg){
								showToast(msg)
								}
								showToast(app.Constant.systemErrorMsg);
							}
							})
						}
					}
				},
				{
				text: '重置',
					handler: function(ctx) {
						ctx.up('window').down('form').reset();
					}
				},
				{
				text: '取消',
					handler: function() {
						window.close();
					}
				}
			]
		}
		});
		if(rec){
			var form = window.down('form');
			form.loadRecord(rec)
		}
		window.show();
	}
})
