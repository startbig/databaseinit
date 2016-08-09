Ext.define('app.view.main.menu.Menu', {
    extend: 'Ext.panel.Panel',
    requires: ['app.store.MenuStore',
        'app.view.main.menu.MenuLeft',
        'app.view.main.menu.Resources'
    ],
    alias: 'widget.menu',
    xtype: 'menupanel',
    layout: 'border',
    items: [{
        xtype: 'leftmenu',
        region: 'west',
        width: 300,
        split: true,
        title: '菜单列表'

    }, {
        xtype: 'rightmenu',
        title: '资源列表',
        region: 'center'

    }],

    initComponent: function() {
        this.callParent(arguments);
    }

})
