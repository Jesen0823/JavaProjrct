package design_patterns_2.action.status;

public class LoginedState implements UserState{
    @Override
    public void forward() {
        System.out.println("转发文章");
    }

    @Override
    public void comment() {
    System.out.println("发布评论");
    }

    @Override
    public void share() {
        System.out.println("分享文章");
    }
}
