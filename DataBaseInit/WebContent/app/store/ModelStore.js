Ext.define("app.store.ModelStore", {
	extend:'Ext.data.Store',
	alias:'store.modelstore',
	fields:[
	'id',
	'modelName',
	'brandId',
	'brandName',
	'createUser',
	'createTime'
	],
	proxy: {
		type: 'ajax',
		url: 'model/getModelList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});