/**
 * Created with JetBrains WebStorm. User: Administrator Date: 13-11-12 Time: 上午11:44 To change this template use File |
 * Settings | File Templates.
 */

Ext.define("app.Constant", {
     statics: {
        addSuccessMsg           : '保存成功',      // 添加成功
        editSuccessMsg          : '修改成功',   // 修改成功
        deleteSuccessMsg        : '删除成功',   // 删除成功
        systemErrorMsg                   : '系统异常',   // 删除成功
        deleteConfirmMsg        : '<s:text name="ext.alert.msg.deleteConfirm"/>',   // 确认删除
        dataIsUse               : '<s:text name="ext.alert.msg.dataIsUse"/>',       // 数据已被使用
        alertMsg                : '<s:text name="ext.alert.msg.alertmsg"/>',        // 操作提示
        errorMsg                : '<s:text name="ext.alert.msg.useerror"/>',        // 操作失败!
        connTimeOutMsg          : '<s:text name="ext.alert.msg.conntimeout"/>',     // 连接超时
        requesterror            : '<s:text name="ext.alert.requesterror"/>',        // 非法请求
        unSelectedMsg           : '<s:text name="ext.alert.msg.unselect"/>',        // 请选择需要操作的记录!
        gridTitleOrderNo        : '<s:text name="ext.grid.tilte.orderno"/>',        // 序号
        gridTitleCreateUser     : '<s:text name="ext.grid.tilte.createuser"/>',     // 创建人
        gridTitleCreateTime     : '<s:text name="ext.grid.tilte.createtime"/>',     // 创建时间
        gridTitleUpdateUser     : '<s:text name="ext.grid.tilte.updateuser"/>',     // 修改人
        gridTitleUpdateTime     : '<s:text name="ext.grid.tilte.updatetime"/>',     // 修改时间
        queryalertmanysizemsg   : '<s:text name="query.alert.manysize.msg"/>',      // 维度控制提示
        commonPageSize          : 20,
        createUserWidth         : 100,
        createTimeWidth         : 150,


        PMC_STATUS_BEGIN        : 1,            // 咨询中
        PMC_STATUS_QUESTIONING  : 2,            // 问题追加
        PMC_STATUS_ANSWERED     : 3,            // 已回复
        PMC_STATUS_DONE         : 4,            // 已完成

        pmcInfoMsg              : '如当前回复解决了您的问题，请进行“满意度调查“后<span style="color:blue;">【确认验收】</span>;<br>如当前回复未解决您的问题，请进行“回复”后<span style="color:blue;">【提交】</span>!',

        showMsg                 :function (msg){
                                 Ext.toast({
                                 html:msg,
                                 closable:false,
                                 align:'t',
                                 width:300
                                 });
	                            
	                             },
	                             
	    confirm                 :function (title,msg,yes,no){
							    return	Ext.Msg.show({
							    title:title,
							    message: msg,
							    buttons: Ext.Msg.YESNO,
							    icon: Ext.Msg.QUESTION,
								fn: function(btn) {
						        if (btn === 'yes'&&yes) {
						           yes.apply(this.arguments);
						        } else if (btn === 'no'&&no) {
						           no.apply(this.arguments);
						        } 
                                }
							});
	                            },
	    isEmpty             :function (str)   
							{   
							    if(str != null && str.length > 0)   
							    {   
							        return true;   
							    }   
							    return false;   
							}   
  
    },


    
    constructor: function() {

    }
});
