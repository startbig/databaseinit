/**
 * 验证输入长度
 * @param obj
 * @param len
 * @param errMsg
 * @return
 */
function validateInputLength(obj, len, errMsg) {
    var byteCount = 0;
    for (var i = 0; i < obj.length; i++) {
        var c = obj.charAt(i);
        if ((/[\u4e00-\u9fa5]+/).test(c)) {
            byteCount += 2;
        } else {
            byteCount += 1;
        }
    }
    if (byteCount > len) {
        Ext.getCmp('errorMsg').el.dom.innerHTML = '<p style="margin:0 0 15 0"><img src="image/icons/errMsg.jpg" width="13" height="13" alt="alt" border="0" style="margin-right:5px;"/><font color="red" >对不起,' + errMsg + '输入长度不能大于' + len + '！</font></p>';
        return false;
    } else {
        return true;
    }
}

/**
 * 验证是否输入
 * @param inputValue
 * @param errMsg
 * @return
 */
function validateIsNotInput(inputValue, errMsg) {
    if (inputValue == null || inputValue == "") {
        Ext.getCmp('errorMsg').el.dom.innerHTML = '<p style="margin:0 0 15 0"><img src="image/icons/errMsg.jpg" width="13" height="13" alt="alt" border="0" style="margin-right:5px;"/><font color="red" >对不起,' + errMsg + '不能为空！</font></p>';
        return false;
    } else {
        return true;
    }
}

/**
 * 操作提示框
 * @param msg
 * @return
 */
function showMesage(msg) {
    var window = new Ext.Window({
        width: 200,
        height: 80,
        layout: 'fit',
        html: '<p style="text-align:center;margin-top:25;">' + msg + '</p>',
        title: "温馨提示:",
        closeAction: "hide"
    });
    window.show();
    //     window.getEl().alignTo(Ext.getBody(), 'br-br','br-br','br','br-br');   
    // 元素从视图中滑出   
    window.getEl().slideIn('t', {
        easing: 'easeOut',
        duration: 500,
        align: 't',
        callback: function() {
            setTimeout(function() {
                window.hide();
            }, 1500);
        }
    });
}
function setDataViewScrollEnd (dataView){
    // 没有找到返回视图总高度的方法
    // 使用多次设置高度来使下拉框最下
    var scrollHeight = 0;
    do {
        scrollHeight += 2000;
        dataView.setScrollY(scrollHeight);
    } while(dataView.getScrollY() > scrollHeight);
}
function showToast(msgText) {
    Ext.MessageBox.show({
        msg: msgText,
        title: "温馨提示:",
        layout: 'fit',
        closable: false
    });
    setTimeout(function() {
        Ext.MessageBox.hide();
    }, 1500);
}
/**
 * ext窗口提示
 * @param msg
 * @return
 */
function extWinShow(msg) {
    Ext.MessageBox.show({
        width: 220,
        title: '提示',
        msg: msg,
        //icon:Ext.Msg.QUESTION,
        icon: 'image/lock.png',
        buttons: Ext.Msg.OK
    });
}

/**
 * ext窗口提示
 * @param msg
 * @return
 */
function showErrorMsg(msg) {
    Ext.MessageBox.show({
        width: 220,
        title: '提示',
        msg: msg,
        icon: Ext.Msg.ERROR,
        buttons: Ext.Msg.OK
    });
}

/**
 * 制作提示框,顶部滑出效果
 * @param msg
 * @return
 */
function showMsg(msg) {
    $("#box").html('<div><b>操作信息</b></div><p>' + msg + '</p>');
    $('#overlay').fadeIn('fast', function() {
        $('#box').animate({
            'top': '10px'
        }, 500);
    });
    setTimeout(function() {
        $('#box').animate({
            'top': '-500px'
        }, 500, function() {
            $('#overlay').fadeOut('fast');
        });
    }, 3000);
}

function addLink(tpanel) {
    if (tpanel == 1) {
        var moduleTabId = 'selfdesktop';
        //获得tabpanel对象
        var tabpanel = Ext.getCmp('module1Frame').getComponent('module1_frame_center');
        //通过编号获得面板
        var tab = tabpanel.getComponent(moduleTabId);
        tabpanel.setActiveTab(tab);
    }
}
//得到昨天日期
function getYestoday(date) {
    var yesterday_milliseconds = date.getTime() - 1000 * 60 * 60 * 24;
    var yesterday = new Date();
    yesterday.setTime(yesterday_milliseconds);

    var strYear = yesterday.getFullYear();
    var strDay = yesterday.getDate();
    var strMonth = yesterday.getMonth() + 1;
    if (strMonth < 10) {
        strMonth = "0" + strMonth;
    }
    if (strDay < 10) {
        strDay = "0" + strDay;
    }
    datastr = strYear + "-" + strMonth + "-" + strDay;
    return datastr;
}
//得到上个月的昨天
function getLastMonthYestday(date) {
    var daysInMonth = new Array([0], [31], [28], [31], [30], [31], [30], [31], [31], [30], [31], [30], [31]);
    var strYear = date.getFullYear();
    var strDay = date.getDate();
    var strMonth = date.getMonth() + 1;
    if (strYear % 4 == 0 && strYear % 100 != 0) {
        daysInMonth[2] = 29;
    }
    if (strMonth - 1 == 0) {
        strYear -= 1;
        strMonth = 12;
    } else {
        strMonth -= 1;
    }
    strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
    if (strMonth < 10) {
        strMonth = "0" + strMonth;
    }
    if (strDay < 10) {
        strDay = "0" + strDay;
    }
    datastr = strYear + "-" + strMonth + "-" + strDay;
    return datastr;
}

function replaceChar(val, index, newChar) {
    var prefixNum = val.substr(0, 2);
    var num = val.substr(3, 7);
    return prefixNum + newChar + num;
}

var PowerResource = function() {
    var obj = new Object();
    obj.init = function() {
        var r = this;
        Ext.Ajax.request({
            url: 'sys/findNoOwnResource.action',
            params: {
                roleId: roleId
            },
            success: function(response) {
                var result = Ext.JSON.decode(response.responseText);
                r.resource = result.root;
            },
            failure: function(response) {
                showErrorMsg("系统错误");
            }
        });
    }


    obj.control = function(elemArray) {
        for (var i = 0; i < elemArray.length; i++) {
            var elem = elemArray[i];
            for (var j = 0; j < this.resource.length; j++) {
                var r = this.resource[j];
                if (r == elem.name) {
                    elem.disabled = true;
                    if (typeof elem.setDisabled == 'function') {
                        elem.setDisabled(true);
                    }
                }
            }
        }
    }
    return obj;
}
var resource = new PowerResource();
