Ext.define('app.store.UserStore', {
    extend: 'Ext.data.Store',
    alias: 'store.userstore',
    fields: [
        'id',
        'userName',
        'loginPass',
        'loginName',
        'emailAddress',
        'createUser',
        'createTime'
    ],
    proxy: {
        type: 'ajax',
        reader: {
            type: 'json',
            rootProperty: 'root',
            totalProperty: 'total'
        },
        api: {
            read: 'user/selectUserList',
            create: 'user/insertUser',
            update: 'user/updateUser',
            destroy: 'user/deleteUser'
        }
    },
    pageSize: 20
});
