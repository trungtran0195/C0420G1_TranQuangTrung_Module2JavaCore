package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class TestResizeableRectangle {
    public static void main(String []args){
        Rectangle rectangle1 = new Rectangle(4,5);
        System.out.println(rectangle1);

        Resizeable rectangle2 = new ResizeRectangle(6,8);
        System.out.println(rectangle2);
        rectangle2.resize(50);
        System.out.println("after changed got : " +rectangle2);

        Rectangle rectangle3 = (Rectangle)rectangle2;
        System.out.println("the changed rectangle area = " + rectangle3.getArea());
        System.out.println("the changed rectangle perimeter = " + rectangle3.getPerimeter());
    }
}
