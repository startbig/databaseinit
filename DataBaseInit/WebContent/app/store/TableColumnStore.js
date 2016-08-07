Ext.define("app.store.TableColumnStore", {
	extend:'Ext.data.Store',
	alias:'store.tableColumnstore',
	fields:[
	'columnName',
	'columnType',
	'columnComment'
	],
	proxy: {
		type: 'ajax',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		},
		api:{
			read: 'table/selectTableColumnList',
			create: 'table/insertSyscode',
		    update: 'updateSyscode',
		    destroy: 'deleteSyscode'
		}
	},
	pageSize: 20
});
