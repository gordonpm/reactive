package flux;

import reactor.core.publisher.Flux;
import utils.Util;

import java.time.Duration;

public class FluxDelay {

    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.x", "10"); // change buffer size
        Flux.range(1, 100) // default buffer size = 32
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(600);
    }
}
