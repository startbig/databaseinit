Ext.define("app.view.gene.GeneExport", {
    extend: 'Ext.panel.Panel',
    xtype: 'geneExportpanel',
    initComponent: function() {
        var me = this;
        var store1 = Ext.create('app.store.GeneExportStore');
        var store2 = Ext.create('Ext.data.Store', {
            fields: ['exportNum', 'createTime']
        });
        store1.load();
        var grid1 = Ext.create('Ext.grid.Panel', {
            region: 'west',
            store: store1,
            split: true,
            forceFit: true,
            flex: 6,
            columns: [{
                header: '',
                xtype: 'rownumberer'
            }, {
                header: '导出总数',
                align: 'left',
                dataIndex: 'sumNum'
            }, {
                header: '创建人',
                align: 'left',
                dataIndex: 'createUser'
            }],
            bbar: Ext.create('app.view.common.CommonPaggingTool', {
                store: store1
            }),
            listeners: {
                cellclick: function(grid, td, cellIndex, record) {
                    var data = record.get('exportList');
                    store2.loadData(data);
                }
            }
        });
        var grid2 = Ext.create('Ext.grid.Panel', {
            region: 'center',
            forceFit: true,
            store: store2,
            flex: 4,
            columns: [{
                header: '',
                xtype: 'rownumberer'
            }, {
                header: '导出数',
                align: 'left',
                dataIndex: 'exportNum'
            }, {
                header: '导出时间',
                align: 'left',
                dataIndex: 'createTime'
            }]
        });
        Ext.apply(this, {
            layout: {
                type: 'border'
            },
            items: [grid1, grid2]
        });
        // this.store.load();
        this.callParent(arguments);
    }
});
