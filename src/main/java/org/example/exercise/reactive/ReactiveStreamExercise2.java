package org.example.exercise.reactive;

import org.example.data.ReactiveStreamData;
import org.example.model.Players;
import reactor.core.publisher.Flux;

import java.io.IOException;

public class ReactiveStreamExercise2 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumbersFlux() and ReactiveSources.playerFlux()
    Flux<Integer> intNumbersFlux = ReactiveStreamData.intNumbersFlux();
    Flux<Players> playersFlux = ReactiveStreamData.playerFlux();

    // Print all numbers in the ReactiveSources.intNumbersFlux stream
    intNumbersFlux.subscribe(System.out::println);

    // Print all players in the ReactiveSources.playersFlux stream
    playersFlux.subscribe(System.out::println);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
