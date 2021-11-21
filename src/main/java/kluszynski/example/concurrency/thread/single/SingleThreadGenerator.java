package kluszynski.example.concurrency.thread.single;

import kluszynski.example.concurrency.NumberGenerator;
import kluszynski.example.concurrency.NumberProvider;

import java.util.List;

public class SingleThreadGenerator implements NumberGenerator {
    private final NumberProvider numberProvider;

    public SingleThreadGenerator(NumberProvider numberProvider) {
        this.numberProvider = numberProvider;
    }

    @Override
    public List<Long> generate() {
        Thread thread = new Thread(numberProvider::generate);
        thread.start();

        while(true) {
            if (numberProvider.isFinished()) {
                break;
            }
        }

        return numberProvider.getNumbers();
    }
}
