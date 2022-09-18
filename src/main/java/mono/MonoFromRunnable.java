package mono;

import mono.utils.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is complete. Sending emails...");
                        }
                );
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            System.out.println("Starting time consuming process...");
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
