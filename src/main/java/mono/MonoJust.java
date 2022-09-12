package mono;

import reactor.core.publisher.Mono;

public class MonoJust {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
