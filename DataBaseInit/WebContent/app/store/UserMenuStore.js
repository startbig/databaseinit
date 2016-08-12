Ext.define('app.store.UserMenuStore', {
    extend: 'Ext.data.TreeStore',
    root : {
		text : '系统菜单',
		expanded:true
	},
    proxy : {
        type : 'ajax',
        url : 'getMenu',
        reader : {
            typeProperty: 'mtype'
        }
    }
});