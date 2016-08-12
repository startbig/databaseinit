Ext.define("app.store.CustomerStore", {
	extend:'Ext.data.Store',
	alias:'store.customerstore',
	fields:[
	'id',
	'customerNum',
	'customerName',
	'orderNum',
	'customerPhone',
	'customerAddress',
	'customerQq',
	'customerPlace',
	'createUser',
	'createTime',
	'updateUser',
	'updateTime'
	],
	proxy: {
		type: 'ajax',
		url: 'customer/getCustomerList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});