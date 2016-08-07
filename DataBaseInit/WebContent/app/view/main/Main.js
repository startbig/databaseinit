/** 
 * This class is the main view for the application. It is specified in app.js as 
 * the "autoCreateViewport" property. That setting automatically applies the 
 * "viewport" plugin to promote that instance of this class to the body element. 
 *  
 * TODO - Replace this content of this view to suite the needs of your 
 * application. 
 */
Ext.define('app.view.main.Main', {
    extend: 'Ext.container.Container',

    xtype: 'app-main',

    uses: ['app.view.main.region.Top',
        'app.view.main.region.Bottom',
        'app.view.main.region.AccordionMainMenu',
        'app.view.main.region.MainMenuTree',
        'app.view.main.CenterTable'


    ],
    controller: 'main',
    // MVVM架构的控制器的名称，会在当前路径中根据‘Main’ + Controller 来确定文件名  
    // 这个我没找到其他任何可以自动加载MainController.js的依据，只能作上面的判断了  
    viewModel: {
        type: 'main'
            // MVVM架构的viewModel的类型，会在当前路径中根据‘Main’ + Model 来确定文件名  
    },
    layout: {
        type: 'border' // 系统的主页面的布局  
    },

    items: [{
        xtype: 'mainmenutree',
        region: 'west', // 左边面板  
        split: true,
        flex:1.72

    }, {
        xtype: 'maintop',
        region: 'north', // 把他放在最顶上
        flex:1
    }
//    }, {
//        region: 'south', // 把他放在最底下
//        tbar: [{
//            xtype: 'combo',
//            labelWidth: '-10',
//            fieldLabel: 'Theme',
//            displayField: 'name',
//            valueField: 'value',
//            //labelStyle: 'cursor:move;',  
//            queryMode: 'local',
//            store: Ext.create('Ext.data.Store', {
//                fields: ['value', 'name'],
//                data: [{
//                    value: 'neptune',
//                    name: 'Neptune主题'
//                }, {
//                    value: 'neptune-touch',
//                    name: 'Neptune Touch主题'
//                }, {
//                    value: 'crisp',
//                    name: 'Crisp主题'
//                }, {
//                    value: 'crisp-touch',
//                    name: 'Crisp Touch主题'
//                }, {
//                    value: 'classic',
//                    name: 'Classic主题'
//                }, {
//                    value: 'gray',
//                    name: 'Gray主题'
//                }, {
//                    value: 'aria',
//                    name: 'ext-theme-aria'
//                }, {
//                    value: 'base',
//                    name: 'ext-theme-base'
//                }, {
//                    value: 'classic',
//                    name: 'ext-theme-classic'
//                },{
//                    value: 'sandbox',
//                    name: 'ext-theme-classic-sandbox'
//                },{
//                    value: 'neutral',
//                    name: 'ext-theme-neutral'
//                }]
//            }),
//            //value: theme,  
//            listeners: {
//                select: function(combo) {
//                    var theme = combo.getValue();
//                    var href = 'ext/packages/ext-theme-' + theme + '/build/resources/ext-theme-' + theme + '-all.css';
//                    var link = Ext.fly('theme');
//
//                    if (!link) {
//                        link = Ext.getHead().appendChild({
//                            tag: 'link',
//                            id: 'theme',
//                            rel: 'stylesheet',
//                            href: ''
//                        });
//                    };
//                    link.set({
//                        href: Ext.String.format(href, theme)
//                    });
//                }
//            }
//        }]
//    }
    , {
        region: 'center',
        xtype: 'content-panel',
        layout: 'fit',
        collapsible: true,
        autoScroll: true,
        closable: false,
        flex:8.28
    }],
    initComponent: function() {
        Ext.setGlyphFontFamily('FontAwesome'); // 设置图标字体文件，只有设置了以后才能用glyph属性  
        this.callParent();
    }
});
