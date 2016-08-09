Ext.define("app.view.order.OrderLeft", {
	extend:'Ext.grid.Panel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true,
	},
	store: Ext.create('app.store.OrderStore'),
	reference: 'orderGrid',
	requires: [
		'app.controller.order.OrderController'
	],
	id: 'leftorder',
    alias: 'widget.leftorder',
	controller: 'ordercontroller',
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'品牌', align : 'left', dataIndex: 'brandName'},
			{header:'型号', align : 'left', dataIndex: 'modelName'},
			{header:'镜头编号', align : 'left', dataIndex: 'deviceNum'},
			{header:'起租时间', align : 'left', dataIndex: 'startrentTime'},
			{header:'退租时间', align : 'left', dataIndex: 'endrentTime'},
			{header:'创建人', align : 'left', dataIndex: 'createUser'},
			{header:'创建时间', align : 'left',width:145, dataIndex: 'createTime'}
			],
		bbar: Ext.create('app.view.common.CommonPaggingTool', {
			 store: this.store
		}),
		listeners: {
             itemclick: function(view, record) {
                 Ext.getCmp('orderdetailTable').setData(record.data);
             }
         },
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
					handler : 'insertOrder'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateOrder',
					bind: {
						disabled: '{!orderGrid.selection}'
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
				orderName: textField
			}
		});
		}else{
		store.load();
		}
	}

});
