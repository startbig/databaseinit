Ext.define("app.view.card.CardSerch", {
    extend: 'Ext.panel.Panel',
    id: 'cardserch',
    alias: 'widget.cardserch',
    xtype:'cardserchgrid',
    initComponent: function() {

        var formPanel = Ext.create('Ext.form.Panel', {
            layout: 'column',
            id:'genedeal',
            split: true,
            url: 'gene/updateGene',
            region: 'center', //定位
            defaults: {
                style: 'margin-top:5px;',
                columnWidth: 0.5
            },
            defaultType: 'textfield',
            items: [{
                fieldLabel: '基因亚区',
                labelAlign: 'right',
                hidden: true,
                name: 'id',
                columnWidth: 1

            }, {
                fieldLabel: '基因亚区',
                labelAlign: 'right',
                name: 'geneRegion'

            }, {
                fieldLabel: 'dbINDEL频率*',
                labelAlign: 'right',
                name: 'dbindel'
            }, {
                fieldLabel: 'Hapmap频率*',
                labelAlign: 'right',
                name: 'hapmap'
            }, {
                fieldLabel: '功能改变',
                labelAlign: 'right',
                id: 'gene_featureChange',
                name: 'featureChange'
            }, {
                fieldLabel: '疾病/OMIM号/遗传方式',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                name: 'geneticMode',
                height: 80
            }, {
                fieldLabel: '参考文献',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'literature'
            }, {
                fieldLabel: '位点说明',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'siteRemark'
            }, {
                fieldLabel: '备注',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textareafield',
                height: 85,
                name: 'remark'
            }, {
                fieldLabel: '修改原因',
                labelAlign: 'right',
                columnWidth: 1,
                xtype: 'textfield',
                height: 20,
                name: 'updateReason',
                id: 'gene_updateReason'
            }],
            flex: 6.3

        });
        var chipPanel = Ext.create('Ext.grid.Panel', {
            region: 'east',
            id:'chipstore',
            split: true,
            forceFit: true, // 自适应
            columns: [{
                text: '上机芯片',
                dataIndex: 'chip'
            }],
            flex: 2.2
        });
        var samplePanel = Ext.create('Ext.grid.Panel', {
            split: true,
            id:'samplestore',
            region: 'east',
            columns: [
                //            {header:'', xtype : 'rownumberer'},
                {
                    header: '样品编号',
                    dataIndex: 'sampleNum'
                }
            ],
            flex: 1.5
        });
        Ext.apply(this, {
              layout: 'border',
        	 items:[formPanel,chipPanel,samplePanel],
        	
        	 tbar:[ '->',{
        	    	text:'返回列表',
        	    	handler: function(btn){
        	    		var layout=btn.up('panel').up('panel').getLayout();
        	    		if(layout.getPrev()){
        	    			layout.prev();
        	    		}
        	    	}

        	    }]
        })
        this.callParent(arguments);
    }

});
