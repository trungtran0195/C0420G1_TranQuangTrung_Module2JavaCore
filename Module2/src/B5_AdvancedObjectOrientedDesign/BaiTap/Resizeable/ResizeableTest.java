package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class ResizeableTest{
    public static void main(String[] args) {
        Shape shapeArray[] = new Shape[3];
        ResizeCircle circle2 = new ResizeCircle(4);
        shapeArray[0] = circle2;
        ResizeSquare square2 = new ResizeSquare(4);
        shapeArray[1] = square2;
        ResizeRectangle rectangle2 = new ResizeRectangle(5, 7);
        shapeArray[2] = rectangle2;
        for (int i = 0; i < shapeArray.length; i++) {
            System.out.println(shapeArray[i]);
            shapeArray[i].resize(getRandom());
            System.out.println("resize :" +getRandom()+"%"  + " "+ "after change" +shapeArray[i]);
        }
    }

    public static int getRandom() {
        return (int) (Math.random() * 50 + 1);
    }
}