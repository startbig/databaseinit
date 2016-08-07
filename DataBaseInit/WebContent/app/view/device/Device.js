Ext.define("app.view.device.Device", {
	extend:'Ext.grid.Panel',
	xtype : 'devicepanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true
	},
	
	reference: 'deviceGrid',
	requires: [
	             'app.controller.device.DeviceController'
	         ],
    controller: 'deviceController',
	store: Ext.create('app.store.DeviceStore'),
	initComponent : function(){
		Ext.apply(this,{
			 columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'状态', align : 'left', dataIndex: 'status',renderer:
				function(v){
				if(v=='0'){
					return '未入库';
				}else if(v=='1'){
					return '已入库';
				}
			}},
			{header:'镜头编号', align : 'left', dataIndex: 'deviceNum'},
			{header:'成色', align : 'left', dataIndex: 'deviceCondition'},
			{header:'uv镜', align : 'left', dataIndex: 'uvmirror'},
			{header:'遮光罩', align : 'left', dataIndex: 'lenshood'},
			{header:'采购价', align : 'left', dataIndex: 'price'},
			{header:'汇率', align : 'left', dataIndex: 'rate'},
			{header:'时间', align : 'left', dataIndex: 'storageTime'},
			{header:'供应商', align : 'left', dataIndex: 'supplier'},
			{header:'备注', align : 'left', dataIndex: 'remark'},
			{header:'创建时间', align : 'left', width:145, dataIndex: 'createTime'},
			{header:'创建人', align : 'left', dataIndex: 'createUser'}
			],
		bbar: Ext.create('app.view.common.CommonPaggingTool', {
			 store: this.store
		}),
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
					handler : 'insertDevice'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateDevice',
					bind: {
                          disabled: '{!deviceGrid.selection}'
                    }
				},
				{
					text  : '入库',
					glyph : 0xf090,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'intoStorage',
					bind: {
                          disabled: '{!deviceGrid.selection}'
                    }
				}
				]
			}]
		});
	this.store.load();
	this.callParent(arguments);
	}
});
