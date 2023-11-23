package design_patterns_2.action.status;
/**
 * 状态模式
 * 不同状态对应不同的行为
 * */
public class UserStateTest {
    public static void main(String[] args) {

        UserContext.getsUserContext().forward();
    }
}
