Ext.define("app.store.ResourcesStore", {
    extend: 'Ext.data.Store',
    fields: [
        'id',
        'resourceName',
        'menuId',
        'createUser',
        'resourceUrl',
        'createTime',
        'menuName'
    ],
    proxy: {
        type: 'ajax',
        url: 'menu/selectResourcesList',
        reader: {
            type: 'json',
            rootProperty: 'root',
            totalProperty: 'total'
        },
        api: {
            update: 'menu/updateResources',
            destroy: 'menu/deleteResources'
        }
    },
    pageSize: 20
});
