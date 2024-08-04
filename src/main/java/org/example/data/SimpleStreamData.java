package org.example.data;

import org.example.model.Players;

import java.util.stream.Stream;

public class SimpleStreamData {

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<Players> playerStream() {
        return Stream.of(
                new Players(1, "Virat Kohli", "King Kohli"),
                new Players(2, "MS Dhoni", "Captain Cool"),
                new Players(2, "Sachin Tendulkar", "Master Blaster"),
                new Players(4, "Rohit Sharma", "Hitman"),
                new Players(5, "Ravindra Jadeja", "Sir Jadeja"),
                new Players(6, "Jasprit Bumrah", "Boom Boom")
        );
    }
}
