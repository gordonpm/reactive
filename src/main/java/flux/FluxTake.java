package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxTake {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());
    }
}
