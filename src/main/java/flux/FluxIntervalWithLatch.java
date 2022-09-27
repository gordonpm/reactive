package flux;

import reactor.core.publisher.Flux;
import utils.Util;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;

public class FluxIntervalWithLatch {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(1);
        Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .log()
                .doFinally(
                        s -> cdl.countDown()
                )
                .subscribe(Util.onNext());
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
