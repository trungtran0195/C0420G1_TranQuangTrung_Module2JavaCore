package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class ResizeCircle extends Circle implements Resizeable {
    public ResizeCircle(double radius){
        super(radius);
    }

    @Override
    public void resize(double percent) {
        radius *= percent/100.0;
    }
}
