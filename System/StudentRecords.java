package System;

import java.util.List;
import java.util.Map;

record StudentRecord(
        Integer studentID,
        String fName,
        String lName,
        Integer yrOfStudy,
        String courseName,
        List<Map<String, Double>>  modulesWMarks
        ){}


