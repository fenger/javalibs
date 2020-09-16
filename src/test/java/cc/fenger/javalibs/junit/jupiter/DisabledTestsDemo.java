package cc.fenger.javalibs.junit.jupiter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTestsDemo {

    @Disabled
    @Test
    void testWillBeSkipped() {
        System.out.println("will be skipped");
    }

    @Test
    void testWillBeExecuted() {
        System.out.println("will be executed");
    }

}
