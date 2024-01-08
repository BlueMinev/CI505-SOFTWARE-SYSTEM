package System;

import java.util.List;
import java.util.Map;

enum Courses{
        ART,
        MARKETING,
        COMPUTING,
        ARCHITECTURE,
        MUSIC,
        NULL
}
record StudentRecord(
        Integer studentID,
        String fName,
        String lName,
        Integer yrOfStudy,
        Courses courseName,
        Map<String, Integer>  modulesWMarks
        ){}


