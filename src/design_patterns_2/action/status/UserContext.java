package design_patterns_2.action.status;

public class UserContext {
    UserState state = new LoginedState();
    static UserContext sUserContext;

    private UserContext(){}

    public static UserContext getsUserContext() {
        return sUserContext;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public void forward(){
        state.forward();
    }

    public void comment(){
        state.comment();
    }

    public void share(){
        state.share();
    }
}
