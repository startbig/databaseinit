Ext.define("app.store.RolesStore", {
	extend:'Ext.data.Store',
	alias:'store.rolesstore',
	fields:[
	'id',
	'roleName',
	'createUser',
	'createTime'
	],
	proxy: {
		type: 'ajax',
		url:'roles/getRolesList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
