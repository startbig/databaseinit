Ext.define("app.store.GeneRecordStore", {
	extend:'Ext.data.Store',
	alias:'store.geneRecordstore',
	fields:[
	'id',
	'geneId',
	'term',
	'oldInfo',
	'newInfo',
	'createUser',
	'createTime',
	'updateReason'
	],
	proxy: {
		type: 'ajax',
		url:'gene/selectGeneRecordList',
		reader: {
			type: 'json',
			rootProperty: 'root',
			totalProperty:'total'
		}
	},
	pageSize: 20
});
