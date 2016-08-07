Ext.define("app.store.RoleMenuStore", {
	extend:'Ext.data.Store',
	alias:'store.roleMenustore',
	fields:[
	'id',
	'roleId',
	'menuId',
	'createUser',
	'createTime'
	],
	proxy: {
		type: 'ajax',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
