package org.example.data;

import org.example.model.Players;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class ReactiveStreamData {
    public static Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("An error happened in the flux");
                    return e;
                });
    }

    public static Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<Players> playerFlux() {
        return Flux.just(
                new Players(1, "Virat Kohli", "King Kohli"),
                new Players(2, "MS Dhoni", "Captain Cool"),
                new Players(2, "Sachin Tendulkar", "Master Blaster"),
                new Players(4, "Rohit Sharma", "Hitman"),
                new Players(5, "Ravindra Jadeja", "Sir Jadeja"),
                new Players(6, "Jasprit Bumrah", "Boom Boom")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<Players> playerMono() {
        return Mono.just(
                new Players(1, "Virat Kohli", "King Kohli")
        ).delayElement(Duration.ofSeconds(1));

    }

    public static Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public static Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }
}
