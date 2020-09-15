package cc.fenger.javalibs.junit.jupiter;

import static org.junit.jupiter.api.Assertions.*;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class AssertionsDemo {

    private Person p = null;

    @BeforeEach
    void setUp() {
        p = Person.builder().firstName("fenger").lastName("f").build();
    }

    @Test
    void standardAssertions() {
        assertEquals(2, 2);
        assertEquals(4, 4, "The optional assertion message is now the last parameter.");
        assertTrue(2 == 2, () -> "Assertion messages can be lazily evaluated -- " +
                "to avoid constructing complex messages unnecessarily.");
    }

    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("fenger", p.getFirstName()),
                () -> assertEquals("f", p.getLastName())
        );
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = p.getFirstName();
                    assertNotNull(firstName);

                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("f")),
                            () -> assertTrue(firstName.endsWith("r"))
                    );
                },
                () -> {
                    String lastName = p.getLastName();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("f")),
                            () -> assertTrue(lastName.endsWith("f")));
                });
    }

    @Test
    void exceptionTesting() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofSeconds(2), () -> {
            Thread.sleep(1000);
        });
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(Duration.ofSeconds(3), () -> {
            Thread.sleep(5000);
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String actualResult = assertTimeout(Duration.ofSeconds(3), () -> {
            return "a result";
        });

        assertEquals("a result", actualResult);
    }

    @Test
    void timeoutNotExceededWithMethod() {
        String actualGreeting = assertTimeout(Duration.ofSeconds(3), AssertionsDemo::greeting);
        assertEquals("hello world", actualGreeting);
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {
        assertTimeoutPreemptively(Duration.ofSeconds(3000), () -> {
            Thread.sleep(1000);
        });
    }

    private static String greeting() {
        return "hello world";
    }
}


@Data
@Builder
class Person {
    private String firstName;
    private String lastName;
}
