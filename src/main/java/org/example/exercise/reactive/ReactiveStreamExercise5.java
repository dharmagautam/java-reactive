package org.example.exercise.reactive;

import org.example.data.ReactiveStreamData;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class ReactiveStreamExercise5 {

  public static void main(String[] args) throws IOException {

    // Use ReactiveSources.intNumberMono() and ReactiveSources.playerMono()

    // Subscribe to a flux using the error and completion hooks
    ReactiveStreamData.intNumbersFlux()
        .subscribe(
            System.out::println,
            Throwable::printStackTrace,
            () -> System.out.println("Complete signal"));

    // Subscribe to a flux using an implementation of BaseSubscriber
    BaseSubscriber<Integer> baseSubscriber =
        new BaseSubscriber<>() {

          @Override
          protected void hookOnNext(Integer value) {
            System.out.println(value);
          }

          @Override
          protected void hookOnError(Throwable throwable) {
            System.out.println("Exception occurred: " + throwable);
          }

          @Override
          protected void hookOnComplete() {
            System.out.println("Complete signal");
          }
        };

    ReactiveStreamData.intNumbersFlux().subscribe(baseSubscriber);

    System.out.println("Press a key to end");
    System.in.read();
  }
}
