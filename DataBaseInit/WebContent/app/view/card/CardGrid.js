Ext.define("app.view.card.CardGrid", {
    //	requires: ['Ext.tip.QuickTip'],
    requires: [
        'app.controller.card.CardController'
    ],
    extend: 'Ext.grid.Panel',
    alias: 'widget.genecard',
    xtype:'genecard',
    viewConfig: {
        enableTextSelection: true
    },
    store: Ext.create('app.store.GeneStore'),
    reference: 'geneSelect',
    listeners:{ 
    	rowdblclick : 'search_info'          		
    },
    initComponent: function() {
        Ext.tip.QuickTipManager.init();
        Ext.apply(this, {
            columns: [{
                header: '',
                xtype: 'rownumberer',
                width:40
            }, {
                header: '疾病表型',
                align: 'left',
                dataIndex: 'diseasePhenotype'
            }, {
                header: '基因',
                align: 'left',
                dataIndex: 'gene'
            }, {
                header: '参考序列/转录本',
                align: 'left',
                dataIndex: 'sequence',
                width:120
            }, {
                header: '核苷酸变化',
                align: 'left',
                dataIndex: 'nucleotide'
            }, {
                header: '氨基酸变化',
                align: 'left',
                dataIndex: 'aminophenol'
            }, {
                header: '基因亚区',
                align: 'left',
                dataIndex: 'geneRegion'
            }, {
                header: '染色体位置',
                align: 'left',
                dataIndex: 'chromosome'
            }, {
                header: 'rs号',
                align: 'left',
                dataIndex: 'rsnum'
            }, {
                header: '千人频率*',
                align: 'left',
                dataIndex: 'frequency'
            }, {
                header: '本地频率*',
                align: 'left',
                dataIndex: 'localFrequency'
            }, {
                header: '功能改变',
                align: 'left',
                dataIndex: 'featureChange'
            }, {
                header: '突变类型',
                align: 'left',
                dataIndex: 'mutationType'
            }, {
                header: '参考文献',
                align: 'left',
                dataIndex: 'literature'
            }, {
                header: '位点说明',
                align: 'left',
                dataIndex: 'siteRemark'
            }, {
                header: '备注',
                align: 'left',
                dataIndex: 'remark',
                renderer: function(value, meta, record) {
                     var max = 15; //显示多少个字符
                     if(value!=null&&value.length>0){
                    	  meta.tdAttr = 'data-qtip="' + value + '"';
                          return value.length < max ? value : value.substring(0, max - 3) + '...';
                     }
                   
                 }
            }, {
                header: '状态',
                align: 'left',
                dataIndex: 'status',
                hidden: true
            }, {
                header: '创建人',
                align: 'left',
                dataIndex: 'createUser',
                hidden: true
            }, {
                header: '创建时间',
                align: 'left',
                dataIndex: 'createTime'
            }, {
                menuDisabled: true,
                header: '操作',
                align: 'center',
                xtype: 'actioncolumn',
                items: [{
                    icon: 'resources/image/search.gif',
                    handler: 'updateRecord'
                }]
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
                    glyph: 0xf093,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: 'insert'
                }, {
                    text: '修改',
                    glyph: 0xf0f6,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: 'updateGene',
                    bind: {
                        disabled: '{!geneSelect.selection}'
                    }
                },{
                    text: '导出',
                    glyph: 0xf019,
                    xtype: 'button',
                    scope:this,
                    style: 'margin-left:10px',
                    handler: this.downGeneExcel
                }]
            }]
        });
        this.store.load();
        this.callParent(arguments);
    },
    downGeneExcel:function(){
    	var store=this.store;
    	var start = store.lastOptions.start;
    	var limit = store.lastOptions.limit;
    	var page = store.lastOptions.page;
    	window.open('down/GeneExcel?page='+page+'&start='+start+'&limit='+limit+'');
    }
    
});
