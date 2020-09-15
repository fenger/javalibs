package cc.fenger.javalibs.junit.jupiter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JunitJupiterTest {

    Calculator cal = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(2, cal.add(1, 1));
    }

}

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

}
