Ext.define('Genomics.view.common.HospitalSelect',{
	extend : 'Ext.grid.Panel',
	alias : 'widget.hospitalSelect',
	columns : [
	      {header:gridTitleOrderNo,xtype : 'rownumberer',width : 40},
	      {header : 'ID',dataIndex : 'id',hidden : true},
	      {header : '医院编号',dataIndex : 'hospitalCode',align : 'center',flex : 1},
	      {header : '医院名称',dataIndex : 'hospitalName',align : 'center',flex : 2}
	],
	initComponent:function(){
		var store = this.store;
		Ext.apply(this,{
			bbar: Ext.create('Ext.PagingToolbar', {
		        store: store,
		        //plugins : Ext.create('Genomics.view.common.ComboPageSize'),
		        displayInfo: true,
		        pageSize: 10,
		        displayMsg: '每页显示  {1} 条',
		        emptyMsg: "没有记录",
		        beforePageText : '第',
		        afterPageText : '页   共{0}页',
		        firstText: '第一页',
		        prevText: '前一页',
		        nextText: '后一页',
		        lastText: '最后一页',
		        refreshText: '刷新'
		    })
		});
		this.callParent(arguments);
	}
})