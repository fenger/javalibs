package cc.fenger.javalibs.junit.jupiter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
@Tag("model")
public class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
        System.out.println("tax calculation");
    }

}
