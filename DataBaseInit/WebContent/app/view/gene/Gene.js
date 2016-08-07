Ext.define("app.view.gene.Gene", {
    // requires: ['Ext.tip.QuickTip'],
    requires : [ 'app.controller.gene.GeneController',
                 'Ext.grid.selection.SpreadsheetModel',
                
                 'Ext.grid.plugin.Clipboard'],
    extend : 'Ext.grid.Panel',
    xtype : 'genepanel',
    viewConfig : {
        enableTextSelection : true
    },
    selModel: {
    	type: 'spreadsheet',
    	columnSelect: true  // replaces click-to-sort on header
    	},
    plugins: 'clipboard',
    controller : 'gene',
    store : Ext.create('app.store.GeneStore'),
    reference : 'geneSelect',
    listeners : {
        rowdblclick : 'search_info'
    },
    initComponent : function() {
        Ext.tip.QuickTipManager.init();
        Ext.apply(this, {
            columns : [
                    {
                        header : '',
                        xtype : 'rownumberer',
                        width : 40
                    },
                    {
                        header : '疾病表型',
                        align : 'left',
                        dataIndex : 'diseasePhenotype'
                    },
                    {
                        header : '基因',
                        align : 'left',
                        dataIndex : 'gene'
                    },
                    {
                        header : '参考序列/转录本',
                        align : 'left',
                        dataIndex : 'sequence',
                        width : 120
                    },
                    {
                        header : '核苷酸变化',
                        align : 'left',
                        dataIndex : 'nucleotide'
                    },
                    {
                        header : '氨基酸变化',
                        align : 'left',
                        dataIndex : 'aminophenol'
                    },
                    {
                        header : '基因亚区',
                        align : 'left',
                        dataIndex : 'geneRegion'
                    },
                    {
                        header : '染色体位置',
                        align : 'left',
                        dataIndex : 'chromosome'
                    },
                    {
                        header : 'rs号',
                        align : 'left',
                        dataIndex : 'rsnum'
                    },
                    {
                        header : '千人频率*',
                        align : 'left',
                        dataIndex : 'frequency'
                    },
                    {
                        header : '本地频率*',
                        align : 'left',
                        dataIndex : 'localFrequency'
                    },
                    {
                        header : '功能改变',
                        align : 'left',
                        dataIndex : 'featureChange'
                    },
                    {
                        header : '突变类型',
                        align : 'left',
                        dataIndex : 'mutationType'
                    },
                    {
                        header : '参考文献',
                        align : 'left',
                        dataIndex : 'literature'
                    },
                    {
                        header : '位点说明',
                        align : 'left',
                        dataIndex : 'siteRemark'
                    },
                    {
                        header : '备注',
                        align : 'left',
                        dataIndex : 'remark',
                        renderer : function(value, meta, record) {
                            var max = 15; // 显示多少个字符
                            if (value != null && value.length > 0) {
                                meta.tdAttr = 'data-qtip="' + value + '"';
                                return value.length < max ? value : value
                                        .substring(0, max - 3)
                                        + '...';
                            }

                        }
                    }, {
                        header : '状态',
                        align : 'left',
                        dataIndex : 'status',
                        hidden : true
                    }, {
                        header : '创建人',
                        align : 'left',
                        dataIndex : 'createUser',
                        hidden : true
                    }, {
                        header : '创建时间',
                        align : 'left',
                        dataIndex : 'createTime'
                    }, {
                        menuDisabled : true,
                        header : '操作',
                        align : 'center',
                        xtype : 'actioncolumn',
                        items : [ {
                            icon : 'resources/image/search.gif',
                            handler : 'updateRecord'
                        } ]
                    } ],

            bbar : Ext.create('app.view.common.CommonPaggingTool', {
                store : this.store
            }),
            dockedItems : [ {
            	xtype : 'toolbar',
                layout : 'column',
                items : [ {
                    xtype : 'form',
                    layout : 'column',
                    columnWidth : 0.8,
                    defaults : {
                        style : 'margin:5px 10px 10px 10px;',
                        columnWidth : 0.5
                    },
                    items : [ {
                        xtype : 'textfield',
                        fieldLabel : '基因*',
                        name:'gene'
                    }, {
                        xtype : 'textfield',
                        fieldLabel : '核苷酸变化*',
                        name:'nucleotide'
                    }, {
                        xtype : 'textfield',
                        fieldLabel : '基因亚区*',
                        	name:'geneRegion'
                    }, {
                        xtype : 'textfield',
                        fieldLabel : 'rs号*',
                        name:'rsnum'
                    }]
                } ,{
                    xtype      : 'button',
                    text       : '搜索',
                    glyph      : 0xf002,
                    columnWidth : 0.1,
                    style : 'margin-left:10px;margin-top:30px;',
                    handler:function(ctx){
                    	var grid=ctx.up('toolbar').up('grid');
                    	var form=ctx.up('toolbar').down('form');
                    	var store=grid.getStore();
                    	var values=form.getForm().getValues();
                    	var params={};
                    	Ext.Object.each(values,function(key,vaule){
                    		  params[key]=vaule
                    	});
                    	store.proxy.extraParams=params;
                    	store.loadPage(1);
                    }
                    
                }, {
                    xtype      : 'button',
                    text       : '重置',
                    glyph      : 0xf021,
                    columnWidth : 0.1,
                    style : 'margin-left:10px;margin-top:30px;',
                    handler:function(ctx){
                    ctx.up('toolbar').down('form').reset();
                    }
                }

                ]
            }, {
                xtype : 'toolbar',
                dock : 'top',
                items : [ {
                    text : '新增',
                    glyph : 0xf093,
                    xtype : 'button',
                    style : 'margin-left:10px',
                    handler : 'upload'
                }, {
                    text : '修改',
                    glyph : 0xf0f6,
                    xtype : 'button',
                    style : 'margin-left:10px',
                    handler : 'updateGene',
                    bind : {
                        disabled : '{!geneSelect.selection}'
                    }
                }, {
                    text : '导出',
                    glyph : 0xf019,
                    xtype : 'button',
                    scope : this,
                    style : 'margin-left:10px',
                    handler : this.datadeal
                } ]
            } ]
        });
//        this.store.load();
        this.callParent(arguments);
    },
    downGeneExcel : function() {
        var store = this.store;
        var start = store.lastOptions.start;
        var limit = store.lastOptions.limit;
        var page = store.lastOptions.page;
        window.open('down/GeneExcel?page=' + page + '&start=' + start
                + '&limit=' + limit + '');
    },
    datadeal : function() {
        window.open('datainfo');
    }
});
