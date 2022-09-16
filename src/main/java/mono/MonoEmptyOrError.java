package mono;

import mono.utils.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(1)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("UserId is invalid"));
        }
    }
}
