package hotcoldpublishers;

import reactor.core.publisher.Flux;
import utils.Util;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublisherCache {

    public static void main(String[] args) {
        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache(); // no arg means limit is integer.max

        Util.sleepSeconds(2);
        movieStream.subscribe(Util.subscriber("Sam"));
        Util.sleepSeconds(10);
        System.out.println("Mike is about to join");
        movieStream.subscribe(Util.subscriber("Mike"));

        Util.sleepSeconds(30);

    }

    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
