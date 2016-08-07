Ext.define("app.store.TaskStore", {
	extend:'Ext.data.Store',
	alias:'store.taskstore',
	fields:[
	'id',
	'taskContent',
	'createTime',
	'createUser'
	],
	proxy: {
		type: 'ajax',
		url:'task/selectTaskList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
