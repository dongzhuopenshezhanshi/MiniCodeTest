package vo;


import java.util.HashMap;
import java.util.Map;

public class PhoneLetterMap {
    private Map<String, String[]> phoneKey = new HashMap<>();

    private final String[] emptyKey = {"0","1"};

    public Map<String, String[]> getPhoneKey() {
        return phoneKey;
    }

    public String getEmptyStr() {
        return "";
    }

    public String[] getEmptyKey() {
        return emptyKey;
    }
}
