package B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible;

import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.animal.Animal;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.animal.Chicken;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.animal.Tiger;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.edible.Edible;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.fruit.Fruit;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.fruit.Apple;
import B5_AdvancedObjectOrientedDesign.ThucHanh.AnimalAndInterfaceEdible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        //thuộc tính duy nhất của mảng là length , chỉ có thể truy cập vào từng phần tử trong mảng .
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Edible) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
