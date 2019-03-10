package action;

import com.opensymphony.xwork2.ActionSupport;
import model.User;
import service.AppService;

public class RegisterAction extends ActionSupport {
    private String pwd;
    private String phone;
    private String email;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    @Override
    public String execute() throws Exception {
        User result = appService.getUserByName(name);
        if (result == null) {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPwd(pwd);
            appService.addUser(user);
        } else {
            setName(null);
        }
        return "success";
    }
}
