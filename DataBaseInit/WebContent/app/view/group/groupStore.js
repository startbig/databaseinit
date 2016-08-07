Ext.define('app.view.group.groupStore',{
	extend:'Ext.data.Store',
	alias:'store.groupstore',
	fields:[
	 'id',
	 'groupName',
	 'groupArray',
	 'createUser',
	 'createTime',
	 'groupNum',
	 'status',
	 'flux',
	 'waitTime'
	 ],
	 proxy: {
	        type: 'ajax',
	        reader: {
	        type: 'json',
            rootProperty: 'root',
            totalProperty:'total'
	        },
	        api:{
	        read: 'getGroup',
            update: 'updateGroup',
            create: 'insertGroup'
	        }
	      
	  },
	  pageSize: 20
});