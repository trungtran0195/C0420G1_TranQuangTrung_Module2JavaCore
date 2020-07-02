package B13_StringAndRegex.BaiTap.validateClass;

public class Test {
    private static ClassEx classEx;

    public static final String[] validClass = new String[]{"C0318G","P0318K"};

    public static final String[] invalidClass = new String[]{"M0318G","P0323A"};

    public static void main(String[] args) {
        classEx = new ClassEx();
        for (String studentclass : validClass){
            boolean isvalid = classEx.validate(studentclass);
            System.out.println("Class : " +studentclass+" is valid:" +isvalid);
        }
        for (String studentclass : invalidClass){
            boolean isvalid = classEx.validate(studentclass);
            System.out.println("Class : " +studentclass+" is valid:" +isvalid);
        }
    }
}
