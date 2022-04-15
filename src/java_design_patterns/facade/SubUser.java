package java_design_patterns.facade;

/**
 * 子系统1  用户系统
 * */
public class SubUser {

    public void login(){
        System.out.println("用户 --登录");
    }

    public void openVip(){
        System.out.println("用户 --开通会员");
    }

    public void pay(){
        System.out.println("用户 --付款购买");
    }
}
