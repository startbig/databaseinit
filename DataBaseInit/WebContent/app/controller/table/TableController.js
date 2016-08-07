Ext.define('app.controller.table.TableController', {
	extend : 'Ext.app.ViewController',
	alias : 'controller.tablecontroller',
	store:Ext.create('app.store.TableColumnStore'),
    requires: ['app.auxiliary.SelectSyscode'
           ],
	insertTable : function() {
		 var rowEditing = new Ext.grid.plugin.CellEditing({
	            clicksToEdit: 1
	        });
		var grid=Ext.create('Ext.grid.Panel',{
			  plugins: [rowEditing],
			  region: 'center', //定位
			  store:this.store,
			  forceFit : true,
			  columns: [{
	                header: '字段名',
	                align: 'left',
	                name: 'columnName',
	                dataIndex: 'columnName',
	                editor: {
	                    allowBlank: false
	                }
	            }, {
	                header: '类型',
	                align: 'left',
	                dataIndex: 'columnType',
	                editor: {
		                xtype:'selectSyscode'
	                }
	            }, {
	                header: '备注',
	                align: 'left',
	                name: 'columnComment232',
	                dataIndex: 'columnComment',
	                editor: {
	                    allowBlank: false
	                }
	            }
			],
			 dockedItems: {
				  xtype: 'toolbar',
	                dock: 'top',
	                items: [{
	                    text: '新增一行',
	                    xtype: 'button',
	                    scope: this,
	                    handler: function(){
	                    	 this.store.insert(0, {});
	                         rowEditing.startEdit(0, 0);
	                    }
	                }, {
                        text: '保存',
                        glyph: 0xf0c7,
                        scope: this,
                        xtype: 'button',
                        style: 'margin-left:10px',
                        handler: this.onSync
                    }]
				  
			  }
		});
		var window = Ext.create('Ext.window.Window', {
//			layout : 'fit',
			 layout: 'border',
	            width: 500,
	            height: 250,
	            closable: true,
			modelValidation : true,
			title : '新增',
			items : [{
				xtype : 'form',
				region: 'north', //定位
				layout : 'column',
				defaults : {
					columnWidth : 0.5
				},
				defaultType: 'textfield',
				items : [ {
					 fieldLabel: '表名',
	                 name: 'tableName',
	                 labelAlign: 'left',
	                 allowBlank: false
				} ,
				{
					 fieldLabel: '表备注',
	                 name: 'tableComment',
	                 labelAlign: 'left',
	                 allowBlank: false
				}
				]
			},grid
			
		]
		}).show();
	},
    onSync: function(ctx) {
    	var window=ctx.up('window');
    	var form=window.down('form').getValues();
    	var grid=ctx.up('grid').getStore();
    	 Ext.apply(form, {
    		 tableColumn : this.storearray(grid)
         });
    	Ext.Ajax.request({
            url: 'table/insertTableList',
            jsonData : form,
            success: function(response) {
                var grid = Ext.ComponentQuery.query('tablepanel')[0];
                grid.getStore().load();
                window.close();
                app.Constant.showMsg(app.Constant.addSuccessMsg);
            },
            failure: function(response) {
                var msg = action.result.msg;
                showToast(msg)


            }
        });
    },
    storearray: function (store) {
        var listData = [];
        store.each(function (rec) {
            listData.push(rec.data);
        });
        return listData;
    }
});