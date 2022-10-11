package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(
                        () -> 1,
                        (counter, sink) -> {
                            String country = Util.faker().country().name();
                            sink.next(country);
                            if (counter == 10 || country.equalsIgnoreCase("Iceland"))
                                sink.complete();
                            return counter + 1;
                        }
                )
                .subscribe(Util.subscriber());
    }
}
