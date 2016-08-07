Ext.define('app.controller.roles.RolesController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.rolesController',
	store : Ext.create('app.store.TableColumnStore'),
	requires : [ 'app.auxiliary.SelectSyscode' ],
	insertRolesPower : function(ctx) {
		var me = this;
		var grid=ctx.up('grid');
		var  rolesId = grid.getSelection()[0].get('id');
		var store = Ext.create('Ext.data.TreeStore',{
			 root : {
					text : '系统菜单',
					expanded:true,
					checked:false
				},
			    proxy : {
			        type : 'ajax',
			        url : 'menu/selectRolesMenus'
			    }
		});
		store.load({
		    params: {
		        id: rolesId
		    }});
		var store2 = Ext.create('app.store.RoleMenuStore');
		var grid = Ext.create('Ext.grid.Panel', {
			region : 'center',
			store : store2,
			flex : 7,
			columns : [ {
				header : '',
				xtype : 'rownumberer'
			}, {
				header : '资源名称',
				align : 'left',
				dataIndex : 'resourceName',
				editor : {
					allowBlank : false
				}
			}, {
				header : '菜单名称',
				align : 'left',
				dataIndex : 'menuName'

			}, {
				header : '资源链接',
				align : 'left',
				dataIndex : 'resourceUrl',
				editor : {
					allowBlank : false
				}
			}, {
				header : '创建人',
				align : 'left',
				dataIndex : 'createUser',
				hidden : true
			}, {
				header : '创建时间',
				align : 'left',
				dataIndex : 'createTime',
				hidden : true
			} ],
			dockedItems : {
				dock : 'top',
				xtype : 'toolbar',
				items : {
					text : '保存',
					glyph : 0xf0c7,
					scope : this,
					xtype : 'button',
					style : 'margin-left:10px',
					handler : this.addResole
				}

			}

		});
		var tree = Ext.create('Ext.tree.Panel', {
			region : 'west',
			flex : 3,
			store : store,
			autoScroll : true,
			useArrows : true,
			split: true,
			rootVisible : true,
			scope : this,
			listeners:{
				
				checkchange: this.checkTree
			},
			dockedItems : {
				dock : 'top',
				xtype : 'toolbar',
				items : {
					text : '保存',
					glyph : 0xf0c7,
					scope : this,
					xtype : 'button',
					style : 'margin-left:10px',
					handler : this.addTree
				}

			}
		});

		var window = Ext.create('Ext.window.Window', {
			layout : 'border',
			width : 600,
			height : 350,
			autoScroll : true,
			closable : true,
			title : '新增',
			items : [ tree,grid ]
		}).show();
	},
	addTree:function(ctx){
		var tree=ctx.up('panel');
		var records=tree.getView().getChecked();
		Ext.Array.each(records,function(rec){
			alert(rec.get('text'));
		});
	},
	
	onSync : function(ctx) {
		var window = ctx.up('window');
		var form = window.down('form').getValues();
		var grid = ctx.up('grid').getStore();
		Ext.apply(form, {
			tableColumn : this.storearray(grid)
		});
		Ext.Ajax.request({
			url : 'table/insertTableList',
			jsonData : form,
			success : function(response) {
				var grid = Ext.ComponentQuery.query('tablepanel')[0];
				grid.getStore().load();
				window.close();
				app.Constant.showMsg(app.Constant.addSuccessMsg);
			},
			failure : function(response) {
				var msg = action.result.msg;
				showToast(msg)

			}
		});
	},
    checkTree : function(node, checked){
    	if(node.isRoot()){
    		node.eachChild(function(child) {   
    			this.checkAllChildrens();
//    			child.fireEvent('checkAllChildrens',child);
            }); 
    	}else{
    		if(!node.data.leaf){
        		node.expand();
                node.eachChild(function(child) {          
                	child.fireEvent('checkAllChildrens',child);
                });  
        	}
    		if(checked == true && !node.parentNode.isRoot()){
        		node.parentNode.set('checked',checked);
        	}
    	}
    },
	storearray : function(store) {
		var listData = [];
		store.each(function(rec) {
			listData.push(rec.data);
		});
		return listData;
	},
	checkAllChildrens : function() {
		 alert('1111');
//		 node.eachChild(function(child) {  
//				child.set('checked',checked);
//           	if(!child.data.leaf){
//           		child.expand();
//           		if(child.hasChildNodes()){
//           			checkAllChildrens(child);
//           		}
//           	}	
//		 });
	 }
});
