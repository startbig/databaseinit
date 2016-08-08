Ext.define("app.controller.model.ModelController", {
	extend: 'Ext.app.ViewController',
	alias: 'controller.modelcontroller',
	requires: [
		'Ext.window.Window',
		'Ext.window.Toast',
		'Ext.form.*'
	],
	insertModel: function(){
		this.operationDevice('add');
	},
	updateModel: function(ctx){
		var records = ctx.up('grid').getSelection()[0];
		this.operationDevice('edit',records);
	},
	operationDevice: function(type,rec) {
		var brandStore=Ext.create('app.store.BrandStore',{
    	    fields: ["brandName", "id"]
		});
		brandStore.load();
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
				url: type=='add'?'model/insertModel':'model/updateModel',
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
					name:'modelName',
					fieldLabel: '型号'
				},
				{
					name:'brandId',
					xtype: 'combobox',
  		            store: brandStore,
  		            editable: false,
  		            displayField: "brandName",
  		            valueField: "id",
  		            emptyText: "--请选择--",
  		            queryMode: "local",
  				    allowBlank: false,
					fieldLabel: '品牌'
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
								var grid = Ext.ComponentQuery.query('modelpanel')[0];
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
