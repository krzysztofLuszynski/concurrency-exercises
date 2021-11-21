package kluszynski.example.concurrency;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberProducerTest {
    @Test
    void test() {
        NumberProducer numberProducer = new NumberProducer(1L, 1L, 9L);

        numberProducer.generate();
        List<Long> numbers = numberProducer.getNumbers();

        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
    }
}
