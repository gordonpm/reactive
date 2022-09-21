package mono;

import utils.Util;
import reactor.core.publisher.Mono;

public class MonoSubscribeCompleteUsingUtil {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("bicycle");
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
