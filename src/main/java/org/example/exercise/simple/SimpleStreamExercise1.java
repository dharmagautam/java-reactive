package org.example.exercise.simple;

import org.example.data.SimpleStreamData;
import org.example.model.Players;

import java.util.List;

public class SimpleStreamExercise1 {

  public static void main(String[] args) {

    // Use StreamSources.intNumbersStream() and StreamSources.playerStream()

    // Print all numbers in the intNumbersStream stream
    SimpleStreamData.intNumbersStream().forEach(System.out::println);

    // Print numbers from intNumbersStream that are less than 5
    SimpleStreamData.intNumbersStream().filter(number -> number < 5).forEach(System.out::println);

    // Print the second and third numbers in intNumbersStream that's greater than 5
    SimpleStreamData.intNumbersStream()
        .filter(number -> number > 5)
        .skip(1L)
        .limit(2)
        .forEach(System.out::println);

    //  Print the first number in intNumbersStream that's greater than 5.
    //  If nothing is found, print -1
    Integer integer =
        SimpleStreamData.intNumbersStream().filter(number -> number > 5).findFirst().orElse(-1);
    System.out.println(integer);

    // Print first names of all players in playerStream
    SimpleStreamData.playerStream().map(Players::getName).forEach(System.out::println);

    // Print first names in playerStream for players that have IDs from number stream
    //    Solution-1
    SimpleStreamData.intNumbersStream()
        .flatMap(playerId -> SimpleStreamData.playerStream().filter(player -> player.getId() == playerId))
        .map(Players::getName)
        .forEachOrdered(System.out::println);
    //   Solution-2
    List<Integer> playerIds = SimpleStreamData.intNumbersStream().toList();
    SimpleStreamData.playerStream()
        .filter(player -> playerIds.contains(player.getId()))
        .map(Players::getName)
        .forEach(System.out::println);
  }
}
