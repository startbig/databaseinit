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
		store : new Ext.data.TreeStore({
			root : {
				expanded:true
				},
			autoLoad : false
		}),
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
		var window = this.up('window');
		var records = this.getView().getChecked(), ids = [];

		Ext.Array.each(records, function(rec) {
			ids.push(rec.get('id'));
		});
		Ext.Ajax.request({
			url : 'sys/savePurviewsForRole.action',
			params : {
				ids : Ext.JSON.encode(ids),
				roleId : window.roleId
			},
			success : function(response) {
				var r = Ext.JSON.decode(response.responseText);
				if (r.success == true) {
					showMsg(addSuccessMsg);
				}
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
