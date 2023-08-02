package design_patterns_2.struct.decoration.jv;

public class WeixinAccount extends Account {

    public WeixinAccount(IUser user) {
        super(user);
    }

    @Override
    public void login() {
        super.login();
        System.out.println("检查是否安装微信,用微信账号登录");
    }
}
