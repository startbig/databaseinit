Ext.define("app.store.GeneExportStore", {
	extend : 'Ext.data.Store',
	alias : 'store.geneExportstore',
	fields : [ 'sumNum', 'createUser' ],
	hasMany : [ {
		fields : [ 'exportNum', 'createTime' ],
		name : 'exportList'
	} ],
	proxy : {
		type : 'ajax',
		url : 'gene/selectGeneExportList',
		reader : {
			type : 'json',
			rootProperty : 'root',
			totalProperty : 'total'
		}
	}
});
