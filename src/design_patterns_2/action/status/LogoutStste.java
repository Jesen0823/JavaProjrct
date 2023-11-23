package design_patterns_2.action.status;

public class LogoutStste implements UserState{
    @Override
    public void forward() {
        System.out.println("转发前先登录，跳转登录");
    }

    @Override
    public void comment() {
        System.out.println("评论前先登录，跳转登录");
    }

    @Override
    public void share() {
        System.out.println("分享前先登录，跳转登录");
    }
}
