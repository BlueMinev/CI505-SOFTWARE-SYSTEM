package System;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<StudentRecord> students = new ArrayList<>();
        students.add(new StudentRecord(
                1,
                "Joe",
                "Bloggs",
                2,
                Courses.MARKETING,
                Map.of("M502", 50, "M556", 60, "M542", 40)

        ));
        students.add(new StudentRecord(
                2,
                "Jane",
                "Doe",
                1,
                Courses.COMPUTING,
                Map.of("C402", 46, "C456", 6, "C442", 47)

        ));
        students.add(new StudentRecord(
                3,
                "Thomas",
                "Smith",
                2,
                Courses.ARCHITECTURE,
                Map.of("A502", 89, "A556", 85, "A542", 78)

        ));
        students.add(new StudentRecord(
                4,
                "Richard",
                "Cox",
                3,
                Courses.ART,
                Map.of("AR602", 59, "AR656", 92, "AR642", 95)

        ));
        students.add(new StudentRecord(
                5,
                "Harry",
                "Cuts",
                1,
                Courses.MUSIC,
                Map.of("MU402", 94, "MU456", 28, "MU442", 59)


        ));
        students.add(new StudentRecord(
                6,
                "Emily",
                "Johnson",
                2,
                Courses.MARKETING,
                Map.of("M502", 75, "M556", 80, "M542", 65)
        ));

        students.add(new StudentRecord(
                7,
                "David",
                "Williams",
                1,
                Courses.COMPUTING,
                Map.of("C402", 70, "C456", 82, "C442", 60)
        ));

        students.add(new StudentRecord(
                8,
                "Sophia",
                "Anderson",
                3,
                Courses.ARCHITECTURE,
                Map.of("A502", 92, "A556", 88, "A542", 79)
        ));

        students.add(new StudentRecord(
                9,
                "Jessica",
                "Miller",
                2,
                Courses.ART,
                Map.of("AR602", 75, "AR656", 88, "AR642", 91)
        ));

        students.add(new StudentRecord(
                10,
                "Ryan",
                "Turner",
                1,
                Courses.MUSIC,
                Map.of("MU402", 88, "MU456", 40, "MU442", 70)
        ));
        students.add(new StudentRecord(
                11,
                "Olivia",
                "Brown",
                3,
                Courses.MARKETING,
                Map.of("M502", 80, "M556", 92, "M542", 75)
        ));

        students.add(new StudentRecord(
                12,
                "Daniel",
                "Lee",
                1,
                Courses.COMPUTING,
                Map.of("C402", 65, "C456", 78, "C442", 63)
        ));

        students.add(new StudentRecord(
                13,
                "Ava",
                "Garcia",
                2,
                Courses.ARCHITECTURE,
                Map.of("A502", 85, "A556", 90, "A542", 82)
        ));

        students.add(new StudentRecord(
                14,
                "Mason",
                "Rodriguez",
                3,
                Courses.ART,
                Map.of("AR602", 70, "AR656", 95, "AR642", 89)
        ));

        students.add(new StudentRecord(
                15,
                "Ella",
                "Martinez",
                1,
                Courses.MUSIC,
                Map.of("MU402", 92, "MU456", 50, "MU442", 78)
        ));


        boolean cont = true;
        while (cont) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter the number for which action you would like to do");
            System.out.println("1: view all students sorted by last name");
            System.out.println("2: View a specific students record based on student ID");
            System.out.println("3: Find all students whose first name begins with a letter ");
            System.out.println("4: View all students on a course by grade");
            System.out.println("5: View all students grouped by grade");
            System.out.println("6: View all students by year");
            System.out.println("7: Add a student");
            System.out.println("8: Remove a student");
            System.out.println("9: Finish");
            String StrAns = userInput.nextLine();
            Integer ans = Integer.parseInt(StrAns);

            switch (ans) {
                case (1):
                    // view all students sorted by last name
                    students.stream()
                            .sorted((p1, p2) -> p1.lName().compareTo(p2.lName()))
                            .forEach(System.out::println);
                    break;
                case (2):
                    // view specific student based on student ID
                    System.out.println("Enter Student Id of student you would like to see the information for");
                    String strStuID = userInput.nextLine();
                    Integer StudentID = Integer.parseInt(strStuID);
                    students.stream()
                            .filter(s -> s.studentID() == StudentID)
                            .forEach(System.out::println);
                    break;
                case (3):
                    //find student by first name letter
                    System.out.println("Enter the letter you would like to search");
                    String letter = userInput.nextLine().toUpperCase();
                    students.stream().filter(n -> n.fName().startsWith(letter)).forEach(System.out::println);
                    break;

                case (4):
                    // sort all students by amount of marks in a specific course with a count
                    Courses courseEnum = Queries.CourseToEnum();
                    students.stream()
                            .filter(s -> s.courseName() == courseEnum)
                            .sorted((p1, p2) -> (p1.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element)).compareTo(p2.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element)))
                            .forEach(System.out::println);
                    long count = students.stream()
                            .filter(s -> s.courseName() == courseEnum)
                            .sorted((p1, p2) -> (p1.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element)).compareTo(p2.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element)))
                            .count();
                    System.out.println(count);

                    break;

                case (5):
                    // prints list of students based on grades
                    System.out.println("students with a 1st");
                    students.stream()
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) >= 210)
                            .forEach(System.out::println);
                    System.out.println("students with a 2:1");
                    students.stream()
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) >= 180)
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) < 210)

                            .forEach(System.out::println);
                    System.out.println("students with a 2:2");
                    students.stream()
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) >= 150)
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) < 180)

                            .forEach(System.out::println);
                    System.out.println("students with a 3rd");
                    students.stream()
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) >= 120)
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) < 150)

                            .forEach(System.out::println);
                    System.out.println("students who are failing");
                    students.stream()
                            .filter(s -> s.modulesWMarks().values().stream().reduce(0, (subtotal, element) -> subtotal + element) < 120)
                            .forEach(System.out::println);
                    break;
                case (6):
                    //view students grouped by year
                    System.out.println("students in their first year");
                    students.stream()
                            .filter(s -> s.yrOfStudy()==1)
                            .forEach(System.out::println);
                    System.out.println("students in their second year");
                    students.stream()
                            .filter(s -> s.yrOfStudy()==2)
                            .forEach(System.out::println);
                    System.out.println("students in their third year");
                    students.stream()
                            .filter(s -> s.yrOfStudy()==3)
                            .forEach(System.out::println);
                    break;
                case (7):
                    //add a student
                    students = Queries.AddStudent(students);
                    break;
                case (8):
                    //remove a student
                    students = Queries.RemoveStudent(students);
                    break;
                case (9):
                    cont = false;
                    break;
                default:
                    break;
            }
        }
    }
}
