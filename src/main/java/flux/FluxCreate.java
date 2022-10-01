package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 10; i++) {
                        fluxSink.next(Util.faker().country().name());
                    }
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
