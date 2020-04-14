package B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.animal;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.edible.Edible;

public class Chicken extends Animal {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}