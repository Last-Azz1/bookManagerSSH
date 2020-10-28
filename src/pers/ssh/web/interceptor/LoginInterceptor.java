package pers.ssh.web.interceptor;


import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;
import pers.ssh.domain.User;

public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user= (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(user!=null){
            return actionInvocation.invoke();
        }
        return "loginFailure";//回到登录页面
    }
}
