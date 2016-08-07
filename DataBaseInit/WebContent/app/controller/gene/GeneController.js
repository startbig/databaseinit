Ext.define('app.controller.gene.GeneController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.gene.gene',
    requires: [
        'Ext.window.Window',
        'Ext.window.Toast',
        'Ext.form.*',
        'app.store.GeneStore'
    ],
    updateGene: function() {
        grid = Ext.ComponentQuery.query('genepanel')[0];
        rec = grid.getSelection()[0];
        var updatePanel = Ext.create('Ext.form.Panel', {
            layout: 'column',
            frame: true,
            url: 'gene/updateGene',
            defaults: {
                style: 'margin:5px 10px 0px 10px;',
                columnWidth: 0.5
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: '基因亚区',
                labelAlign: 'right',
                hidden: true,
                name: 'id',
                columnWidth: 1

            }, {
                fieldLabel: '基因亚区',
                labelAlign: 'right',
                name: 'geneRegion'

            }, {
                fieldLabel: 'dbINDEL频率*',
                labelAlign: 'right',
                name: 'dbindel'
            }, {
                fieldLabel: 'Hapmap频率*',
                labelAlign: 'right',
                name: 'hapmap'
            }, {
                fieldLabel: '功能改变',
                labelAlign: 'right',
                id: 'gene_featureChange',
                name: 'featureChange'
            }, {
                fieldLabel: '疾病/OMIM号/遗传方式',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                name: 'geneticMode',
                height: 80
            }, {
                fieldLabel: '参考文献',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 80,
                name: 'literature'
            }, {
                fieldLabel: '位点说明',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 80,
                name: 'siteRemark'
            }, {
                fieldLabel: '备注',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 80,
                name: 'remark'
            }, {
                fieldLabel: '修改原因',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 30,
                name: 'updateReason',
                id: 'gene_updateReason'
            }]

        });
        var updateWindow = Ext.create('Ext.window.Window', {
            width: 700,
            height: 550,
            title: '查看详情',
            layout: 'fit',
            buttonAlign: "center", // 按钮显示的位置
            items: updatePanel,
            buttons: [{
                text: '保存',
                handler: function() {
                    var feature = Ext.getCmp('gene_featureChange').getValue();
                    var reason = Ext.getCmp('gene_updateReason').getValue();
                    if (feature != rec.get('featureChange')) {
                        if (reason == "" && reason.length == 0) {
                            showToast('请填写修改原因');
                            return;
                        }
                    }
                    if (updatePanel.isValid()) {
                        updatePanel.submit({
                            method: 'post',
                            waitMsg: '上传中...',
                            success: function(form, action) {
                                var grid = Ext.ComponentQuery.query('genepanel')[0];
                                grid.getStore().load();
                                updateWindow.close();
                                app.Constant.showMsg(app.Constant.addSuccessMsg);
                            },
                            failure: function(form, action) {
                                var msg = action.result.msg;
                                showToast(msg)
                            }


                        })
                    }
                }
            }, {
                text: '关闭',
                handler: function() {
                    updateWindow.close();
                }
            }]

        }).show();
        updatePanel.loadRecord(rec);


    },
    search_info: function(grid, rec) {
        var sample = rec.get('listSample');
        var chip = rec.get('listChip');
        var sampleStore = Ext.create('Ext.data.Store', {
            data: sample,
            fields: ['sampleNum']
        });
        var chipStore = Ext.create('Ext.data.Store', {
            data: chip,
            fields: ['chip']
        });

        var formPanel = Ext.create('Ext.form.Panel', {
            layout: 'column',
            //            frame:true, 
            split: true,
            url: 'gene/updateGene',
            region: 'center', //定位
            defaults: {
                style: 'margin-top:5px;',
                columnWidth: 0.5
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: '基因亚区',
                value: rec.get('id'),
                labelAlign: 'right',
                hidden: true,
                name: 'id',
                columnWidth: 1

            }, {
                fieldLabel: '基因亚区',
                value: rec.get('geneRegion'),
                labelAlign: 'right',
                name: 'geneRegion'

            }, {
                fieldLabel: 'dbINDEL频率*',
                value: rec.get('dbindel'),
                labelAlign: 'right',
                name: 'dbindel'
            }, {
                fieldLabel: 'Hapmap频率*',
                value: rec.get('hapmap'),
                labelAlign: 'right',
                name: 'hapmap'
            }, {
                fieldLabel: '功能改变',
                value: rec.get('featureChange'),
                labelAlign: 'right',
                id: 'gene_featureChange',
                name: 'featureChange'
            }, {
                fieldLabel: '疾病/OMIM号/遗传方式',
                value: rec.get('geneticMode'),
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                name: 'geneticMode',
                height: 80
            }, {
                fieldLabel: '参考文献',
                value: rec.get('literature'),
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'literature'
            }, {
                fieldLabel: '位点说明',
                value: rec.get('siteRemark'),
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'siteRemark'
            }, {
                fieldLabel: '备注',
                value: rec.get('remark'),
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'remark'
            }, {
                fieldLabel: '修改原因',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textfield',
                height: 20,
                name: 'updateReason',
                id: 'gene_updateReason'
            }],
            flex: 6.3

        });
        var chipPanel = Ext.create('Ext.grid.Panel', {
            region: 'east',
            store: chipStore,
            split: true,
            forceFit: true, // 自适应
            columns: [{
                text: '上机芯片',
                dataIndex: 'chip'
            }],
            flex: 2.2
        });
        var samplePanel = Ext.create('Ext.grid.Panel', {
            store: sampleStore,
            split: true,
            region: 'east',
            columns: [
                //            {header:'', xtype : 'rownumberer'},
                {
                    header: '样品编号',
                    dataIndex: 'sampleNum'
                }
            ],
            flex: 1.5
        });
        var window = Ext.create('Ext.window.Window', {
            width: 950,
            height: 550,
            title: '查看详情',
            layout: 'border',
            buttonAlign: "center", // 按钮显示的位置
            items: [formPanel,
                samplePanel, chipPanel
            ],
            buttons: [{
                text: '关闭',
                handler: function() {
                    window.close();
                }
            }]

        }).show();
    },
    upload: function() {
        var window = Ext.create('Ext.window.Window', {
            modal: true,
            layout: 'fit',
            width: 400,
            height: 150,
            closable: true,
            modelValidation: true,
            buttonAlign: "center", // 按钮显示的位置
            title: '新增',
            items: {
                xtype: 'form',
                url: 'analysisExcel',
                bodyPadding: 10,
                border: false,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    name: 'file',
                    xtype: 'filefield',
                    allowBlank: false,
                    fieldLabel: '上传文件',
                    buttonText: '选择文件',
                    labelWidth: 80,
                    width: 300,
                    allowBlank: false,
                    msgTarget: 'under',
                    validator: function(value) {
                        var arr = value.split('.');
                        if (arr[arr.length - 1] != 'xls') {
                            return '文件不合法！！！';
                        } else {
                            return true;
                        }
                    }
                }],
                buttons: [{
                    text: '保存',
                    handler: function() {
                        var form = window.items.get(0).getForm();
                        if (form.isValid()) {
                            form.submit({
                                method: 'post',
                                waitMsg: '上传中...',
                                success: function(form, action) {
                                    var grid = Ext.ComponentQuery.query('genepanel')[0];
                                    grid.getStore().load();
                                    window.close();
                                    app.Constant.showMsg(app.Constant.addSuccessMsg);
                                },
                                failure: function(form, action) {
                                    var msg = action.result.msg;
                                    showToast(msg)
                                }
                            })
                        }
                    }
                }, {
                    text: '重置',
                    handler: function(ctx) {
                        ctx.up('window').down('form').reset();
                    }
                }, {
                    text: '取消',
                    handler: function() {
                        window.hide();
                    }
                }]
            }

        }).show();
    },
    updateRecord: function(grid, rowIndex, colIndex) {
        var rec = grid.getStore().getAt(rowIndex);
        var paramsId = rec.get('id'),
        store = Ext.create('app.store.GeneRecordStore');
        store.load({
            params: {
            	   geneId: paramsId
            }
        });
        var updateRecordPanel = Ext.create('Ext.grid.Panel', {
                store: store,
                forceFit : true,
                columns :[
              			{header:'', xtype : 'rownumberer'},
              			{header:'修改项', align : 'left', dataIndex: 'term'},
              			{header:'修改前', align : 'left', dataIndex: 'oldInfo'},
              			{header:'修改后', align : 'left', dataIndex: 'newInfo'},
              			{header:'修改人', align : 'left', dataIndex: 'createUser'},
              			{header:'修改时间', align : 'left', dataIndex: 'createTime'},
              			{header:'修改原因', align : 'left', dataIndex: 'updateReason'}
              			],
                bbar: Ext.create('app.view.common.CommonPaggingTool', {
                    store: store
                })
         });
        var window = Ext.create('Ext.window.Window', {
                width: 600,
                height: 400,
                title: '查看详情',
                layout: 'fit',
                buttonAlign: "center", // 按钮显示的位置
                items: updateRecordPanel,
                buttons: [{
                    text: '关闭',
                    handler: function() {
                        window.close();
                    }
                }]

            }).show();

            },
            downGeneExcel:function(){
            	window.open('down/GeneExcel?page=1&start=0&limit=20');
            }
});
