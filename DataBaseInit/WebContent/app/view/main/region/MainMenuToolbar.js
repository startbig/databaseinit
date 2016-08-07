/** 
 * 系统的主菜单条，根据MainModel中的数据来生成，可以切换至按钮菜单，菜单树 
 */  
Ext.define('app.view.main.region.MainMenuToolbar', {  
            extend : 'Ext.toolbar.Toolbar',  
            alias : 'widget.mainmenutoolbar',  
  
            defaults : {  
                xtype : 'buttontransparent'  
            },  
  
            items : [{  
                xtype : 'maintop',  
                region : 'north' // 把他放在最顶上  
            }, {  
                xtype : 'mainmenutoolbar',  
                region : 'north' // 把他放在maintop的下面  
            }, {  
                xtype : 'mainbottom',  
                region : 'south' // 把他放在最底下  
            }, {  
                region : 'center', // 中间面版  
                xtype : 'maincenter'  
            }] ,
  
            viewModel : 'main', // 指定viewModel为main  
  
            initComponent : function() {  
  
                // 把ViewModel中生成的菜单items加到此toolbar的items中  
                this.items = this.items.concat(this.getViewModel().getMenus());  
  
                this.callParent();  
            }  
        }); 