/** 
 * 树状菜单，显示在主界面的左边 
 */  
Ext.define('app.view.main.region.MainMenuTree', {  
	    extend : 'Ext.tree.Panel',
		alias : 'widget.mainmenutree',
		layout : 'fit',
		collapsible : true,
		split : true,
		title : '系统菜单',
		useArrows : true,
		listeners : {
			select : 'onMenuItemSelect'
		},
		store:  Ext.create('app.store.UserMenuStore'),
		expanded:true,
		rootVisible : false,


})