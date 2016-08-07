Ext.define("app.view.roleMenu.RoleMenu", {
	extend:'Ext.grid.Panel',
	xtype : 'roleMenupanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true
	},
	store: Ext.create('app.store.RoleMenuStore'),
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'', align : 'left', dataIndex: 'id'},
			{header:'角色id', align : 'left', dataIndex: 'roleId'},
			{header:'菜单id', align : 'left', dataIndex: 'menuId'},
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
					handler : 'insertRoleMenu'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateRoleMenu'
				}
				]
			}]
		});
	this.store.load();
	this.callParent(arguments);
	}
});
