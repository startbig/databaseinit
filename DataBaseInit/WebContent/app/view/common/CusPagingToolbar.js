Ext.define('app.view.common.CusPagingToolbar', { 
	extend : 'Ext.toolbar.Paging',
alias : 'widget.cuspagingtoolbar',
displayInfo : true,
prependButtons : true,
dock : 'bottom',
initComponent : function() {
var me = this;
me.items = [ {
xtype : 'combobox',
fieldLabel : '每页显示',
width : 120,
editable : false,
labelWidth : 60,
store : [ '10', '20', '25', '30' ],
listeners : {
afterrender : function(combo, eOpts) {
combo.setValue(combo.ownerCt.getStore().getPageSize());
},
select : function(combo, records, eOpts) {
var ownerCt = combo.ownerCt, store = ownerCt.getStore();
store.pageSize = combo.getValue();
store.currentPage = 1;
ownerCt.doRefresh();
}
}
} ];
me.callParent();
me.on('afterrender', function() {
console.log(me.ownerCt);
me.ownerCt.on('reconfigure', function() {
me.bindStore(me.ownerCt.store || 'ext-empty-store', true);
});

});
}
})