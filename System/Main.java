package System;

import java.util.List;
import java.util.function.Predicate;

record BookRecord (
         String title,
         String author,
         Integer releaseYr,
         String genre,
         //in terms of millions for this example
         Integer copiesSold,
         double globalRating
 ){}

public class Main {
    public static void main(String[] args) {
        List<BookRecord> books = List.of(
                new BookRecord(
                        "To Kill a Mockingbird",
                        "Harper Lee",
                        1960,
                        "Fiction",
                        40,
                        4.27
                ),
                new BookRecord(
                        "Harry Potter and the Sorcerer's Stone",
                        "J.K. Rowling",
                        1997,
                        "Fantasy",
                        120,
                        2.1
                ),
                new BookRecord(
                        "The Da Vinci Code",
                        "Dan Brown",
                        2003,
                        "Mystery",
                        80,
                        3.84
                ),
                new BookRecord(
                        "The Hunger Games",
                        "Suzanne Collins",
                        2008,
                        "Dystopian",
                        10,
                        4.33
                ),
                new BookRecord(
                        "1984",
                        "George Orwell",
                        1949,
                        "Dystopian",
                        30,
                        4.19
                )
        );



        Predicate<BookRecord> ratingHigherThan3p5 =
                b -> b.globalRating() >= 3.5;

        Predicate<BookRecord> releaseBefore2000 =
                b -> b.releaseYr() < 2000;


        System.out.println("Books with a rating higher than 3.5: ");
        books.stream()
                .filter(ratingHigherThan3p5)
                        .forEach(item -> System.out.println(item));

        System.out.println("Books released before 2000: ");
        books.stream()
                .filter(releaseBefore2000)
                .forEach(item -> System.out.println(item));

    }
}
