import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final String gender;
    private final String birthDate;
    private final List<Person> children;
    private Person spouse;

    public Person(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.birthDate = dateOfBirth;
        this.children = new ArrayList<>();
        this.spouse = null;
    }

    public void marry(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return new ArrayList<>(children);
    }

    public Person getSpouse() {
        return spouse;
    }

    public boolean isMarried() {
        return spouse != null;
    }
}
