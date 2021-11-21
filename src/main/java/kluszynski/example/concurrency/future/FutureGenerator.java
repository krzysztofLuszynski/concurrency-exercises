package kluszynski.example.concurrency.future;

import kluszynski.example.concurrency.NumberGenerator;
import kluszynski.example.concurrency.NumberProvider;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class FutureGenerator implements NumberGenerator {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final NumberProvider numberProvider;

    public FutureGenerator(NumberProvider numberProvider) {
        this.numberProvider = numberProvider;
    }

    @Override
    public List<Long> generate() {
        try {
            Future<List<Long>> future = calculate(numberProvider);

            while (!future.isDone()) {
                log.debug("Calculating ...");
            }

            return future.get();
        } catch (InterruptedException | ExecutionException exception) {
            throw new RuntimeException("Exception during generation", exception);
        }
    }

    private Future<List<Long>> calculate(NumberProvider numberProvider) {
        return executorService.submit(() -> {
            numberProvider.generate();
            return numberProvider.getNumbers();
        });
    }
}
