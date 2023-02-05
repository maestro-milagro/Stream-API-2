import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(townGeneration().stream()
            .filter(x->x.getAge()<18)
            .count());
        System.out.println(townGeneration().stream()
                .filter(x->x.getSex()==Sex.MALE)
                .filter(x->x.getAge()>18)
                .filter(x->x.getAge()<27)
                .map(x->x.getFamily())
                .collect(Collectors.toList()));
        System.out.println(townGeneration().stream()
                .filter(x -> ((x.getSex()==Sex.MALE)&&(x.getAge() > 18)&&(x.getAge()<65))||((x.getSex()==Sex.FEMALE)&&(x.getAge() > 18)&&(x.getAge()<60)))
                .filter(x -> x.getEducation() == Education.HIGHER)
                .map(x->x.getFamily())
                .sorted()
                .collect(Collectors.toList()));


    }
    public static Collection<Person> townGeneration(){
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
