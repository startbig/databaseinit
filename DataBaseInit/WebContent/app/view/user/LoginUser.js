Ext.define("app.view.user.LoginUser", {
    extend: 'Ext.grid.Panel',
//    xtype: 'userpanel',
//    requires: [
//        'app.controller.user.UserController'
//        ],
//    controller: 'controlleruser',
    forceFit: true, // 自适应
//    enableHdMenu: false,
//    selModel: {
//        selType: 'rowmodel', // rowmodel is the default selection model
//        mode: 'MULTI' // Allows selection of multiple rows
//     },
    
    store: Ext.create('app.store.UserStore'),
  
    initComponent: function() {
        Ext.apply(this, {
            columns: [{
                header: "",
                xtype: 'rownumberer'
            }, {
                header: '登录名',
                align: 'left',
                dataIndex: 'loginName'

            }, {
                header: '姓名',
                align: 'left',
                dataIndex: 'userName'

            }, {
                header: '邮箱',
                align: 'left',
                dataIndex: 'emailAddress'

            }, {
                header: '创建人',
                align: 'left',
                dataIndex: 'createUser'
            }, {
                header: '创建时间',
                align: 'left',
                dataIndex: 'createTime',
                renderer: function(value, meta, record) {
                  return Ext.Date.format(value,'yyyy-MM-dd');
                  
                }
                	
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
                allowToggle: false,
                items: [{
                    style: 'margin-left:10px',
                    xtype: 'textfield',
                    name: 'searchField',
                    hideLabel: true,
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
                    text: '新增',
                    style: 'margin-left:10px',
                    glyph: 0xf016,
                    xtype: 'button',
                    handler: 'insertUser'
                }, {
                    text: '修改',
                    glyph: 0xf0f6,
                    scope: this,
                    xtype: 'button',
                    style: 'margin-left:10px',
                    handler: this.onSync
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
