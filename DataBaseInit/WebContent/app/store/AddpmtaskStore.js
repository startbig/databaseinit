Ext.define("app.store.AddpmtaskStore", {
	extend:'Ext.data.Store',
	alias:'store.addpmtaskstore',
	fields:[
	'id',
	'replyContent',
	'createUser',
	'createTime',
	'taskId',
	'type'
	],
	proxy: {
		type: 'ajax',
		url:'task/selectAddpmtaskList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
