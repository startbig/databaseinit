Ext.define("app.store.RolesResourcesStore", {
	extend:'Ext.data.Store',
	alias:'store.rolesresourcesstore',
	fields:[
	'id',
	'roleId',
	'resourceId'
	],
	proxy: {
		type: 'ajax',
		url: 'rolesresources/getRolesResourcesList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});