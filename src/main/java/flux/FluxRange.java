package flux;

import utils.Util;
import reactor.core.publisher.Flux;

public class FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }
}
