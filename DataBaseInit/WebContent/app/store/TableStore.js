Ext.define("app.store.TableStore", {
	extend:'Ext.data.Store',
	alias:'store.tablestore',
	fields:[
	'id',
	'tableName',
	'tableComment',
	'createUser',
	'createTime'
	],
	 hasMany:{
		 fields:[
		     	'id',
		     	'tableId',
		     	'columnName',
		     	'columnType',
		     	'columnComment'
		     	]
	 },
	proxy: {
		type: 'ajax',
		url: 'table/selectTableList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
