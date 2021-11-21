package kluszynski.example.concurrency.thread.single;

import kluszynski.example.concurrency.NumberProducer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleThreadGeneratorTest {
    @Test
    void test() {
        NumberProducer numberProducer = new NumberProducer(1L, 1L, 9L);
        SingleThreadGenerator singleThreadGenerator = new SingleThreadGenerator(numberProducer);

        List<Long> numbers = singleThreadGenerator.generate();

        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
    }
}
