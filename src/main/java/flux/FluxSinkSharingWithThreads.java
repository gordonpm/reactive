package flux;

import reactor.core.publisher.Flux;
import utils.NameProducer;
import utils.Util;

public class FluxSinkSharingWithThreads {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(2);
    }
}
