package flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Util;

public class FluxError {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                // .onErrorReturn(-1)   // default value on error
                // .onErrorResume(e -> fallback()) // call fallback method on error
                .onErrorContinue((e, o) -> {   // continue on error
                    System.out.println(e.getMessage());
                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
