Ext.define('app.store.MenuStore', {
    extend: 'Ext.data.TreeStore',
	alias : 'store.treestore',
    root : {
		text : '系统菜单',
		expanded:true
	},
    proxy : {
        type : 'ajax',
        url : 'menu/getMenu',
        reader : {
            typeProperty: 'mtype'
        }
    }
});