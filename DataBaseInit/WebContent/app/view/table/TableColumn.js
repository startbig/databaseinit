Ext.define("app.view.table.TableColumn", {
	extend:'Ext.grid.Panel',
	xtype : 'tableColumnpanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true
	},
	store: Ext.create('app.store.TableColumnStore'),
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'', align : 'left', dataIndex: 'id'},
			{header:'表id', align : 'left', dataIndex: 'tableId'},
			{header:'字段名称', align : 'left', dataIndex: 'columnName'},
			{header:'字段类型', align : 'left', dataIndex: 'columnType'},
			{header:'表备注', align : 'left', dataIndex: 'columnComment'}
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
					handler : 'insertTableColumn'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateTableColumn'
				}
				]
			}]
		});
	this.store.load();
	this.callParent(arguments);
	}
});
