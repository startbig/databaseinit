Ext.define("app.auxiliary.SelectSyscode", {
	extend:'Ext.form.field.ComboBox',
	 editable: false,
     allowBlank: false,
     queryMode: 'local',
     valueField: 'id',
     displayField : 'name',
     xtype:'selectSyscode',
	 initComponent: function() {
		 var store=Ext.data.Store({
				fields : ["name", "id"],
				data : [{
							name : "DATETIME",
							id : "DATETIME"
						}, {
							name : "VARCHAR",
							id : "VARCHAR"
						}, {
							name : "INT",
							id : "INT"
						}]
			});
		 Ext.apply(this, {
			store: store
		 })
	
		  this.callParent(arguments);
	 }
});