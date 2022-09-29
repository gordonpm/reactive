package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxToMono {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next()
                .log()
                .subscribe(Util.onNext());

    }
}
