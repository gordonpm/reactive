package flux;

import reactor.core.publisher.Flux;
import utils.NameProducer;
import utils.Util;

public class FluxCreateWithProducer {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(Util.subscriber());

        nameProducer.produce();
    }
}
