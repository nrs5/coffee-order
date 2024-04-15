package edu.iu.habahram.coffeeorder.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeverageAndCondimentTest {

    @Test
    public void testDarkRoast() {
        Beverage darkRoast = new DarkRoast();
        assertEquals("Dark roast", darkRoast.getDescription());
        assertEquals(1.99, darkRoast.cost(), 0.01);
    }

    @Test
    public void testDecaf(){
        Beverage decaf = new Decaf();
        assertEquals("Decaf", decaf.getDescription());
        assertEquals(1.28, decaf.cost(), 0.01);
    }

    @Test
    public void testEspresso(){
        Beverage espresso = new Espresso();
        assertEquals("Espresso", espresso.getDescription());
        assertEquals(1.34, espresso.cost(), 0.01);
    }

    @Test
    public void testHouseBlend(){
        Beverage houseBlend = new HouseBlend();
        assertEquals("House blend", houseBlend.getDescription());
        assertEquals(1.64, houseBlend.cost(), 0.01);
    }

    @Test
    public void testEspressoWithMocha(){
        Beverage espressoWithMocha = new Mocha(new Espresso());
        assertEquals("Espresso, Mocha", espressoWithMocha.getDescription());
        assertEquals(1.64, espressoWithMocha.cost(), 0.01);
    }

    @Test
    public void testHouseBlendWithSoyAndWhip(){
        Beverage houseBlendWithSoyAndWhip = new Soy(new Whip(new HouseBlend()));
        assertEquals("House blend, Whip, Soy", houseBlendWithSoyAndWhip.getDescription());
        assertEquals(2.17, houseBlendWithSoyAndWhip.cost(), 0.01);
    }

    @Test
    public void testDecafWithMochaAndMilk(){
        Beverage decafWithMochaAndMilk = new Mocha(new Milk(new Decaf()));
        assertEquals("Decaf, Milk, Mocha", decafWithMochaAndMilk.getDescription());
        assertEquals(1.98, decafWithMochaAndMilk.cost(), 0.01);
    }

    @Test
    public void darkRoastWithDoubleWhip(){
        Beverage darkRoastWithDoubleWhip = new Whip(new Whip(new DarkRoast()));
        assertEquals("Dark roast, Whip, Whip", darkRoastWithDoubleWhip.getDescription());
        assertEquals(2.49, darkRoastWithDoubleWhip.cost(), 0.01);
    }

    @Test
    public void houseBlendWithWhipAndMochaAndSoy(){
        Beverage houseBlendWithWhipAndMochaAndSoy = new Whip(new Mocha(new Soy(new HouseBlend())));
        assertEquals("House blend, Soy, Mocha, Whip", houseBlendWithWhipAndMochaAndSoy.getDescription());
        assertEquals(2.47, houseBlendWithWhipAndMochaAndSoy.cost(), 0.01);
    }

    @Test
    public void espressoWithDoubleWhipAndMocha(){
        Beverage espressoWithDoubleWhipAndSoy = new Soy(new Whip(new Whip(new Espresso())));
        assertEquals("Espresso, Whip, Whip, Soy", espressoWithDoubleWhipAndSoy.getDescription());
        assertEquals(2.11, espressoWithDoubleWhipAndSoy.cost(), 0.01);
    }

    @Test
    public void testDecafWithMochaAndMilkAndSoyAndWhip(){
        Beverage decafWithMochaAndMilkAndSoyAndWhip = new Whip(new Soy(new Milk(new Mocha(new Decaf()))));
        assertEquals("Decaf, Mocha, Milk, Soy, Whip", decafWithMochaAndMilkAndSoyAndWhip.getDescription());
        assertEquals(2.5, decafWithMochaAndMilkAndSoyAndWhip.cost(), 0.01);
    }

    @Test
    public void testDarkRoastWithMochaAndMilkAndSoyAndWhip(){
        Beverage darkRoastWithMochaAndMilkAndSoyAndWhip = new Whip(new Soy(new Milk(new Mocha(new DarkRoast()))));
        assertEquals("Dark roast, Mocha, Milk, Soy, Whip", darkRoastWithMochaAndMilkAndSoyAndWhip.getDescription());
        assertEquals(3.21, darkRoastWithMochaAndMilkAndSoyAndWhip.cost(), 0.01);
    }

    @Test
    public void testHouseBlendWithQuadSoy() {
        Beverage houseBlendWithQuadSoy = new Soy(new Soy(new Soy(new Soy(new HouseBlend()))));
        assertEquals("House blend, Soy, Soy, Soy, Soy", houseBlendWithQuadSoy.getDescription());
        assertEquals(2.73, houseBlendWithQuadSoy.cost(), 0.01);
    }

    @Test
    public void testDecafWithQuadWhip() {
        Beverage decafWithQuadWhip = new Whip(new Whip(new Whip(new Whip(new Decaf()))));
        assertEquals("Decaf, Whip, Whip, Whip, Whip", decafWithQuadWhip.getDescription());
        assertEquals(2.28, decafWithQuadWhip.cost(), 0.01);
    }

    @Test
    public void testEspressoWithQuadMilk() {
        Beverage espressoWithQuadMilk = new Milk(new Milk(new Milk(new Milk(new Espresso()))));
        assertEquals("Espresso, Milk, Milk, Milk, Milk", espressoWithQuadMilk.getDescription());
        assertEquals(2.94, espressoWithQuadMilk.cost(), 0.01);
    }

    @Test
    public void testDarkRoastWithQuadMocha() {
        Beverage darkRoastWithQuadMocha = new Mocha(new Mocha(new Mocha(new Mocha(new DarkRoast()))));
        assertEquals("Dark roast, Mocha, Mocha, Mocha, Mocha", darkRoastWithQuadMocha.getDescription());
        assertEquals(3.19, darkRoastWithQuadMocha.cost(), 0.01);
    }






}
