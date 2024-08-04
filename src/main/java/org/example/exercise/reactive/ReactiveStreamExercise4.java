package org.example.exercise.reactive;

import org.example.data.ReactiveStreamData;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class ReactiveStreamExercise4 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono()
    Mono<Integer> intNumberMono = ReactiveStreamData.intNumberMono();

    // Print the value from intNumberMono when it emits
    intNumberMono.subscribe(System.out::println);

    // Get the value from the Mono into an integer variable
    Integer integer = intNumberMono.block();
    System.out.println("Integer value: " + integer);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
