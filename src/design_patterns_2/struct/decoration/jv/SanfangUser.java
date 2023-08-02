package design_patterns_2.struct.decoration.jv;
/**
 * 被装饰者
 * */
public class SanfangUser implements IUser {

    @Override
    public void login() {
        System.out.println("三方账号 准备登录");
    }
}
