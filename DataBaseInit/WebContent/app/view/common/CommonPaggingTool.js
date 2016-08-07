Ext.define('app.view.common.CommonPaggingTool',{
	extend : 'Ext.PagingToolbar',
	plugins : Ext.create('app.view.common.ComboPageSize'),
    displayInfo: true,
    pageSize: 20,
    displayMsg: '当前显示 {0} - {1} 条     总共 {2}条',
    emptyMsg: "没有记录",
    beforePageText : '第',
    afterPageText : '页   共{0}页',
    firstText: '第一页',
    prevText: '前一页',
    nextText: '后一页',
    lastText: '最后一页',
    refreshText: '刷新'
});