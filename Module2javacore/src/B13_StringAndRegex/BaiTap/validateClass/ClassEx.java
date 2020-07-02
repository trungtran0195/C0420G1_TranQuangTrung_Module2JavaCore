package B13_StringAndRegex.BaiTap.validateClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassEx {
    private static final String CLASS_REGEX = "(^[CPA][\\d]{4}[GHIKLM]$)";

    public ClassEx(){
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
