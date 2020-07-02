package B13_StringAndRegex.BaiTap.validatePhoneNumber;

public class Test {
    private static PhoneNumberEx phoneNumberEx;

    public static final String[] validPhoneNum = new String[]{"840978489648","000978489648"};
    public static final String[] invalidPhoneNum = new String[]{"a822222222","841123123123"};

    public static void main(String[] args) {
        phoneNumberEx = new PhoneNumberEx();
        for (String phonenumber : validPhoneNum){
            boolean isvalid = phoneNumberEx.validate(phonenumber);
            System.out.println("Phone number: " +phonenumber+ " is valid: "+isvalid );
        }
        for (String phonenumber : invalidPhoneNum){
            boolean isvalid = phoneNumberEx.validate(phonenumber);
            System.out.println("Phone number: " +phonenumber+ " is valid: "+isvalid );
        }
    }
}
