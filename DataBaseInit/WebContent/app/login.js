
document.getElementById("login_user").focus();
/**
 * 用户验证
 */
function checkData()
    {
        if(isEmpty(document.getElementById("login_user").value))
        {
          document.getElementById("warning_txt_lgn").innerHTML="请输入用户名!";
          document.getElementById("login_user").focus();
          return false;
        }
        else if(isEmpty(document.getElementById("login_password").value))
        {
          document.getElementById("warning_txt_lgn").innerHTML="请输入密码!";
          document.getElementById("login_password").focus();
          return false;
        }
        return true;
    }
 /**
 是否为空
 */   
function isEmpty(s){
      return ((s == null) || (s.length == 0))
}
 /**
 登陆后验证数据
 */   
function displayerrorDiv(){
       var divs=document.getElementById("warning_txt_lgn");
       if(null!=divs)
       {
         divs.innerHTML=''; 
       }
}