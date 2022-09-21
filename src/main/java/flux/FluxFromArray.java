package flux;

import utils.Util;
import reactor.core.publisher.Flux;

public class FluxFromArray {
    public static void main(String[] args) {
        Integer[] array = {1,4,7,9};
        Flux.fromArray(array)
                .subscribe(Util.onNext()
                );
    }
}
