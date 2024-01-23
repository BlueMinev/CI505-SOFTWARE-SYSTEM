package System;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import java.util.function.Predicate;

public class Queries {


    static Predicate<StudentRecord> fNameHarry =
            s -> Objects.equals(s.fName(), "Harry");


    static Predicate<StudentRecord> yrOfStudy1 =
            s -> s.yrOfStudy() == 1;

    public static Integer GetLastStudentID(List<StudentRecord> students) {
        StudentRecord lastStudent = students.stream().reduce((first, second) -> second)
                .orElse(null);
        Integer lastStudentID = lastStudent.studentID();
        return lastStudentID;
    }

    public static List<StudentRecord> AddStudent(List<StudentRecord> students) {
        Scanner userInput = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter Students First name");
        String fName = userInput.nextLine();

        System.out.println("Enter Students Last name");
        String lName = userInput.nextLine();

        System.out.println("Enter Students Year of Study");
        String yrOfStudyStr = userInput.nextLine();
        // checks Inputted value is valid, if not sets a default value of 1
        int yrOfStudy;
        switch (yrOfStudyStr) {
            case "1", "2", "3", "4", "5":
                yrOfStudy = Integer.parseInt(yrOfStudyStr);
                break;
            default:
                yrOfStudy = 1;
        }

        System.out.println("Enter Students Course Name");
        String courseName = userInput.nextLine();
        courseName = courseName.toLowerCase();
        Courses course;
        Map<String, Integer> modules;

        switch (courseName) {
            case ("art"):
                course = Courses.ART;
                modules = Map.of("AR" + (yrOfStudy + 3) + "02", 50, "AR" + (yrOfStudy + 3) + "56", 50, "AR" + (yrOfStudy + 3) + "42", 50);
                break;
            case ("marketing"):
                course = Courses.MARKETING;
                modules = Map.of("M" + (yrOfStudy + 3) + "02", 50, "M" + (yrOfStudy + 3) + "56", 50, "M" + (yrOfStudy + 3) + "42", 50);
                break;
            case ("computing"):
                course = Courses.COMPUTING;
                modules = Map.of("C" + (yrOfStudy + 3) + "02", 50, "C" + (yrOfStudy + 3) + "56", 50, "C" + (yrOfStudy + 3) + "42", 50);
                break;
            case ("architecture"):
                course = Courses.ARCHITECTURE;
                modules = Map.of("A" + (yrOfStudy + 3) + "02", 50, "A" + (yrOfStudy + 3) + "56", 50, "A" + (yrOfStudy + 3) + "42", 50);
                break;
            case ("music"):
                course = Courses.MUSIC;
                modules = Map.of("MU" + (yrOfStudy + 3) + "02", 50, "MU" + (yrOfStudy + 3) + "56", 50, "MU" + (yrOfStudy + 3) + "42", 50);
                break;
            default:
                course = Courses.NULL;
                modules = Map.of("N" + (yrOfStudy + 3) + "02", 50, "N" + (yrOfStudy + 3) + "56", 50, "N" + (yrOfStudy + 3) + "42", 50);
                break;
        }


        students.add(
                new StudentRecord(
                        (Queries.GetLastStudentID(students) + 1),
                        fName,
                        lName,
                        yrOfStudy,
                        course,
                        modules

                )
        );

        System.out.println("Student added!");
        return students;
    }


    public static List<StudentRecord> RemoveStudent(List<StudentRecord> students) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Student Id of student you would like to remove");
        String strStuID = userInput.nextLine();
        Integer StuID = Integer.parseInt(strStuID);
        System.out.println("Are you sure you want to remove this student Y/N");
        students.stream()
                .filter(s -> s.studentID() == StuID)
                .forEach(System.out::println);
        String confirmation = userInput.nextLine().toUpperCase();
        System.out.println(confirmation);
        switch(confirmation) {
            case("Y"):
                students.remove(StuID - 1);
                System.out.println("Student removed");
                break;
            default:
                System.out.println("Did not remove student");
                break;
        }

        return students;
    }



    public static Courses CourseToEnum() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Students Course Name");
        String courseName = userInput.nextLine();
        courseName = courseName.toLowerCase();
        Courses course;
        Map<String, Integer> modules;

        switch (courseName) {
            case ("art"):
                course = Courses.ART;
                break;
            case ("marketing"):
                course = Courses.MARKETING;
                break;
            case ("computing"):
                course = Courses.COMPUTING;
                break;
            case ("architecture"):
                course = Courses.ARCHITECTURE;
                break;
            case ("music"):
                course = Courses.MUSIC;
                break;
            default:
                course = Courses.NULL;
                break;
        }

        return course;
    }

    public static void stuByGrades(List<StudentRecord> students){
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
    }

    public static void stuByYear(List<StudentRecord> students){
        System.out.println("students in their first year");
        students.stream()
                .filter(yrOfStudy1)
                .forEach(System.out::println);
        System.out.println("students in their second year");
        students.stream()
                .filter(s -> s.yrOfStudy()==2)
                .forEach(System.out::println);
        System.out.println("students in their third year");
        students.stream()
                .filter(s -> s.yrOfStudy()==3)
                .forEach(System.out::println);
    }
}
