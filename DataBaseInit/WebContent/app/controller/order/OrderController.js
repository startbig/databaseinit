Ext.define("app.controller.order.OrderController", {
	extend: 'Ext.app.ViewController',
	alias: 'controller.ordercontroller',
	requires: [
		'Ext.window.Window',
		'Ext.window.Toast',
		'Ext.form.*'
	],
	insertOrder: function(){
		this.operationDevice('add');
	},
	updateOrder: function(ctx){
		var records = ctx.up('grid').getSelection()[0];
		this.operationDevice('edit',records);
	},
	operationDevice: function(type,rec) {
		var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 400,
			height: 390,
			closable: true,
			modelValidation: true,
			title: type=='add'?'新增':'修改',
			items: {
				xtype: 'form',
				url: type=='add'?'order/insertOrder':'order/updateOrder',
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
					name:'deviceId',
					fieldLabel: '设备id'
				},
				{
					name:'startrentTime',
					fieldLabel: '起租时间'
				},
				{
					name:'endrentTime',
					fieldLabel: '退租时间'
				},
				{
					name:'customer',
					fieldLabel: '客户'
				},
				{
					name:'customerName',
					fieldLabel: '客户姓名'
				},
				{
					name:'customerPhone',
					fieldLabel: '客户电话'
				},
				{
					name:'customerAddress',
					fieldLabel: '客户地址'
				},
				{
					name:'remark',
					fieldLabel: '备注'
				},
				{
					name:'createUser',
					fieldLabel: '创建人'
				},
				{
					name:'createTime',
					allowBlank: false
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
								var grid = Ext.ComponentQuery.query('orderpanel')[0];
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
