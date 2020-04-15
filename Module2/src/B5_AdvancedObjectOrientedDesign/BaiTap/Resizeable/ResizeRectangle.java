package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class ResizeRectangle extends Rectangle implements Resizeable {
    public ResizeRectangle(double width, double length){
        super(width , length);
    }

    @Override
    public void resize(double percent){
        width *= percent/100;
        length *= percent/100;
    }
}
