Ext.define("app.view.syscode.Syscode", {
    extend: 'Ext.grid.Panel',
    xtype: 'syscodepanel',
    requires: ['Ext.grid.*', 'Ext.data.*',
        'Ext.util.*', 'app.view.group.groupStore',
        'app.view.common.CusPagingToolbar',
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*'
    ],
    forceFit: true,
    viewConfig: {
        stripeRows: true,
        enableTextSelection: true
    },
    store: Ext.create('app.store.SyscodeStore'),
    initComponent: function() {

        this.editing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 2
        });
        Ext.apply(this, {
            store: this.store,
            plugins: [this.editing],
            columns: [{
                header: '',
                xtype: 'rownumberer'
            }, {
                header: 'key',
                align: 'left',
                dataIndex: 'key',
                editor: {
                    allowBlank: false
                }
            }, {
                header: 'value',
                align: 'left',
                dataIndex: 'value',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '类型',
                align: 'left',
                dataIndex: 'type',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '备注',
                align: 'left',
                dataIndex: 'remark',
                editor: {
                    allowBlank: false
                }
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
                    scope: this,
                    glyph: 0xf015,
                    xtype: 'button',
                    handler: this.onAddClick
                }, {
                    text: '修改',
                    glyph: 0xf0f6,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: 'updateSyscode'
                }, {
                    text: '保存',
                    glyph: 0xf0c7,
                    scope: this,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: this.onSync
                }]
            }]
        });
        this.store.load();
        this.callParent(arguments);
    },
    textSearch: function() {
        var store = this.store;
        var textField = this.down('textfield[name=searchField]').getValue();
        if (app.Constant.isEmpty(textField)) {
            store.load({
                params: {
                    userName: textField
                }
            });
        } else {
            store.load();
        }
    },
    onSync: function() {
        var store = this.getStore();
        store.sync({
            callback: function() {
                store.load();
                app.Constant.showMsg(app.Constant.addSuccessMsg);

            }
        });
    },
    onAddClick: function() {
        var store = this.store;
        var edit = this.editing;
        var window = Ext.create('Ext.window.Window', {
            modal: true,
            layout: 'fit',
            width: 400,
            height: 250,
            closable: true,
            title: '新增',
            modelValidation: true,
            items: [{
                xtype: 'textarea',
                name: 'insertData'
            }],
            buttons: [{
                text: '保存',
                handler: function() {
                    var textField = window.down('textfield[name=insertData]').getValue();
                    var items = [];
                    var len = textField.split("\n");
                    var lenNum = len.length;
                    for (var i = 0; i < lenNum; i++) {
                        var values = Ext.util.TSV.decode(len[i]);
                        
                        alert(values[0]);
                        var trStr = values.toString().split(",");;
                        items.push({
                            key: trStr[0],
                            value: trStr[1],
                            type: trStr[2],
                            remark: trStr[3]
                        })
                    };
                    store.insert(lenNum, items);
                    edit.startEditByPosition({
                        row: 0,
                        column: 1
                    });
                    window.hide();
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
        }).show();
    }
});
