package flux;

import mono.utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class FluxFromList {
    public static void main(String[] args) {
        List<String> strings = List.of("a", "b", "c");
        Flux.fromIterable(strings)
                .subscribe(Util.onNext()
                );
    }
}
