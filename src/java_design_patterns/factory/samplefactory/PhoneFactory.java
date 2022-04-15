package java_design_patterns.factory.samplefactory;

public class PhoneFactory {

    public static Phone createPhone(String type){
        Phone phone = null;
        switch (type){
            case "apple":
                phone = new ApplePhone();
                break;
            case "huawei":
                phone = new HuaweiPhone();
                break;
            case "xiaomi":
                phone = new XiaomiPhone();
                break;
        }
        return phone;
    }
}
