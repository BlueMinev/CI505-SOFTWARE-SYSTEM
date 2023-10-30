package System;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<StudentRecord> students = new ArrayList<>();
                students.add(new StudentRecord(
                        1,
                        "Joe",
                        "Bloggs",
                        2,
                        "Marketing",
                        List.of(
                                Map.of("M502",50.6),
                                Map.of("M556", 60.2),
                                Map.of("M542",40.23)
                        )

                ));
                students.add(new StudentRecord(
                        2,
                        "Jane",
                        "Doe",
                        1,
                        "Computing",
                        List.of(
                                Map.of("C502",46.6),
                                Map.of("C556", 69.3),
                                Map.of("C542",47.23)
                        )

                ));
                students.add( new StudentRecord(
                        3,
                        "Thomas",
                        "Smith",
                        2,
                        "Architecture",
                        List.of(
                                Map.of("A502",89.4),
                                Map.of("A556", 85.6),
                                Map.of("A542",78.4)
                        )

                ));
                students.add(new StudentRecord(
                        4,
                        "Richard",
                        "Cox",
                        3,
                        "Art",
                        List.of(
                                Map.of("Ar502",59.8),
                                Map.of("Ar556", 92.6),
                                Map.of("Ar542",95.3)
                        )

                ));
                students.add(new StudentRecord(
                        5,
                        "Harry",
                        "Cuts",
                        1,
                        "Music",
                        List.of(
                                Map.of("Mu502",94.8),
                                Map.of("Mu556", 28.6),
                                Map.of("Mu542",59.3)
                        )

                ));


        System.out.println("///////////////////////////////////////");
        // find students with first name harry
        students.stream()
                .filter(Queries.fNameHarry)
                .forEach(System.out::println);
        
        System.out.println("///////////////////////////////////////");

        //find all students in their first yr of study
        students.stream()
                .filter(Queries.yrOfStudy1)
                .forEach(System.out::println);

        System.out.println("///////////////////////////////////////");

        //sorts all students by their last name
        students.stream()
                .sorted((p1, p2)->p1.lName().compareTo(p2.lName()))
                .forEach(System.out::println);

        students.add(
                new StudentRecord(
                        6,
                        "Alrin",
                        "Acunin",
                        3,
                        "Computing",
                        List.of(
                                Map.of("C502",79.6),
                                Map.of("C556", 40.3),
                                Map.of("C542",60.23)
                        )

                )
        );

        System.out.println("Added new student");
// working on user input to add new student
        Scanner userInput = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter Students First name");
        String fName = userInput.nextLine();

        System.out.println("Enter Students Last name");
        String lName = userInput.nextLine();

        System.out.println("Enter Students Year of Study");
        String yrOfStudyStr = userInput.nextLine();
        // checks Inputted value is valid, if not sets a default value of 1
        int yrOfStudy;
        switch(yrOfStudyStr) {
            case "1","2","3","4","5":
                yrOfStudy = Integer.parseInt(yrOfStudyStr);
                break;
            default:
                yrOfStudy = 1;
        }



        System.out.println("Enter Students Course Name");
        String courseName = userInput.nextLine();


        students.add(
                new StudentRecord(
                        students.size() + 1,
                        fName,
                        lName,
                        yrOfStudy,
                        courseName,
                        List.of(
                                Map.of("C502",79.6),
                                Map.of("C556", 40.3),
                                Map.of("C542",60.23)
                        )

                )
        );

        //sorts all students by their last name
        students.stream()
                .sorted((p1, p2)->p1.lName().compareTo(p2.lName()))
                .forEach(System.out::println);

    }
}
