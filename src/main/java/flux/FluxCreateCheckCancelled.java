package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxCreateCheckCancelled {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting : " + country);
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("Iceland") && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
