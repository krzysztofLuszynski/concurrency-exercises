package kluszynski.example.concurrency.thread.single;

import kluszynski.example.concurrency.NumberProducer;

import java.util.List;

public class SingleThreadGenerator {
    private final NumberProducer numberProducer;

    public SingleThreadGenerator(NumberProducer numberProducer) {
        this.numberProducer = numberProducer;
    }

    List<Long> generate() {
        Thread thread = new Thread(numberProducer::generate);
        thread.start();

        while(true) {
            if (numberProducer.isFinished()) {
                break;
            }
        }

        return numberProducer.getNumbers();
    }
}
