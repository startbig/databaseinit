Ext.define("app.view.main.menu.Resources", {
    extend: 'Ext.grid.Panel',
    xtype: 'resourcespanel',
    requires: ['Ext.grid.*', 'Ext.data.*',
        'Ext.util.*', 'app.view.group.groupStore',
        'app.view.common.CusPagingToolbar',
        'Ext.selection.CellModel',
        'Ext.grid.*',
        'Ext.data.*',
        'Ext.util.*',
        'Ext.form.*'
    ],
    alias: 'widget.rightmenu',
    forceFit: true,
    store: Ext.create('app.store.ResourcesStore'),
    initComponent: function() {
        this.editing = new Ext.grid.plugin.CellEditing({
            clicksToEdit: 1
        });
        Ext.apply(this, {
            plugins: [this.editing],
            store: this.store,
            columns: [{
                header: '',
                xtype: 'rownumberer'
            }, {
                header: '资源名称',
                align: 'left',
                dataIndex: 'resourceName',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '菜单名称',
                align: 'left',
                dataIndex: 'menuName'

            }, {
                header: '资源链接',
                align: 'left',
                dataIndex: 'resourceUrl',
                editor: {
                    allowBlank: false
                }
            }, {
                header: '创建人',
                align: 'left',
                dataIndex: 'createUser',
                hidden: true
            }, {
                header: '创建时间',
                align: 'left',
                dataIndex: 'createTime',
                hidden: true
            }, {
                header: '操作',
                xtype: 'actioncolumn',
                items: [{
                    scope: this,
                    icon: 'resources/image/delete.gif',
                    handler: this.onDeleteClick
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
                dock: 'top',
                xtype: 'toolbar',
                items: [{
                    text: '保存',
                    glyph: 0xf0c7,
                    scope: this,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: this.onSync
                }]
            }]
        });
        this.callParent(arguments);
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
    onDeleteClick: function(grid, rowIndex, colIndex, item) {
        var record = grid.getStore().getAt(rowIndex);
        var store = this.getStore();
        app.Constant.confirm('删除', '确认删除?', function(btn) {
            store.remove(record);
            store.sync({
                success: function(operation) {
                    store.load();
                    app.Constant.showMsg(app.Constant.addSuccessMsg);
                },
                failure: function(optional) {}
            });

        });
    }
});
