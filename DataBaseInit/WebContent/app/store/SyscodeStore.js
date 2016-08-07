Ext.define("app.store.SyscodeStore", {
	extend:'Ext.data.Store',
	alias:'store.syscodestore',
	fields:[
	'id',
	'key',
	'value',
	'type',
	'remark'
	],
	proxy: {
		type: 'ajax',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		},
		api:{
			  read: 'selectSyscodeList',
			  create: 'insertSyscode',
	          update: 'updateSyscode',
	          destroy: 'deleteSyscode'
		}
	},
	pageSize: 20
});
