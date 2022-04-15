package java_design_patterns.factory.factorymethod;

public class CommonFactory extends PhoneFactory {

    @Override
    public <T extends Phone> T createPhone(Class<T> clazz) {
        Phone phone = null;
        String className = clazz.getName();

        try {
            phone = (Phone) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) phone;
    }
}
