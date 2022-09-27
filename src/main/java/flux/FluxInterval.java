package flux;

import reactor.core.publisher.Flux;
import utils.Util;

import java.time.Duration;

public class FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .log()
                .subscribe(Util.onNext());
        Util.sleepSeconds(10);
    }
}
