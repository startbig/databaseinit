Ext.define("app.view.order.OrderRight", {
	extend:'Ext.panel.Panel',
	id: 'rightorder',
	alias: 'widget.rightorder',
	items : [{
        overflowY: 'auto',
        xtype: 'dataview',
        id : 'orderdetailTable',
        tpl: Ext.create('Ext.XTemplate',
            '<table class="pmcDetail">',
                '{[this.notAvailable(values.customer, "客户:")]}',
                '{[this.notAvailable(values.customerName, "客户姓名:")]}',
                '{[this.notAvailable(values.customerPhone, "客户电话:")]}',
                '{[this.notAvailable(values.customerAddress, "客户地址:")]}',
                '{[this.notAvailable(values.customerQq,"qq:","qq")]}',
                '{[this.notAvailable(values.remark,"备注:")]}',
            '</table>',

        {
            notAvailable : function (value, laber, type){
                if(type == 'date' && value){
                    value = Ext.Date.format(new Date(value.replace(/T/g, " ").replace(/-/g,"/")), "Y-m-d");
                }
                if(type == 'qq' && value){
                    value ='<a href=tencent://message/?uin=' + value+ '&Menu=yes>'+value+'</a>';
                }
                return value ? '<tr><td class="fst_td">' + laber + '</td><td class="lst_td"><pre class="pmcDetail_pre">' + value + '</pre></td></tr>' : '';
            }
        }),
        itemSelector: 'div.search-item',
        emptyText: '<div class="x-grid-empty">没有数据</div>'
    }],
    initComponent : function() {
        this.callParent();
    }
})