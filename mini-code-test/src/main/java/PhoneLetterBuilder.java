import vo.PhoneLetterMap;

import java.util.Map;

public class PhoneLetterBuilder {
    public static PhoneLetterMap getLetterMap() {
        PhoneLetterMap letterMap = new PhoneLetterMap();
        Map<String, String[]> phoneKey = letterMap.getPhoneKey();
        phoneKey.put("2",new String[]{"a","b","c"});
        phoneKey.put("3",new String[]{"d","e","f"});
        phoneKey.put("4",new String[]{"g","h","i"});
        phoneKey.put("5",new String[]{"j","k","l"});
        phoneKey.put("6",new String[]{"m","n","o"});
        phoneKey.put("7",new String[]{"p","q","r","s"});
        phoneKey.put("8",new String[]{"t","u","v"});
        phoneKey.put("9",new String[]{"w","x","y","z"});
        return letterMap;
    }
}
