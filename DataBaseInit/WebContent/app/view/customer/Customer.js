Ext.define("app.view.customer.Customer", {
	extend:'Ext.grid.Panel',
	xtype : 'customerpanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true,
	},
	store: Ext.create('app.store.CustomerStore'),
	reference: 'customerGrid',
	requires: [
		'app.controller.customer.CustomerController'
	],
	listeners:{ 
	   rowdblclick : 'search_record'          		
	},
	controller: 'customercontroller',
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'客户号', align : 'left', dataIndex: 'customerNum'},
			{header:'姓名', align : 'left', dataIndex: 'customerName'},
			{header:'订单数', align : 'left', dataIndex: 'orderNum'},
			{header:'电话', align : 'left', dataIndex: 'customerPhone'},
			{header:'地址', align : 'left', dataIndex: 'customerAddress'},
			{header:'QQ', align : 'left', dataIndex: 'customerQq'},
			{header:'地点', align : 'left', dataIndex: 'customerPlace'},
			{header:'创建人', align : 'left', dataIndex: 'createUser'},
			{header:'创建时间', align : 'left', dataIndex: 'createTime'},
			{header:'更新人', align : 'left', dataIndex: 'updateUser'},
			{header:'更新时间', align : 'left', dataIndex: 'updateTime'}
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
					handler : 'insertCustomer'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateCustomer',
					bind: {
						disabled: '{!customerGrid.selection}'
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
				customerName: textField
			}
		});
		}else{
		store.load();
		}
	}

});
