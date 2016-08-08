Ext.define("app.view.model.Model", {
	extend:'Ext.grid.Panel',
	xtype : 'modelpanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true,
	},
	store: Ext.create('app.store.ModelStore'),
	reference: 'modelGrid',
	requires: [
		'app.controller.model.ModelController'
	],
	controller: 'modelcontroller',
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'型号', align : 'left', dataIndex: 'modelName'},
			{header:'品牌', align : 'left', dataIndex: 'brandName'},
			{header:'创建人', align : 'left', dataIndex: 'createUser'},
			{header:'创建时间', align : 'left', dataIndex: 'createTime'}
			],
		bbar: Ext.create('app.view.common.CommonPaggingTool', {
			 store: this.store
		}),
		dockedItems:[
			{
			xtype:'toolbar',
			items:[
				{
					style: 'margin-left:10px',
					xtype: 'textfield',
					name: 'searchField',
					emptyText:'模糊查询',
					width: 200,
					listeners:{
						change:{
						scope: this,
						fn: this.textSearch,
						buffer: 500
						}
					}
				},
				{
				glyph : 0xf002,
				xtype : 'button',
				style: 'margin-left: -9px;'
				}]
			},
			{
			xtype:'toolbar',
			dock:'top',
			items:[
				{
					text  : '新增',
					glyph : 0xf016,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'insertModel'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateModel',
					bind: {
						disabled: '{!modelGrid.selection}'
					}
				}
				]
			}]
		});
		this.store.load();
		this.callParent(arguments);
	},
	textSearch: function() {
		var store = this.store;
		var textField = this.down('textfield[name=searchField]').getValue();
		if (app.Constant.isEmpty(textField)) {
			store.load({
			params: {
				modelName: textField
			}
		});
		}else{
		store.load();
		}
	}

});
