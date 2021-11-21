package kluszynski.example.concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberProducerTest {
    @Test
    void test() {
        NumberProducer numberProducer = new NumberProducer(1L, 1L, 9L);

        numberProducer.generate();

        assertThat(numberProducer.isFinished()).isTrue();
        assertThat(numberProducer.getNumbers()).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
    }
}
