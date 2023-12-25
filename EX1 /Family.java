import java.util.ArrayList;
import java.util.List;

public class Family {
    private static void unmarriedPerson(Person person) {
        if (!person.isMarried()) {
            System.out.println(person.getName());
        }

        person.getChildren().forEach(Family::unmarriedPerson);
    }

    private static void coupleTwoChild(Person person) {
        if (person.isMarried() && person.getChildren().size() == 2) {
            System.out.printf("%s and %s%n", person.getName(), person.getSpouse().getName());
        }

        person.getChildren().forEach(Family::coupleTwoChild);
    }

    private static void latestGeneration(Person person) {
        List<Person> latestGeneration = new ArrayList<>();
        findLatestGenerationUtil(person, latestGeneration);

        latestGeneration.forEach(p -> System.out.println(p.getName()));
    }

    private static void findLatestGenerationUtil(Person person, List<Person> latestGeneration) {
        person.getChildren().forEach(child -> {
            if (child.getChildren().isEmpty()) {
                latestGeneration.add(child);
            } else {
                findLatestGenerationUtil(child, latestGeneration);
            }
        });
    }

    public static void main(String[] args) {
        Person James = new Person("James", "Male", "12/01/1975");


        Person Hana = new Person("Hana", "Female", "27/06/1972");
        Person Ryan = new Person("Ryan", "Male", "03/09/1995");


        Person Kai = new Person("Kai", "Male", "27/07/1997");
        Person Jennifer = new Person("Jennifer", "Female", "31/11/1997");

        Person John = new Person("John", "Male", "12/09/2004");
        Person Davis = new Person("Davis", "Male", "01/04/2005");
        Person Taylor = new Person("Taylor", "Female", "31/03/2007");
        Person Emma = new Person("Emma", "Female", "29/08/2009");

        James.marry(Hana);
        James.addChild(Ryan);
        James.addChild(Kai);

        Kai.marry(Jennifer);

        Kai.addChild(John);
        Kai.addChild(Davis);
        Kai.addChild(Taylor);
        Kai.addChild(Emma);

        System.out.println("Person who is not married: ");
        unmarriedPerson(James);

        System.out.println("Couple with two children: ");
        coupleTwoChild(James);

        System.out.println("Person who is in the latest generation: ");
        latestGeneration(James);
    }
}
