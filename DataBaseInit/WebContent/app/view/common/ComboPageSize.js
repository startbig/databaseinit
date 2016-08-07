Ext.define('app.view.common.ComboPageSize',{
	extend: 'Ext.util.Observable', 
    xtype: 'comboPageSize', 
    pageSizes: [5,10, 15, 20, 25, 30, 50, 75, 100, 200, 300, 500],
    addToItem: true,    //true添加到items中去，配合index；false则直接添加到最后
    index: 10,           //在items中的位置
    init: function(pagingToolbar) {
        var ps = this.pageSizes;
        var combo = Ext.create('Ext.form.ComboBox',{
            typeAhead: true,
            lazyRender: true,
            mode: 'local',
            width: 50,
            store: ps,
            enableKeyEvents: true,
            editable: true,
            loadPages: function(size) {
                var store = pagingToolbar.up('grid').store;
                pagingToolbar.pageSize = size;
                pagingToolbar.setSize(size);
                store.pageSize = size;
                store.loadPage(1);
            },
            listeners: {
                select: function(c, r, options) {
//                	alert(r.getData().);
                    this.loadPages(c.getValue());
                }
            }
        });
        if (this.addToItem) {
            var inputIndex = this.index;
            if (inputIndex > pagingToolbar.items.length) inputIndex = pagingToolbar.items.length;
            pagingToolbar.insert(++inputIndex, '-');
            pagingToolbar.insert(++inputIndex, this.prefixText);
            pagingToolbar.insert(++inputIndex, combo);
            pagingToolbar.insert(++inputIndex, this.postfixText);
        }
        else {
            pagingToolbar.add('-');
            pagingToolbar.add(this.prefixText);
            pagingToolbar.add(combo);
            pagingToolbar.add(this.postfixText);
        }
        pagingToolbar.on({
            beforedestroy: function() {
                combo.destroy();
            },
            change: function() {
                combo.setValue(pagingToolbar.pageSize);

            }
        });

    }
});
