package cc.fenger.javalibs.junit.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
public class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
        System.out.println("display name containing spaces");
    }

    @Test
    @DisplayName("\uD83D\uDE31")
    void testWithDisplayNameContainingEmoji() {
        System.out.println("display name containing emoji");
    }

}
