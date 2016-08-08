/**
 * The main application class. An instance of this class is created by app.js when it calls
 * Ext.application(). This is the ideal place to handle application launch and initialization
 * details.
 */
Ext.define('app.Application', {
    extend: 'Ext.app.Application',
    
    name: 'app',
    requires: [
        'app.Constant'
        ],
    views : [
//            'app.view.*',
        'app.view.user.LoginUser',
        'app.view.group.Group',
        'app.view.main.chart.Chart',
        'app.view.main.menu.Menu',
        'app.view.syscode.Syscode',
        'app.view.gene.Gene',
        'app.view.gene.GeneExport',
        'app.view.card.Card',
        'app.view.task.Task',
        'app.view.table.Table',
        'app.view.roles.Roles',
        'app.view.device.Device',
        'app.view.brand.Brand'
    ],
    launch: function () {
        // TODO - Launch the application
    	 document.getElementById('loading_wrap').style.display = 'none';
    }

});
Ext.Ajax.on("requestcomplete",function(conn,response,options,eOpts ){
    var str = response.responseText;
    if(str == '9999'){
        return false;
    }
    else if(str == '9998'){
        // 超时 跳转到登录页面
    	alert("session已经过期");
        window.parent.location = 'login.jsp';
        return;
    }
});
