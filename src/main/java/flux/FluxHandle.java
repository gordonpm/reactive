package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxHandle {

    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer == 7) {
                        synchronousSink.complete();
                    } else {
                        synchronousSink.next(integer);
                    }
                })
                .subscribe(Util.subscriber());
    }
}
