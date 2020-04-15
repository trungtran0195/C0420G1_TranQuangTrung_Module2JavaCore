package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class TestResizableCircle {
    public static void main(String []args){
        Circle circle = new Circle(3.5);
        System.out.println(circle);

        Resizeable circle2 = new ResizeCircle(5.0);
        System.out.println(circle2);
        circle2.resize(20);
        System.out.println(circle2);

        Circle circle3 = (Circle) circle2;
        System.out.println(circle3);
        System.out.println(circle3.getArea());
        System.out.println(circle3.getPerimeter());
    }
}
