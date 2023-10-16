package System;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<StudentRecord> students = List.of(
                new StudentRecord(
                       0001,
                        "Joe",
                        "Bloggs",
                        2,
                        "Marketing",
                        List.of(
                                Map.of("M502",50.6),
                                Map.of("M556", 60.2),
                                Map.of("M542",40.23)
                        )

                ),
                new StudentRecord(
                        0002,
                        "Jane",
                        "Doe",
                        1,
                        "Computing",
                        List.of(
                                Map.of("C502",46.6),
                                Map.of("C556", 69.3),
                                Map.of("C542",47.23)
                        )

                ),
                new StudentRecord(
                        0003,
                        "Thomas",
                        "Smith",
                        2,
                        "Architecture",
                        List.of(
                                Map.of("A502",89.4),
                                Map.of("A556", 85.6),
                                Map.of("A542",78.4)
                        )

                ),
                new StudentRecord(
                        0004,
                        "Richard",
                        "Cox",
                        3,
                        "Art",
                        List.of(
                                Map.of("Ar502",59.8),
                                Map.of("Ar556", 92.6),
                                Map.of("Ar542",95.3)
                        )

                ),
                new StudentRecord(
                        0005,
                        "Harry",
                        "Cuts",
                        1,
                        "Music",
                        List.of(
                                Map.of("Mu502",94.8),
                                Map.of("Mu556", 28.6),
                                Map.of("Mu542",59.3)
                        )

                )
        );
        Predicate<StudentRecord> fNameHarry =
                s -> Objects.equals(s.fName(), "Harry");

        Predicate<StudentRecord> yrOfStudy1 =
                s -> s.yrOfStudy() == 1;

        // find students with first name harry
        students.stream()
                .filter(fNameHarry)
                .forEach(s -> System.out.println(s));

        //find all students in their first yr of study
        students.stream()
                .filter(yrOfStudy1)
                .forEach(s -> System.out.println(s));

        //sorts all students by their last name
        students.stream()
                .sorted((p1, p2)->p1.lName().compareTo(p2.lName()))
                .forEach(s -> System.out.println(s));
    }
}
