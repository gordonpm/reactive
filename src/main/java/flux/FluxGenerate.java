package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    System.out.println("Emitting: " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("Iceland")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
