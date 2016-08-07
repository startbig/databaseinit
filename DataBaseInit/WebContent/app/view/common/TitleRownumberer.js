Ext.define('Genomics.view.common.TitleRownumberer',{
	extend : 'Ext.grid.RowNumberer',
	header:'',
	width : 40,
	align : 'center',
	renderer: function(v, metaData, record, rowIndex, colIndex, store) {
  	  if (this.rowspan){
            metaData.cellAttr = 'rowspan="'+this.rowspan+'"';
        }
//  	  var numCols = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N',
//  	                 'O','P','Q','R','S','T','U','V','W','X','Y','Z'];
        metaData.tdCls = Ext.baseCSSPrefix + 'grid-cell-special';
        return numCols[store.indexOfTotal(record)];
	  }
});