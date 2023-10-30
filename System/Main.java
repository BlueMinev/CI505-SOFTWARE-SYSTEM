package System;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<StudentRecord> students = new ArrayList<>();
                students.add(new StudentRecord(
                        1,
                        "Joe",
                        "Bloggs",
                        2,
                        "Marketing",
                        Map.of("M502",50.6,"M556", 60.2,"M542",40.23)

                ));
                students.add(new StudentRecord(
                        2,
                        "Jane",
                        "Doe",
                        1,
                        "Computing",
                        Map.of("C502",46.6,"C556", 69.3,"C542",47.23)

                ));
                students.add( new StudentRecord(
                        3,
                        "Thomas",
                        "Smith",
                        2,
                        "Architecture",
                        Map.of("A502",89.4,"A556", 85.6,"A542",78.4)

                ));
                students.add(new StudentRecord(
                        4,
                        "Richard",
                        "Cox",
                        3,
                        "Art",
                        Map.of("Ar502",59.8,"Ar556", 92.6,"Ar542",95.3)

                ));
                students.add(new StudentRecord(
                        5,
                        "Harry",
                        "Cuts",
                        1,
                        "Music",
                        Map.of("Mu502",94.8,"Mu556", 28.6,"Mu542",59.3)


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

        // currently working on: getting the values of the map to create an average
       //students.stream().forEach(student -> student.modulesWMarks().values().stream().average());


        students.add(
                new StudentRecord(
                        6,
                        "Alrin",
                        "Acunin",
                        3,
                        "Computing",
                        Map.of("C502",79.6,"C556", 40.3,"C542",60.23)
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
                        Map.of("C502",79.6,"C556", 40.3,"C542",60.23)

                )
        );

        //sorts all students by their last name
        students.stream()
                .sorted((p1, p2)->p1.lName().compareTo(p2.lName()))
                .forEach(System.out::println);

    }
}
