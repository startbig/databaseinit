Ext.define('app.controller.task.TaskController', {
extend: 'Ext.app.ViewController',
alias: 'controller.taskController',
onConversationBtnClick: function(ctx) {
    var form = ctx.up('form');
    var store=form.up('panel').down('dataview').getStore();
    if (form.getForm().isValid()) {
        form.submit({
        method: 'post',
        waitMsg: '发送中...',
        success: function(form, action) {
        	store.load();
        },
        failure: function(form, action) {
            var msg = action.result.msg;
            showToast(msg)
        }
    });
    }
},
onPmcUploadChange :function(ctx) {
    var form = ctx.up('form');
    var store=form.up('panel').down('dataview').getStore();
    if (form.getForm().isValid()) {
        form.submit({
        method: 'post',
        waitMsg: '上传中...',
        success: function(form, action) {
        	store.load();
        },
        failure: function(form, action) {
            var msg = action.result.msg;
            showToast(msg)
        }
    });
    }
}
});
