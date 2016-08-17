Ext.define("app.store.CustomerRecordStore", {
	extend:'Ext.data.Store',
	alias:'store.customerrecordstore',
	fields:[
	'id',
	'customerId',
	'createUser',
	'createTime',
	'updateContent'
	],
	proxy: {
		type: 'ajax',
		url: 'customer/getCustomerRecordList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});