Ext.define("app.store.SyscodeStore", {
	extend:'Ext.data.Store',
	alias:'store.syscodestore',
	fields:[
	'id',
	'syscode',
	'systype',
	'createUser',
	'createTime'
	],
	groupField: 'systype',
	proxy: {
		type: 'ajax',
		url: 'syscode/getSyscodeList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		},
		 api: {
	            destroy: 'syscode/deleteSyscode'
	        }
	},
	pageSize: 20
});