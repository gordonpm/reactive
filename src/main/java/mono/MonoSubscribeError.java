package mono;

import reactor.core.publisher.Mono;

public class MonoSubscribeError {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("bicycle")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println("ERROR: " + err.getMessage()),
                () -> System.out.println("Completed")
        );

    }
}
