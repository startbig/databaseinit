Ext.define('app.controller.card.CardController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.card',
    detailView:'cardserchgrid',
    insert:function(btn){
    },
    search_info: function(grid, rec) {
    	 var upview=this.getView(),
 	     view=upview.down(this.detailView);
    	   var sample = rec.get('listSample');
           var chip = rec.get('listChip');
           var sampleStore = Ext.create('Ext.data.Store', {
               data: sample,
               fields: ['sampleNum']
           });
           var chipStore = Ext.create('Ext.data.Store', {
               data: chip,
               fields: ['chip']
           });
    	 if(view){
  	     	upview.setActiveItem(view);
  	     	var deal=	Ext.getCmp('genedeal');
  	  	    var chipstore=	Ext.getCmp('chipstore');
  		    var samplestore=	Ext.getCmp('samplestore');
  	     	deal.loadRecord(rec);
  	     	chipstore.setStore(chipStore);
  	     	samplestore.setStore(sampleStore);
  	     	
  	     }
    }
  
});