package flux;

import utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxFromStreamSupplier {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Flux<Integer> integerFlux = Flux.fromStream(() -> list.stream()); // supplier
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
