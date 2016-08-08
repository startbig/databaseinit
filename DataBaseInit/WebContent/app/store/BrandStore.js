Ext.define("app.store.BrandStore", {
	extend:'Ext.data.Store',
	alias:'store.brandstore',
	fields:[
	'id',
	'brandName',
	'createUser',
	'createTime'
	],
	proxy: {
		type: 'ajax',
		url: 'brand/getBrandList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});