package mono;

import utils.Util;
import reactor.core.publisher.Mono;

public class MonoFromSupplier {

    public static void main(String[] args) {
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().firstName();
    }
}
