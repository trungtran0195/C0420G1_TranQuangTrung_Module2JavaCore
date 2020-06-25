package B5_AdvancedObjectOrientedDesign.BaiTap.Resizeable;

public class ResizeSquare extends Square {
    public ResizeSquare(double size) {
        super(size);
    }

    @Override
    public void resize(double percent) {
        width += width*(percent / 100);
        length = width;
    }
}
