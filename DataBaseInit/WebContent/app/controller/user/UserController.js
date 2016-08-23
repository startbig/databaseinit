Ext.define('app.controller.user.UserController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.controlleruser',
    requires: [
        'Ext.window.Window',
        'Ext.window.Toast',
        'Ext.form.*',
        'app.store.UserStore',
        'Ext.chart.*'
    ],
    insertUser: function() {
    	
       	var roleStore=Ext.create('app.store.RolesStore',{
    	    fields: ["roleName", "id"]
		});
       	roleStore.load();
    	
        var window = Ext.create('Ext.window.Window', {
            modal: true,
            layout: 'fit',
            width: 400,
            height: 250,
            closable: true,
            modelValidation: true,
            title: '新增',
            items: {
                xtype: 'form',
                url: 'user/insertUser',
                bodyPadding: 10,
                border: false,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [{
                    fieldLabel: '用户名',
                    name: 'loginName',
                    xtype: 'textfield',
                    allowBlank: false
                },
                {
                    fieldLabel: '姓名',
                    name: 'userName',
                    xtype: 'textfield',
                    allowBlank: false
                },{
  				    fieldLabel: '角色',
  				    name: 'roleId',
  				    xtype: 'combobox',
  		            store: roleStore,
  		            editable: false,
  		            displayField: "roleName",
  		            valueField: "id",
  		            emptyText: "--请选择--",
  		            queryMode: "local",
  				    allowBlank: false
  				}, {
                    fieldLabel: '邮箱',
                    xtype: 'textfield',
                    name: 'emailAddress',
                    allowBlank: false

                }],
                buttons: [{
                    text: '保存',
                    handler: function() {
                        var form = window.items.get(0).getForm();
                        if (form.isValid()) {
                            form.submit({
                                method: 'post',
                                waitMsg: '上传中...',
                                success: function(form, action) {
                                    var grid = Ext.ComponentQuery.query('userpanel')[0];
                                    grid.getStore().load();
                                    window.close();
                                    app.Constant.showMsg(app.Constant.addSuccessMsg);
                                },
                                failure: function(form, action) {
                                    var msg = action.result.msg;
                                    showToast(msg)


                                }


                            })
                        }
                    }
                }, {
                    text: '重置',
                    handler: function(ctx) {
                        ctx.up('window').down('form').reset();
                    }
                }, {
                    text: '取消',
                    handler: function() {
                    	 window.close();
                    }
                }]
            }

        }).show();
    }

});
