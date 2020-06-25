package B5_AdvancedObjectOrientedDesign.BaiTap.Colorable;

import B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable.*;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapeArray1 = new Shape[3];
        Circle circle1 = new Circle(4);
        shapeArray1[0] = circle1;
        Square square2 = new Square(4);

        shapeArray1[1] = square2;
        Rectangle rectangle3 = new Rectangle(5, 7);
        shapeArray1[2] = rectangle3;
        for (int i = 0; i < shapeArray1.length; i++){
            System.out.println(shapeArray1[i]);
                if (shapeArray1[i] instanceof Colorable){
                    Colorable colorable = (Square)shapeArray1[i];
                    colorable.howToColor();
                }
        }
    }
}
