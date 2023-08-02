package design_patterns_2.struct.decoration.jv;
/**
 * 装饰者
 * */
public abstract class Account implements IUser {
    IUser user;

    public Account(IUser user){
        this.user = user;
    }

    @Override
    public void login() {
       user.login();
    }
}
