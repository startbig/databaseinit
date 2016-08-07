Ext.define('Genomics.view.common.GridCombobox',{
	extend : 'Ext.form.field.ComboBox',
	alias : 'widget.gridComboSelector',
	triggerAction: 'all',
    typeAhead: true,
    lazyRender:true,
    editable:false,
//    clickToHide : true,
    multi : false,
    comboWidth : null,
 	emptyText:'请选择...',
 	onSelect:Ext.emptyFn ,
	store : Ext.create('Ext.data.ArrayStore', {
		fields: ['value','text'],  
		data:[[]]
	}),
	valueField: 'value',
    displayField: 'text',
	comboGrid : null,
	clickHandler : null,
	loadAction : null,
	listeners : {
		afterrender : function(){
			
		}
	},
    initComponent : function(){
		var me = this;
//		Ext.apply(this,{
//			tpl:'<div id="panel-item-'+this.name+'"></div>'
//		});
	    this.on({
		   expand : {
			   fn : function(combo){
//				    var me = this;
				    var grid = me.comboGrid;
			        if(me.menu == null) {
			        	if(me.multi){
			        		grid.on({
			        			select : function(r, rec, index, opts){
				        			if(me.clickHandler){
				        				me.clickHandler(me,rec);
				        			}else{
				        				var array = me.getRawValue()?me.getRawValue().split(','):new Array();
				        				array.push(rec.get(me.displayField));
			        					me.setRawValue(array.join(','));
			        					
			        					var v_array = me.value?me.value.split(','):new Array();
				        				v_array.push(rec.get(me.valueField));
			        					me.value = v_array.join(',');
				        			}
				        			me.fireEvent('change');
			        			},
			        			deselect : function(r, rec, index, opts){
			        				if(me.getRawValue()){
			        					var array = me.getRawValue().split(',');
			        					Ext.Array.remove(array,rec.get(me.displayField));
			        					me.setRawValue(array.join(','));
			        				}
			        				if(me.value){
			        					var v_array = me.value.split(',');
			        					Ext.Array.remove(v_array,rec.get(me.valueField));
			        					me.value = v_array.join(',');
			        				}
			        				me.fireEvent('change');
			        			}
			        		});
			        	}else{
				        	grid.on({
				        		itemclick : function(view,rec){
				        			if(me.clickHandler){
				        				me.clickHandler(me,rec);
				        				me.menu.hide();
				        			}else{
										if(me.getValue() != rec.get(me.valueField)){
											me.fireEvent('change',me,rec.get(me.valueField),me.getValue());        				
										}
					        			me.value = rec.get(me.valueField);
					        			me.setRawValue(rec.get(me.displayField));
					        			me.menu.hide();
				        			}
				        		}
				        	});
			        	}
			            var showMenu = Ext.create('Ext.menu.Menu', {
							items : [me.comboGrid]
						});
			            grid.width = me.comboWidth?me.comboWidth:(me.getWidth()-this.labelWidth-10);
			            grid.height = me.comboHeight?me.comboHeight:200;
			            grid.enableColumnMove=false;
			            grid.enableColumnResize=true;
			            grid.autoExpandColumn = true;
			            grid.viewConfig={
					         forceFit:true
					    };
			            me.menu = showMenu;
			            me.loadAction?me.loadAction(me,grid):grid.getStore().load();
			        }else{
			        	grid.show();
			        }
			        var dom = me.el;
			        this.menu.showAt(dom.getX()+me.labelWidth+5,dom.getY()+dom.getHeight() );
	   			}
		   }
	   });
	   this.callParent(arguments);
	   this.comboGrid.getStore().load({
		   callback  : function(g,r,s){
		   		if(s){
		   			me.setValue(me.value);
		   		}
	   	   }
	   });
   },
   getValue: function() { 
       return this.value; 
   },
   setValue : function(value){
	   var displayTplData = [];
	   this.value = value;
	   value = Ext.Array.from(value);

       for (var i = 0, len = value.length; i < len; i++) {
           record = value[i];
           if (!record || !record.isModel) {
               record = this.findRecordByValue(record);
           }
           if (record) {
               displayTplData.push(record.data);
           }else {
               if (!this.forceSelection && this.valueField == this.displayField) {
                   dataObj = {};
                   dataObj[this.displayField] = value[i];
                   displayTplData.push(dataObj);
               }
//               else if (Ext.isDefined(valueNotFoundText) {
//                   displayTplData.push(valueNotFoundText);
//               }
           }
       }
       this.displayTplData = displayTplData;
       this.setRawValue(this.getDisplayValue());
       this.checkChange();
   },
   findRecord: function(field, value) {
       var ds = this.comboGrid.getStore();
       if(ds.findExact){
	       var idx = ds.findExact(field, value);
	       return idx !== -1 ? ds.getAt(idx) : false;
       }else{
    	   return false;
       }
   }
});