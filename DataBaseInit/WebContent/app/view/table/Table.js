Ext.define("app.view.table.Table", {
	extend:'Ext.panel.Panel',
	xtype : 'tablepanel',
	requires: ['app.controller.table.TableController'],
//	forceFit : true,
//	viewConfig:{
//		stripeRows: true,
//		enableTextSelection: true,
//	},
	controller:'tablecontroller',
	dockedItems:[
	{
	xtype:'toolbar',
	items:[
		{
			style: 'margin-left:10px',
			xtype: 'textfield',
			name: 'searchField',
			emptyText:'模糊查询',
			width: 200,
			listeners:{
				change:{
				scope: this,
				fn: this.textSearch,
				buffer: 500
				}
			}
		},
		{
		glyph : 0xf002,
		xtype : 'button',
		style: 'margin-left: -9px;'
		}]
	},
	{
	xtype:'toolbar',
	dock:'top',
	items:[
		{
			text  : '新增',
			glyph : 0xf016,
			xtype : 'button',
			style: 'margin-left:10px',
			handler : 'insertTable'
		},
		{
			text  : '修改',
			glyph : 0xf0f6,
			xtype : 'button',
			style: 'margin-left:10px',
			handler : 'updateTable'
		}
		]
	}]	,
	initComponent : function(){
		var store1=Ext.create('app.store.TableStore');
		var store2=Ext.create('app.store.TableColumnStore');
		var grid1=Ext.create('Ext.grid.Panel',{
			 region: 'west',
			 border:true,
			 bodyBorder:true,
			 store: store1,
			 split: true,
	            forceFit: true,
			 flex: 6,
			 columns :[
						{header:'', xtype : 'rownumberer'},
						{header:'表名', align : 'left', dataIndex: 'tableName'},
						{header:'表备注', align : 'left', dataIndex: 'tableComment'},
						{header:'创建人', align : 'left', dataIndex: 'createUser'},
						{header:'创建时间', align : 'left', dataIndex: 'createTime'}
						],
					bbar: Ext.create('app.view.common.CommonPaggingTool', {
						 store: store1
					}),
					 listeners: {
			                cellclick: function(grid, td, cellIndex, record) {
			                    var id= record.get('id');
			                    store2.proxy.extraParams = {
			                            'tableId': record.get('id')
			                        };
			                        store2.load();
			                }
			            }

			
		});
		var grid2=Ext.create('Ext.grid.Panel',{
			 region: 'center',
			 store: store2,
			 border:true,
			 flex: 4,
			   forceFit: true,
			 columns :[
						{header:'', xtype : 'rownumberer'},
						{header:'字段名称', align : 'left', dataIndex: 'columnName'},
						{header:'字段类型', align : 'left', dataIndex: 'columnType'},
						{header:'表备注', align : 'left', dataIndex: 'columnComment'}
						],
					bbar: Ext.create('app.view.common.CommonPaggingTool', {
						 store: store2
					})
			
		});
		Ext.apply(this,{
			 layout: {
	                type: 'border'
	            },
			items:[grid1,grid2]
		});
	store1.load();
	this.callParent(arguments);
	}
});
