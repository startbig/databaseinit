Ext.define('app.view.group.Group', {
    extend: 'Ext.grid.Panel',
    requires: ['Ext.grid.*', 'Ext.data.*',
        'Ext.util.*', 'app.view.group.groupStore',
        'app.view.common.CusPagingToolbar',
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*'
    ],
    forceFit: true, // 自适应
    xtype: "grouppanel",

    initComponent: function() {
        this.editing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 2
        });
        var store = Ext.create('app.view.group.groupStore', {
            // 此处传递参数 如分页信息
        });
        Ext.apply(this, {
            store: store,
            plugins: [this.editing],
            columns: [{
                header: "",
                xtype: 'rownumberer'
            }, {
                header: '责权',
                align: 'left',
                dataIndex: 'groupName',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '人均通量',
                align: 'left',
                dataIndex: 'flux',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '标准等待时间',
                align: 'left',
                dataIndex: 'waitTime',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '操作者',
                align: 'left',
                dataIndex: 'createUser',
                hidden: true
            }],
            tbar: [{
                text: '新增',
                scope: this,
                glyph: 0xf015,
                xtype: 'button',
                handler: this.onAddClick
            }, {
                text: '保存',
                scope: this,
                xtype: 'button',
                handler: this.onSync
            }],
            bbar: Ext.create('app.view.common.CommonPaggingTool', {
                store: store
            })
        });
    
        this.callParent(arguments);
    },
    onSelectChange: function(selModel, selections) {
        this.down('#delete').setDisabled(selections.length === 0);
    },

    onSync: function() {
        var store = this.getStore();
        store.sync({
            callback: function() {
                store.load();

            }
        });
    },

    onDeleteClick: function() {
        var selection = this.getView().getSelectionModel().getSelection()[0];
        if (selection) {
            this.store.remove(selection);
        }
    },

    onAddClick: function() {
        this.getStore().insert(0, {});
        this.editing.startEditByPosition({
            row: 0,
            column: 0
        });
    }


});
