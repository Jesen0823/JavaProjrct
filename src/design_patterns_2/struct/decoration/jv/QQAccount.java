package design_patterns_2.struct.decoration.jv;

public class QQAccount extends Account {

    public QQAccount(IUser user) {
        super(user);
    }

    @Override
    public void login() {
        super.login();
        System.out.println("检查是否安装QQ,用QQ账号登录");
    }
}
