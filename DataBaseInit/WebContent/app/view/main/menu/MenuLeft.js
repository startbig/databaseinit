/** 
 * 树状菜单，显示在主界面的左边 
 */
Ext.define('app.view.main.menu.MenuLeft', {
    extend: 'Ext.tree.Panel',
    id: 'leftmenu',
    alias: 'widget.leftmenu',
    store: Ext.create('app.store.MenuStore'),
    useArrows: true,
    initComponent: function() {
        var menu = Ext.create('Ext.menu.Menu', {
            width: 100,
            bodyPadding: 5,
            items: [{
                text: '新增菜单',
                scope: this,
                glyph: 0xf016,
                handler: this.insertMenu
            }, {
                text: '修改菜单',
                scope: this,
                glyph: 0xf0f6,
                handler: this.updateMenu
            }, {
                text: '删除菜单',
                scope: this,
                glyph: 0xf057,
                handler: this.deleteMenu
            }, {
                text: '新增资源',
                scope: this,
                glyph: 0xf016,
                handler: this.insertResources
            }]
        });
        Ext.apply(this, {
            store: this.store,
            viewConfig: {
                stripeRows: true,
                listeners: {
                    itemcontextmenu: function(tree, record, item, index, e) {
                        e.stopEvent();
                        menu.rec = record;
                        menu.showAt(e.getXY());
                    },
                    itemclick: function(view, record) {
                        var rightMenu = view.up('leftmenu').up('menu').down('rightmenu');
                        var store = rightMenu.getStore();
                        store.proxy.extraParams = {
                            'menuId': record.get('id')
                        };
                        store.load();
                    }
                }
            }
        });
        this.callParent(arguments);
    },
    insertMenu: function(menu) {
        var menu = menu.up('menu');
        this.initMenu(menu, 'add');
    },
    updateMenu: function(menu) {
        var menu = menu.up('menu');
        this.initMenu(menu, 'update');
    },
    initMenu: function(menu, type) {
        var id = menu.rec.get('id');
        var text = menu.rec.get('text');
        var xtype = menu.rec.get('xtype');

        if (type == 'add') {
            if (xtype != null && xtype.length > 0) {
                alert(xtype + '不是根节点不能进行添加');
                return;
            };
        }
        var window = Ext.create('Ext.window.Window', {
            modal: true,
            layout: 'fit',
            width: 400,
            height: 250,
            closable: true,
            modelValidation: true,
            title: type == 'add' ? '新增' : '修改',
            items: {
                xtype: 'form',
                url: type == 'add' ? 'menu/insertMenu' : 'menu/updateMenu',
                bodyPadding: 10,
                border: false,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    name: 'id',
                    value: type == 'add' ? '' : id,
                    xtype: 'textfield',
                    hidden: true
                }, {
                    name: 'parentId',
                    xtype: 'textfield',
                    value: type == 'add' ? id : '',
                    hidden: true
                }, {
                    fieldLabel: '父菜单',
                    xtype: 'displayfield',
                    value: type == 'add' ? text : '',
                    readOnly: true,
                    hidden: type == 'add' ? false : true
                }, {
                    fieldLabel: '菜单名称',
                    name: 'menuName',
                    value: type == 'add' ? '' : text,
                    xtype: 'textfield',
                    allowBlank: false
                }, {
                    fieldLabel: '菜单映射类',
                    xtype: 'textfield',
                    name: 'menuType',
                    value: type == 'add' ? '' : xtype
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
                                    var treeGrid = Ext.ComponentQuery.query('leftmenu')[0];
                                    treeGrid.getStore().load();
                                    window.hide();
                                    app.Constant.showMsg(app.Constant.addSuccessMsg);
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
    insertResources: function(menu) {
        var menu = menu.up('menu');
        var id = menu.rec.get('id');
        var xtype = menu.rec.get('xtype');
        if (xtype == null || xtype.length == 0) {
            alert(xtype + '不是根节点不能进行添加');
            return;
        };
        var window = Ext.create('Ext.window.Window', {
            modal: true,
            layout: 'fit',
            width: 400,
            height: 250,
            closable: true,
            modelValidation: true,
            title: '新增资源',
            items: {
                xtype: 'form',
                url: 'menu/insertResources',
                bodyPadding: 10,
                border: false,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    name: 'menuId',
                    value: id,
                    xtype: 'textfield',
                    hidden: true
                }, {
                    fieldLabel: '资源名称',
                    name: 'resourceName',
                    xtype: 'textfield',
                    allowBlank: false
                }, {
                    fieldLabel: '资源路径',
                    xtype: 'textfield',
                    name: 'resourceUrl',
                    allowBlank: false

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
                                    var treeGrid = Ext.ComponentQuery.query('leftmenu')[0];
                                    treeGrid.getStore().load();
                                    window.hide();
                                    app.Constant.showMsg(app.Constant.addSuccessMsg);
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
    }

})
