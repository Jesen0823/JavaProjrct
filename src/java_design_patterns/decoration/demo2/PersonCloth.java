package java_design_patterns.decoration.demo2;

public class PersonCloth extends Person {
    protected Person mPerson;

    public PersonCloth(Person person){
        this.mPerson = person;
    }

    @Override
    public void dress() {
        mPerson.dress();
    }
}
