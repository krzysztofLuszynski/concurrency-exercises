package kluszynski.example.concurrency.future;

import kluszynski.example.concurrency.NumberGenerator;
import kluszynski.example.concurrency.NumberProvider;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FutureGeneratorTest {
    @Test
    void test() {
        NumberProvider numberProvider = new NumberProvider(1L, 1L, 9L);
        NumberGenerator numberGenerator = new FutureGenerator(numberProvider);

        List<Long> numbers = numberGenerator.generate();

        assertThat(numbers).containsExactly(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
    }
}
