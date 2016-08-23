Ext.define('app.controller.roles.RolesController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.rolesController',
	store : Ext.create('app.store.TableColumnStore'),
	requires : [ 'app.auxiliary.SelectSyscode' ],
	insertRoles: function(){
		this.operationRole('add');
	},
	updateRoles: function(ctx){
		var records = ctx.up('grid').getSelection()[0];
		this.operationRole('edit',records);
	},
	operationRole: function(type,rec) {
		var window = Ext.create('Ext.window.Window', {
			modal: true,
			layout: 'fit',
			width: 400,
			height: 390,
			closable: true,
			modelValidation: true,
			title: type=='add'?'新增':'修改',
			items: {
				xtype: 'form',
				url: type=='add'?'roles/insertRoles':'roles/updateRoles',
				bodyPadding: 10,
				border: false,
				layout: {
					type: 'vbox',
					align: 'stretch'
				},
				defaultType: 'textfield',
				items: [
				{
					hidden:true,
					name:'id'
				},
				{
					fieldLabel: '角色名称',
					name:'roleName'
				}
				],
				buttons: [{
					text: '保存',
					handler: function() {
						var form = window.items.get(0).getForm();
						if (form.isValid()) {
						form.submit({
							method: 'post',
							waitMsg: '上传中...',
							success: function(form, action) {
								var grid = Ext.ComponentQuery.query('rolespanel')[0];
								grid.getStore().load();
								window.close();
								app.Constant.showMsg(app.Constant.addSuccessMsg);
							},
							failure: function(form, action) {
								var msg = action.result.msg;
								if(msg){
								showToast(msg)
								}
								showToast(app.Constant.systemErrorMsg);
							}
							})
						}
					}
				},
				{
				text: '重置',
					handler: function(ctx) {
						ctx.up('window').down('form').reset();
					}
				},
				{
				text: '取消',
					handler: function() {
						window.close();
					}
				}
			]}
		});
		if(rec){
			var form = window.down('form');
			form.loadRecord(rec)
		}
		window.show();
	},
	
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
					url : "getUserMenu",
					reader : {
						typeProperty : 'mtype'
					},
					extraParams:{'id': rolesId}
			    }
		  });
		var tree = Ext.create('Ext.tree.Panel', {
			region : 'west',
			store : store,
			autoScroll : true,
			useArrows : true,
			split: true,
			rootVisible : false,
			scope : this,
			listeners:{
				
				checkchange: this.checkChildrens
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
			width : 300,
			height : 350,
			autoScroll : true,
			closable : true,
			title : '新增',
			layout:'fit',
			items : [ tree ]
		}).show();
	},
	addTree:function(ctx){
		
		var grid=	Ext.getCmp('checkrolespanel');
		var id = grid.getSelection()[0].id;
		var tree=ctx.up('panel');
		var records=tree.getView().getChecked(),
		ids =new Array();
		Ext.Array.each(records, function(rec) {
			ids.push(rec.get('id'));
		});
		Ext.Ajax.request({
			url : 'insertRoleMenus',
			params : {
				meunsId : ids,
				roleId :id
			},
			success : function(response) {
				var r = Ext.JSON.decode(response.responseText);
				if (r.success == true) {
//					  var grid = Ext.ComponentQuery.query('leftuser')[0];
//                      grid.getStore().load();
                      app.Constant.showMsg(app.Constant.addSuccessMsg);	
                      tree.up('window').close();
                      
				}
			},
			failure : function(response) {

			}
		});
	},
	checkChildrens : function(node, checked) {
		if (node.isRoot()) {
			node.eachChild(function(child) {
				child.set('checked', checked);
				if (!child.data.leaf) {
					child.expand();
					child.fireEvent('checkchange', child, checked);
				}
			});
		} else {
			if (!node.data.leaf) {
				node.expand();
				node.eachChild(function(child) {
					child.set('checked', checked);
					child.fireEvent('checkchange', child, checked);
				});
			}
			if (checked == true && !node.parentNode.isRoot()) {
				node.parentNode.set('checked', checked);
			}
		}
	}
});
