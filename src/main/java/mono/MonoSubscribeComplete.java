package mono;

import reactor.core.publisher.Mono;

public class MonoSubscribeComplete {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("bicycle");
        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
