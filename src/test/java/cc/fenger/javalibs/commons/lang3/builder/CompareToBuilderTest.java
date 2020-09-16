package cc.fenger.javalibs.commons.lang3.builder;

import static org.junit.jupiter.api.Assertions.*;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareToBuilderTest {

    private User u1;
    private User u2;

    @BeforeEach
    void setup() {
        u1 = User.builder().username("Jack").age(22).build();
        u2 = User.builder().username("Rose").age(20).build();
    }

    /**
     * 通过反射比较两个对象
     */
    @Test
    void testReflectionCompare() {
        int result = CompareToBuilder.reflectionCompare(u1, u2, "username");
        System.out.println(result);
        assertTrue(result > 0);

        result = CompareToBuilder.reflectionCompare(u2, u1, "username");
        System.out.println(result);
        assertTrue(result < 0);
    }

    @Test
    void testAppend() {
        CompareToBuilder ctb1 = new CompareToBuilder();
        assertTrue(ctb1.append(1, 2).build() < 0);

        CompareToBuilder ctb2 = new CompareToBuilder();
        assertTrue(ctb2.append(3.0, 2.0).build() > 0);

        CompareToBuilder ctb3 = new CompareToBuilder();
        assertEquals(0, (int) ctb3.append(true, true).build());
    }

}

@Data
@Builder
class User {
    private String username;
    private Integer age;
}
