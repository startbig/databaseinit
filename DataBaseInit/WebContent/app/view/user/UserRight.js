Ext.define('app.view.user.UserRight', {
	extend : 'Ext.tree.Panel',
	id : 'rightuser',
	alias : 'widget.rightuser',
	useArrows : true,
	expanded : true,
	rootVisible : false,
	frame : true,
	initComponent : function() {
	Ext.apply(this, {
		store : {},
	dockedItems : [ {
			dock : 'top',
			xtype : 'toolbar',
			items : [ {
				text : '保存',
				glyph : 0xf0c7,
				scope : this,
				xtype : 'button',
				style : 'margin-left:10px',
				handler : this.saveCheckedNodes
			} ]
		} ]

	});
    this.on('checkchange', this.checkChildrens, this); 
	this.callParent(arguments);
	},
	saveCheckedNodes : function() {
	  	var deal=Ext.getCmp('leftuser');
		var id = deal.getSelection()[0].id;
		var window = this.up('window');
		var records = this.getView().getChecked(),
		ids =new Array();
		Ext.Array.each(records, function(rec) {
			ids.push(rec.get('id'));
		});
		Ext.Ajax.request({
			url : 'insertUserMenus',
			params : {
				meunsId : ids,
				userId :id
			},
			success : function(response) {
				var r = Ext.JSON.decode(response.responseText);
				if (r.success == true) {
					  var grid = Ext.ComponentQuery.query('leftuser')[0];
                      grid.getStore().load();
                      app.Constant.showMsg(app.Constant.addSuccessMsg);				}
			},
			failure : function(response) {

			}
		});
	},
	checkChildrens : function(node, checked) {
		if (node.isRoot()) {
			node.eachChild(function(child) {
				child.set('checked', checked);
				if (!child.data.leaf) {
					child.expand();
					child.fireEvent('checkchange', child, checked);
				}
			});
		} else {
			if (!node.data.leaf) {
				node.expand();
				node.eachChild(function(child) {
					child.set('checked', checked);
					child.fireEvent('checkchange', child, checked);
				});
			}
			if (checked == true && !node.parentNode.isRoot()) {
				node.parentNode.set('checked', checked);
			}
		}
	}

})
