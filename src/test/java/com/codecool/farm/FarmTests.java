package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Cattle;
import com.codecool.farm.animal.Pig;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FarmTests {
    private Animal pig;
    private Animal cattle;
    private Butcher butcher;
    private Farm farm;

    @BeforeEach
    void setup() {
        pig = new Pig();
        cattle = new Cattle();
        butcher = new Butcher();
        List<Animal> animals = new ArrayList<>() {{
            add(pig);
            add(cattle);
        }};
        farm = new Farm(animals);
    }

    @Test
    @Order(1)
    void getSizeReturnsZeroByDefaultForPig() {
        assertEquals(0, pig.getSize());
    }

    @Test
    @Order(2)
    void getSizeReturnsZeroByDefaultForCattle() {
        assertEquals(0, cattle.getSize());
    }


    @Test
    @Order(3)
    void feedPigIncreasesSizeByOne() {
        pig.feed();
        assertEquals(1, pig.getSize());
    }

    @Test
    @Order(4)
    void feedPigIncreasesSizeByOneForEachFeeding() {
        pig.feed();
        assertEquals(1, pig.getSize());
        pig.feed();
        assertEquals(2, pig.getSize());
        pig.feed();
        assertEquals(3, pig.getSize());
    }

    @Test
    @Order(5)
    void feedCattleIncreasesSizeBy2() {
        cattle.feed();
        assertEquals(2, cattle.getSize());
    }

    @Test
    @Order(6)
    void feedCattleIncreasesSizeBy2ForEachFeeding() {
        cattle.feed();
        assertEquals(2, cattle.getSize());
        cattle.feed();
        assertEquals(4, cattle.getSize());
        cattle.feed();
        assertEquals(6, cattle.getSize());
    }

    @Test
    @Order(7)
    void canButcherReturnsFalseIfAnimalIsTooSmall() {
        for (int i = 0; i < 3; i++) {
            pig.feed();
        }
        assertFalse(butcher.canButcher(pig));
    }

    @Test
    @Order(8)
    void canButcherReturnsTrueIfAnimalIsBigEnough() {
        for (int i = 0; i < 3; i++) {
            pig.feed();
        }
        assertFalse(butcher.canButcher(pig));
    }

    @Test
    @Order(9)
    void feedAnimalsWorks() {
        farm.feedAnimals();
        List<Animal> animals = farm.getAnimals();
        assertEquals(1, animals.get(0).getSize());
        assertEquals(2, animals.get(1).getSize());
    }

    @Test
    @Order(10)
    void butcherAnimalsDontButcherSmallAnimals() {
        farm.feedAnimals();
        farm.butcher(butcher);
        assertTrue(farm.getAnimals().contains(pig));
        assertTrue(farm.getAnimals().contains(cattle));
    }

    @Test
    @Order(11)
    void butcherAnimalsWorks() {
        for (int i = 0; i < 3; i++) {
            farm.feedAnimals();
        }
        farm.butcher(butcher);
        assertTrue(farm.getAnimals().contains(pig));
        assertFalse(farm.getAnimals().contains(cattle));

        farm.feedAnimals();
        farm.feedAnimals();
        farm.butcher(butcher);
        assertFalse(farm.getAnimals().contains(pig));
        assertFalse(farm.getAnimals().contains(cattle));
    }


    @Test
    @Order(12)
    void testFarmGetAnimalsReturnsEmpty() {
        Farm emptyFarm = new Farm(Collections.emptyList());
        List<Animal> animals = emptyFarm.getAnimals();
        assertEquals(0, animals.size());
    }

    @Test
    @Order(13)
    void testFarmGetAnimals() {
        assertEquals(2, farm.getAnimals().size());
    }

    @Test
    @Order(14)
    void isEmptyWorks() {
        Farm emptyFarm = new Farm(new ArrayList<>());
        assertTrue(emptyFarm.isEmpty());
        assertFalse(farm.isEmpty());
    }

    @Test
    @Order(15)
    void getStatusWorksForEmptyFarm() {
        Farm emptyFarm = new Farm(new ArrayList<>());
        List<String> status = emptyFarm.getStatus();
        assertEquals(0, status.size());
    }

    @Test
    @Order(16)
    void getStatusWorks() {
        for (int i = 0; i < 3; i++) {
            farm.feedAnimals();
        }
        List<String> expected = new ArrayList<>() {{
            add("There is a 3 sized pig in the farm.");
            add("There is a 6 sized cattle in the farm.");
        }};
        List<String> statuses = farm.getStatus();
        assertEquals(expected, statuses);
    }
}
