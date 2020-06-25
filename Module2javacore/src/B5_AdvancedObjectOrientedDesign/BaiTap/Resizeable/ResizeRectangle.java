package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class ResizeRectangle extends Rectangle {
    public ResizeRectangle(double width, double length) {
        super(width, length);
    }

    @Override
    public void resize(double percent) {
        width = width*(percent / 100);
        length += length*(percent / 100);
    }
}
