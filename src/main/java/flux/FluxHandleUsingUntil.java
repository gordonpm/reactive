package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxHandleUsingUntil {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.equalsIgnoreCase("Iceland"))
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());
    }

}
