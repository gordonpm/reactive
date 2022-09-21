package mono;

import utils.Util;
import reactor.core.publisher.Mono;

public class MonoSubscribeErrorUsingUtil {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("bicycle")
                .map(String::length)
                .map(l -> l / 0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
