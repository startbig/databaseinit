Ext.define("app.view.roles.Roles", {
	extend:'Ext.grid.Panel',
	xtype : 'rolespanel',
	 requires: [
	            'app.controller.roles.RolesController'
	            ],
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true
	},
    reference : 'rolesSelect',
	controller:'rolesController',
	store: Ext.create('app.store.RolesStore'),
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'角色名称', align : 'left', dataIndex: 'roleName'},
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
					handler : 'insertRoles'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateRoles'
				},
				{
					text  : '权限配置',
					glyph : 0xf0b1,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'insertRolesPower',
					bind:{
						 disabled : '{!rolesSelect.selection}'
					}
				}
				]
			}]
		});
	this.store.load();
	this.callParent(arguments);
	}
});
