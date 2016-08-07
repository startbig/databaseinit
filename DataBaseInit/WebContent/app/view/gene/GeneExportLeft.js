Ext.define("app.view.gene.GeneExport", {
    extend: 'Ext.grid.Panel',
    xtype: 'geneExportpanel',
    forceFit: true,
    viewConfig: {
        stripeRows: true,
        enableTextSelection: true
    },
    store: Ext.create('app.store.GeneExportStore'),
    initComponent: function() {
        Ext.apply(this, {
            store: this.store,
            columns: [{
                header: '',
                xtype: 'rownumberer'
            }, {
                header: '导出数',
                align: 'left',
                dataIndex: 'sumNum'
            }, {
                header: '创建人',
                align: 'left',
                dataIndex: 'createUser'
            }, {
                header: '创建时间',
                align: 'left',
                dataIndex: 'createTime'
            }],
            bbar: Ext.create('app.view.common.CommonPaggingTool', {
                store: this.store
            }),
            dockedItems: [{
                xtype: 'toolbar',
                items: [{
                    style: 'margin-left:10px',
                    xtype: 'textfield',
                    name: 'searchField',
                    emptyText: '模糊查询',
                    width: 200,
                    listeners: {
                        change: {
                            scope: this,
                            fn: this.textSearch,
                            buffer: 500
                        }
                    }
                }, {
                    glyph: 0xf002,
                    xtype: 'button',
                    style: 'margin-left: -9px;'
                }]
            }, {
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    text: '新增',
                    glyph: 0xf016,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: 'insertGeneExport'
                }, {
                    text: '修改',
                    glyph: 0xf0f6,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: 'updateGeneExport'
                }]
            }]

        });
        this.store.load();
        this.callParent(arguments);
    }
});
