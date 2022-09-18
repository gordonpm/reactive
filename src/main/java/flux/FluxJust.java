package flux;

import mono.utils.Util;
import reactor.core.publisher.Flux;

public class FluxJust {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Flux<Object> flux2 = Flux.just(1, 2.5, "a", Util.faker().name().fullName());
        flux2.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
