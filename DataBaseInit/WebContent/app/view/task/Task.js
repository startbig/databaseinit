Ext.define("app.view.task.Task", {
    extend: 'Ext.panel.Panel',
    xtype: 'taskpanel',
    requires: ['app.model.task.TaskModel', 'app.controller.task.TaskController'],
    viewConfig: {
        enableTextSelection: true
    },
    controller: 'taskController',
    initComponent: function() {
        var resultTpl = Ext.create('Ext.XTemplate',
            '<tpl for=".">',
            // 对话信息
            '<tpl if="type == null || type == \'text\' || type == \'\'">',
            '<div class="chatItem {createUser:this.roleIs}">',
            '<div class="time">',
            '{createTime:this.buildTime}',
            '</div>',
            '<div class="chatItemContent">',
            '<div class="name">{createUser}</div>',
            '<div class="cloud cloudText">',
            '<div class="sendStatus"></div> ',
            '<div class="cloudBody"> ',
            '<div class="cloudContent">',
            '<pre style="white-space:pre-wrap;font-family: Helvetica, 微软雅黑, 黑体, Arial, Tahoma; margin:0;">{replyContent}</pre>',
            '</div>  ',
            '</div> ',
            '<div class="cloudArrow "></div>',
            '</div>',
            '</div>',
            '<div class="clear"></div>',
            '</div>',
            '<tpl elseif="type == \'file\'">',
            '<div class="chatItem {createUser:this.roleIs}">',
            '<div class="time">',
            '{createTime:this.buildTime}',
            '</div>',
            '<div class="chatItemContent">',
            '<div class="name">{createUser}</div>',
            '<div class="file fileOfText">',
            '<a click="downloadMedia" href="javascript:genomics.Constant.downFile(\'{replyContent:this.buildFilePath}\');"> ',
            '<div class="direction fileIcon">',
            '<span class="fileImg"></span>',
            '</div>',
            '<div class="info direction">',
            '<p class="name">',
            '{replyContent:this.getFileName}',
            '</p>',
            '</div>',
            '</a> ',
            '</div>',
            '</div>',
            '<div class="clear"></div>',
            '</div>',

            '<tpl elseif="type == \'img\'">',

            '<div class="chatItem {createUser:this.roleIs}">',
            '<div class="time">',
            '{createTime:this.buildTime}',
            '</div>',
            '<div class="chatItemContent">',
            '<div class="name">{createUser}</div>',
            '<div class="cloud cloudText">',
            '<div class="sendStatus"></div> ',
            '<div class="cloudBody"> ',
            '<div class="cloudContent">',
            '{[this.buildImg(values.replyContent)]}',
            '</div>  ',
            '</div> ',
            '<div class="cloudArrow "></div>',
            '</div>',
            '</div>',
            '<div class="clear"></div>',
            '</div>',

            '</tpl>',
            '</tpl>', {
                lastDate: null,
                formatDate: function(value) {
                    var dt = new Date(value);
                    return Ext.Date.format(dt, "Y-m-d");
                },
                roleIs: function(val) {
                    return val == getLoginUser().userName ? 'me' : 'you'
                },
                buildTime: function(val) {
                    var dt = new Date(val);
                    var strDt = Ext.Date.format(dt, "Y-m-d H:i:s");
                    return '<span class="timeBg left"></span> ' + strDt + ' <span class="timeBg right"></span> ';
                },

                getFileName: function(val) {
                    var path1 = val.lastIndexOf('/');
                    var path2 = val.lastIndexOf('\\');
                    var path = Math.max(path1, path2)
                    return path < 0 ? val : val.substring(path + 1)
                },
                buildFilePath: function(val) {
                    var arr = val.split('\\');
                    return arr.join('\\\\');
                },
                buildImg: function(path) {
                    var img = new Image();
                    img.src = path;
                    img.onload = function() {
                        var dv = Ext.ComponentQuery.query('dataview')[0];
                        setDataViewScrollEnd(dv);
                    }
                    return '<img src="' + path + '">';
                }
            });
        var store1 = Ext.create('app.store.TaskStore');
        var store2 = Ext.create('app.store.AddpmtaskStore');
       
        var grid1 = Ext.create('Ext.grid.Panel', {
            region: 'west',
            store: store1,
            split: true,
            forceFit: true,
            flex: 5.3,
            reference: 'pmcTaskGridData',
            columns: [
                { header: '', xtype: 'rownumberer' },
                { header: '任务内容', align: 'left', dataIndex: 'taskContent' },
                { header: '创建时间', align: 'left', dataIndex: 'createTime' },
                { header: '创建人', align: 'left', dataIndex: 'createUser' }
            ],
            bbar: Ext.create('app.view.common.CommonPaggingTool', {
                store: store1
            }),

            listeners: {
                cellclick: function(grid, td, cellIndex, record) {
                    var taskId = record.get('id');
                    store2.proxy.extraParams = {
                        'taskId': taskId
                    };
                    store2.load();
                    var froms = Ext.ComponentQuery.query("textfield[name=taskId]");
                    Ext.each(froms, function(el) {
                        el.setValue(taskId);
                    });
                }
            }
        });
        var panel = Ext.create('Ext.panel.Panel', {
            region: 'center',
            viewModel: {
                type: 'taskmodel'
            },
            store: store2,
            autoScroll: true,
            flex: 4.7,
            //            controller: 'taskController',
            dockedItems: [{
                dock: 'bottom',
                xtype: 'toolbar',
                hidden: true,
                bind: {
                    hidden: '{isAddPmcTask}'
                },
                items: [{
                    xtype: 'form',
                    url: 'task/uploadFile',
                    frame: true,
                    layout: {
                        type: 'hbox',
                        align: 'middle'
                    },
                    bodyPadding: '4 0 0',
                    items: [{
                        xtype: 'textfield',
                        hidden: true,
                        name: 'taskId'
                    }, {
                        xtype: 'filefield',
                        buttonOnly: true,
                        hideLabel: true,
                        name: 'file',
                        width: 45,
                        buttonConfig: {
                            icon: null,
                            glyph: 0xf093,
                            tooltip: '上传附件',
                            color: '#666',
                            text: '',
                            scale: 'large'
                        },
                        listeners: {
                            change: 'onPmcUploadChange'
                        }
                    }]
                }, {
                    xtype: 'form',
                    url: 'task/insertAddPmcTask',
                    frame: true,
                    layout: 'hbox',
                    flex: 1,
                    layout: {
                        type: 'hbox',
                        align: 'middle'
                    },
                    items: [{
                        xtype: 'textfield',
                        hidden: true,
                        name: 'taskId'
                    }, {
                        xtype: 'textarea',
                        grow: true,
                        growMin: 24,
                        flex: 1,
                        name: 'replyContent',
                        hideLabel: true,
                        maxLength: 250,
                        allowBlank: false,
                        emptyText: '回复内容'
                    }, {
                        xtype: 'button',
                        text: 'Comment',
                        scale: 'large',
                        style: 'margin:0 10px;',
                        glyph: 0xf075,
                        listeners: {
                            click: 'onConversationBtnClick'
                        }
                    }]
                }]
            }],
            items: {
                overflowY: 'auto',
                region: 'center',
                store: store2,
                xtype: 'dataview',
                tpl: resultTpl,
                flex: 4.5,
                itemSelector: 'div.search-item',
                emptyText: '<div class="x-grid-empty">没有数据</div>'
            }
        });
        Ext.apply(this, {
            layout: {
                type: 'border'
            },
            items: [grid1, panel]
        });
        store1.load();
        this.callParent(arguments);
    }
});
