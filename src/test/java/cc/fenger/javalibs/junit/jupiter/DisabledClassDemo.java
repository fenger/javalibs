package cc.fenger.javalibs.junit.jupiter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
        System.out.println("will be skipped");
    }

}
