/**
 * 系统主页的顶部区域，主要放置系统名称，菜单，和一些快捷按钮
 */
Ext.define('app.view.main.region.Top', {

	extend : 'Ext.toolbar.Toolbar',

	alias : 'widget.maintop', // 定义了这个组件的xtype类型为maintop
	uses : ['app.ux.ButtonTransparent', 
	        'app.view.main.region.ButtonMainMenu'],  
	style : 'background-color: #2a3f5d; border-bottom: 1px solid #121b28;',
    height:58,	  
	    
	items : [ 
		        { xtype : 'label',
		            bind : {
		                text : '{system.name}'
		            },
		            style : {
		                'color' : '#fff' ,
		                'font-size' : '18px' ,
		                'font-weight' : 'bold' ,
		                'font-family' : 'Microsoft YaHei' ,
		                'letter-spacing' : '1px' ,
		                'padding-left' : '13px;'
		            },
		            flex : 1
		        }, 
			    {
			        xtype: 'segmentedbutton',
			        allowToggle: false,
				    items:        
					[{
						text : '主页',
						glyph : 0xf015,
						handler:'goHome'
					}, 
					{
						text : '帮助',
						glyph : 0xf059
					}, 
					{
						text : getLoginUser().userName,
						glyph : 0xf007
					}, 
					{
						text : '注销',
						glyph : 0xf011,
						handler:function(){
							window.location.href='logout';
					}
				}, 
				{  
			        glyph : 0xf102,  
			        handler : 'hiddenTopBottom',  
			        tooltip : '隐藏顶部和底部区域'  
			    }]}  ]

});