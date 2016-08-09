Ext.define("app.store.DeviceStore", {
	extend:'Ext.data.Store',
	alias:'store.devicestore',
	fields:[
	    	'id',
	    	'deviceNum',
	    	'price',
	    	'createTime',
	    	'createUser',
	    	'status',
	    	'deviceCondition',
	    	'uvmirror',
	    	'rate',
	    	'lenshood',
	    	'supplier',
	    	'storageTime',
	    	'remark',
	    	'brandId',
	    	'modelId',
	    	'brandName',
	    	'modelName'
	],
	proxy: {
		type: 'ajax',
		url:'device/getDeviceList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
