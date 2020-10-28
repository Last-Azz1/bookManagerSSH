package pers.ssh.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import pers.ssh.domain.User;
import pers.ssh.service.UserService;

import javax.servlet.http.HttpSession;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user=new User();
    @Override
    public User getModel() {
        return user;
    }
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String login(){
        User ifUser=userService.login(user);
        if (ifUser!=null){
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("loginUser", user);
            return "loginSuccess";
        }else {
            addActionError("登录失败,用户名或密码错误");
        }
        return "loginFailure";
    }
    public String logout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "loginFailure";
    }
}
