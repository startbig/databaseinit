Ext.define('app.view.order.Order', {
    extend: 'Ext.panel.Panel',
    requires: [
        'app.view.order.OrderLeft',
        'app.view.order.OrderRight'
    ],
    alias: 'widget.order',
    xtype : 'orderpanel',
    layout: 'border',
    items: [{
        xtype: 'leftorder',
        region: 'west',
        flex: 6,
        split: true,
        title: '订单列表'
    }, {
        xtype: 'rightorder',
        title: '订单详情',
        flex: 4,
        region: 'center'
    }],

    initComponent: function() {
        this.callParent(arguments);
    }

})