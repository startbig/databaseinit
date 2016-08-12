Ext.define("app.view.syscode.Syscode", {
	extend:'Ext.grid.Panel',
	xtype : 'syscodepanel',
	forceFit : true,
	viewConfig:{
		stripeRows: true,
		enableTextSelection: true,
	},
	store: Ext.create('app.store.SyscodeStore'),
	reference: 'syscodeGrid',
	requires: [
		'app.controller.syscode.SyscodeController'
	],
	controller: 'syscodecontroller',
	initComponent : function(){
		Ext.apply(this,{
	    columns :[
			{header:'', xtype : 'rownumberer'},
			{header:'Code', align : 'left', dataIndex: 'syscode'},
			{header:'类型', align : 'left', dataIndex: 'systype'},
			{header:'创建人', align : 'left', dataIndex: 'createUser'},
			{header:'创建时间', align : 'left', dataIndex: 'createTime'},
			 {
	                header: '操作',
	                xtype: 'actioncolumn',
	                items: [{
	                    scope: this,
	                    icon: 'resources/image/delete.gif',
	                    handler: this.onDeleteClick
	                }]

	            }],
		features: [{ftype:'grouping'}],	
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
					handler : 'insertSyscode'
				},
				{
					text  : '修改',
					glyph : 0xf0f6,
					xtype : 'button',
					style: 'margin-left:10px',
					handler : 'updateSyscode',
					bind: {
						disabled: '{!syscodeGrid.selection}'
					}
				}
				]
			}]
		});
		this.store.load();
		this.callParent(arguments);
	},
	textSearch: function() {
		var store = this.store;
		var textField = this.down('textfield[name=searchField]').getValue();
		if (app.Constant.isEmpty(textField)) {
			store.load({
			params: {
				syscodeName: textField
			}
		});
		}else{
		store.load();
		}
	},
    onDeleteClick: function(grid, rowIndex, colIndex, item) {
        var record = grid.getStore().getAt(rowIndex);
        var store = this.getStore();
        app.Constant.confirm('删除', '确认删除?', function(btn) {
          var id=record.get('id');
       	  var form={};
       	  form['id']=id;
       	  Ext.Ajax.request({
                 url: 'syscode/deleteSyscode',
                 params : form,
                 success: function(response) {
                	 store.load();
                 },
                 failure: function(response) {
                     var msg = action.result.msg;
                     showToast(msg)
                 }
             });
        });
    }

});
