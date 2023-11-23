package design_patterns_2.action.status;

/**
 * 用户行为接口
 * */
public interface UserState {

    public void forward();

    public void comment();

    public void share();
}
