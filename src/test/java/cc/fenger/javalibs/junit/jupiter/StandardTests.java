package cc.fenger.javalibs.junit.jupiter;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

public class StandardTests {

    @BeforeAll
    static void initAll() {
        System.out.println("init all");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @Test
    void succeedingTest() {
        System.out.println("success");
    }

    @Test
    void failingTest() {
        fail("a failing test.");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        System.out.println("skipped");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tear down");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("tear down all");
    }

}
