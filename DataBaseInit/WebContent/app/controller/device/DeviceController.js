Ext.define('app.controller.device.DeviceController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.deviceController',
    requires: [
        'Ext.window.Window',
        'Ext.window.Toast',
        'Ext.form.*',
        'Ext.chart.*'
    ],
    insertDevice: function(){
    	this.operationDevice('add');
    },
    operationDevice: function(type,rec) {
    	   var window = Ext.create('Ext.window.Window', {
               modal: true,
               layout: 'fit',
               width: 400,
               height: 390,
               closable: true,
               modelValidation: true,
               title: '新增',
               items: {
                   xtype: 'form',
                   url: 'device/insertDevice',
                   bodyPadding: 10,
                   border: false,
                   layout: {
                       type: 'vbox',
                       align: 'stretch'
                   },
                   defaultType: 'textfield',
                   items: [	{
     				    fieldLabel: '镜头编号',
      				    name: 'deviceNum',
      				    xtype: 'textfield',
      				    allowBlank: false
      				},{
     				    fieldLabel: '成色',
      				    name: 'deviceCondition',
      				    xtype: 'textfield',
      				    allowBlank: false
      				}, {
      				    fieldLabel: 'uv镜',
      				    name: 'uvmirror',
      				    xtype: 'textfield',
      				    allowBlank: false
      				} ,{
      				    fieldLabel: '遮光镜',
      				    name: 'lenshood',
      				    xtype: 'textfield',
      				    allowBlank: false
      				},
      				{
      				    fieldLabel: '采购价',
      				    name: 'price',
      				    xtype: 'numberfield',
      				    allowBlank: false
      				}, {
      				    fieldLabel: '汇率',
      				    xtype: 'numberfield',
      				    name: 'rate',
      				    allowBlank: false
      				}, {
      				    fieldLabel: '时间',
      				    xtype: 'datefield',
      				    name: 'storageTime',
      				    format:"Y-m-d",
      				    allowBlank: false
      				}, 
      				{
      				    fieldLabel: '供应商',
      				    name: 'supplier',
      				    allowBlank: false
      				},{
      				    fieldLabel: '备注',
      				    xtype: 'textarea',
      				    name: 'remark'
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
                                       var grid = Ext.ComponentQuery.query('devicepanel')[0];
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

           });
    	   if(rec){
               var form = window.down('form');
               form.loadRecord(rec);
    	   }
           window.show();

    },
    updateDevice: function(ctx){
    	  var records = ctx.up('grid').getSelection()[0];
    	  this.operationDevice('edit',records);
    },
    intoStorage:function(ctx){
    	  var rec = ctx.up('grid').getSelection()[0];
    	  var id=rec.get('id');
    	  var form={};
    	  form['id']=id;
    	  form['status']='1';
    	  Ext.Ajax.request({
              url: 'device/intoStorage',
              params : form,
              success: function(response) {
                  var grid = Ext.ComponentQuery.query('devicepanel')[0];
                  grid.getStore().load();
                  window.close();
                  app.Constant.showMsg(app.Constant.addSuccessMsg);
              },
              failure: function(response) {
                  var msg = action.result.msg;
                  showToast(msg)
              }
          });
    }
    
    

});
