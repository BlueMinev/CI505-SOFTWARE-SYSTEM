package System;

import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Queries {

    Consumer<StudentRecord> printToTerminal
            = System.out::println;

    static Predicate<StudentRecord> fNameHarry =
            s -> Objects.equals(s.fName(), "Harry");

     static Predicate<StudentRecord> yrOfStudy1 =
            s -> s.yrOfStudy() == 1;








}
