package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class TestResizeableSquare {
    public static void main(String []args){
        Square square1 = new Square(4);
        System.out.println(square1);

        Resizeable square2 = new ResizeSquare(6);
        System.out.println(square2);
        square2.resize(50);
        System.out.println("after changed got : " +square2);

        Square square3 = (Square)square2;
        System.out.println("the changed square area = " + square3.getArea());
        System.out.println("the changed square perimeter = " + square3.getPerimeter());
    }
}
