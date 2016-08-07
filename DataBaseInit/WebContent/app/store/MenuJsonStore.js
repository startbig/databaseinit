Ext.define("app.store.MenuJsonStore", {
	extend:'Ext.data.Store',
	alias:'store.menustore',
	fields:[
	'id',
	'menuName',
	'menuType',
	'parentId',
	'createTime',
	'createUser'
	],
	proxy: {
		type: 'ajax',
		url:'menu/getJsonMenu',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
