package beans;

import org.junit.Test;
import org.meanbean.test.BeanTester;

import static org.junit.Assert.*;

public class SpeciesTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Species.class);
    }

}