package kluszynski.example.concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberProviderTest {
    @Test
    void test() {
        NumberProvider numberProvider = new NumberProvider(1L, 1L, 9L);

        numberProvider.generate();

        assertThat(numberProvider.isFinished()).isTrue();
        assertThat(numberProvider.getNumbers()).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
    }
}
