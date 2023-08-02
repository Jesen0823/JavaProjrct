package design_patterns_2.struct.decoration.jv;

import java_design_patterns.observer.WeixinUser;
/**
 * Java 装饰者模式 目的主要是为了 扩展行为
 * 比如 Context- ContextWrap - ContextThemeWrap
 * */
public class DecTest {

    public static void main(String[] args) {
        SanfangUser user = new SanfangUser();
        QQAccount qqAccount = new QQAccount(user);
        WeixinAccount weixinAccount = new WeixinAccount(qqAccount);
        weixinAccount.login();
    }
}
