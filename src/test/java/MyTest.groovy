import helpers.TestDataReader
import org.junit.jupiter.api.*
import org.junit.platform.launcher.listeners.LoggingListener

import java.util.logging.ConsoleHandler
import java.util.logging.Level
import java.util.logging.Logger

class MyTest {

    @BeforeAll
    static void init() {
        def logger = Logger.getLogger(LoggingListener.name)
        logger.level = Level.FINE
        logger.addHandler(new ConsoleHandler(level: Level.FINE))
        TestDataReader reader = new TestDataReader()
    }

    @Test
    void returnsTrue(){
        assert true
    }

    @Test returnsFalse(){
        assert false
    }

    /*
    @Test
    void streamSum() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, () -> "Sum should be greater than 5")
    }

    @RepeatedTest(value=2, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void streamSumRepeated() {
        assert Stream.of(1, 2, 3).mapToInt(i -> i).sum() == 6
    }

    private boolean isPalindrome(s) { s == s.reverse()  }

    @ParameterizedTest
    @ValueSource(strings = [ "racecar", "radar", "able was I ere I saw elba" ])
    void palindromes(String candidate) {
        assert isPalindrome(candidate)
    }

    @TestFactory
    def dynamicTestCollection() {[
            dynamicTest("Add test") { -> assert 1 + 1 == 2 },
            dynamicTest("Multiply Test", () -> { assert 2 * 3 == 6 })
    ]}

     */
}
