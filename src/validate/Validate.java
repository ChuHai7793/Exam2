package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean validatePositiveDouble(double value) {
        return value >= 0;
    }

    public static boolean validateNotEmptyString(String value) {
        return value != null && !value.isEmpty();
    }

    public static boolean validateDate(String date) {
        // Regex để kiểm tra định dạng dd/mm/yyyy
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";

        // Tạo Pattern từ regex
        Pattern pattern = Pattern.compile(regex);

        // Kiểm tra chuỗi date có khớp với regex hay không
        Matcher matcher = pattern.matcher(date);

        if (!matcher.matches()) {
            return false;  // Nếu không đúng định dạng
        } else {
            return true;}
    }
}
