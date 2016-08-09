Ext.define("app.controller.brand.BrandController", {
	extend: 'Ext.app.ViewController',
	alias: 'controller.brandcontroller',
	requires: [
		'Ext.window.Window',
		'Ext.window.Toast',
		'Ext.form.*'
	],
	insertBrand: function(){
		this.operationDevice('add');
	},
	updateBrand: function(ctx){
		var records = ctx.up('grid').getSelection()[0];
		this.operationDevice('edit',records);
	},
	operationDevice: function(type,rec) {
		var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 400,
			height: 120,
			closable: true,
			modelValidation: true,
			title: type=='add'?'新增':'修改',
			items: {
				xtype: 'form',
				url: type=='add'?'brand/insertBrand':'brand/updateBrand',
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
					name:'brandName',
					fieldLabel: '品牌名称'
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
								var grid = Ext.ComponentQuery.query('brandpanel')[0];
								grid.getStore().load();
								window.close();
								app.Constant.showMsg(addSuccessMsg);
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
