package flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import utils.Util;

public class FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("data");
        Flux.from(mono)
                .log()
                .subscribe(Util.onNext());
    }
}
