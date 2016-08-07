Ext.define("app.model.task.TaskModel", {
	extend : 'Ext.app.ViewModel',
	alias : 'viewmodel.taskmodel',
    formulas : {
	isAddPmcTask : function(get) {
		var sel = get('pmcTaskGridData.selection');
        if(sel){
        	return false;
        }else{
        	return true;
        }
	}
    }
});
