package cc.fenger.javalibs.commons_lang3;

import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.Test;

public class ArchUtilsTest {

    @Test
    public void testGetProcessor() {
        Processor processor = ArchUtils.getProcessor();
        System.out.println(processor.getArch().getLabel());
        System.out.println(processor.getType().name());
    }

}
