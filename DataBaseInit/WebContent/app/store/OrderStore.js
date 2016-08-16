Ext.define("app.store.OrderStore", {
	extend:'Ext.data.Store',
	alias:'store.orderstore',
	fields:[
	'id',
	'deviceId',
	'startrentTime',
	'endrentTime',
	'customer',
	'customerName',
	'customerPhone',
	'customerAddress',
	'remark',
	'orderNum',
	'createUser',
	'createTime'
	],
	proxy: {
		type: 'ajax',
		url: 'order/getOrderList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});