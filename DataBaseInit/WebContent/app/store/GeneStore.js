Ext.define("app.store.GeneStore", {
    extend: 'Ext.data.Store',
    alias: 'store.genestore',
    fields: [
        'id',
        'geneticMode',
        'gene',
        'sequence',
        'nucleotide',
        'aminophenol',
        'geneRegion',
        'chromosome',
        'rsnum',
        'dbindel',
        'hapmap',
        'frequency',
        'localFrequency',
        'featureChange',
        'mutationType',
        'literature',
        'siteRemark',
        'remark',
        'diseasePhenotype',
        'status',
        'createUser',
        'createTime'
    ],
    hasMany: [{
        fields: ['chip'],
        name: 'listChip'
    }, {
        fields: ['sampleNum'],
        name: 'listSample'
       
    }],
    proxy: {
        type: 'ajax',
        url: 'gene/selectGeneList',
        reader: {
            type: 'json',
            rootProperty: 'root',
            totalProperty: 'total'
        }
    },
    pageSize: 20
});


