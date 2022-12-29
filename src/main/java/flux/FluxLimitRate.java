package flux;

import reactor.core.publisher.Flux;
import utils.Util;

public class FluxLimitRate {

    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 50) //  default lowTide = 75, if lowTide = 100 then 75% will be drained before next batch is requested
                                                    // if lowTide = 0, then 100% will be drained before next batch is requested
                .subscribe(Util.subscriber());
    }
}
