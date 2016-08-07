Ext.define("app.view.card.Card", {
    //	requires: ['Ext.tip.QuickTip'],
    requires: [
        'app.controller.gene.GeneController',
        'app.view.card.CardSerch',
        'app.view.card.CardGrid'
    ],
    extend: 'Ext.panel.Panel',
    xtype: 'cardpanel',
    layout:'card',
    controller: 'card',
    items:[{
    	xtype:'genecard'
    },
    {
        xtype:'cardserch'
    },
    {
    	id:'card3',
    	html:'<h1>card3</h1>'
    }],
    
     activeItem:0,
     initComponent: function() {
	 this.callParent(arguments);
}
    
});