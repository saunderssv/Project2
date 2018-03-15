package beans;

import org.junit.Test;
import org.meanbean.lang.EquivalentFactory;
import org.meanbean.test.BeanTester;
import org.meanbean.test.HashCodeMethodTester;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getterAndSetterCorrectness() throws Exception {
        new BeanTester().testBean(Animal.class);
    }

    @Test
    public void equalsAnimalTest() throws Exception {
        HashCodeMethodTester tester = new HashCodeMethodTester();
        tester.testHashCodeMethod(new AnimalFactory());

    }

}


    class AnimalFactory implements EquivalentFactory<Animal> {

        @Override
        public Animal create() {
            Animal animal = new Animal();
            animal.setName("Spencer");
            animal.setSex('F');
            animal.setWeight(2135.0);
            animal.setPersonality("exuberant elephant");
            animal.setInfo("personal information about spencer the elephant");
            Location loc = new Location("elephant", 2.1, 3.1);
            animal.setArea(loc);
            Genus gen = new Genus("elephantae");
            Species spe = new Species("elephantus");
            animal.setGenus(gen);
            animal.setSpecies(spe);
            return animal;
        }
    }
