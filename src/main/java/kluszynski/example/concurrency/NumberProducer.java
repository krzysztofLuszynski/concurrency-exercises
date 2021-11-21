package kluszynski.example.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NumberProducer {
    private final List<Long> numbers = new ArrayList<>();
    private final Long startNumber;
    private final Long step;
    private final Long itemNumber;
    private volatile boolean finished = false;

    public NumberProducer(Long startNumber, Long step, Long itemNumber) {
        this.startNumber = startNumber;
        this.step = step;
        this.itemNumber = itemNumber;
    }

    public void generate() {
        log.debug("Generating numbers...");

        for (long number = startNumber ; number <= itemNumber; number += step) {
            log.debug("Next generated number is: {}", number);
            numbers.add(number);
        }

        finished = true;
        log.debug("Generated numbers successfully");
    }

    public boolean isFinished() {
        return finished;
    }

    public List<Long> getNumbers() {
        return numbers;
    }
}
