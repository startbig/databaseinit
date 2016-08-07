Ext.define("app.view.main.CenterTable", {
    extend: "Ext.panel.Panel",
    xtype: 'content-panel',
    id: 'content-panel',
    requires: [
        "app.view.main.CenterTableController",
        "app.view.main.CenterTableModel"
    ],

    controller: "centertable",
    viewModel: {
        type: "centertable"
    },
    title: '系统',
    closable: true
});
