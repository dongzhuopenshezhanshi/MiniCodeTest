import vo.PhoneLetterMap;

import java.util.Map;

public class PhoneLetterTranslate {
    public static void main(String[] args) {
        System.out.println(getHelloWorld());
    }

    public static String getHelloWorld() {
        return "Hello World";
    }

    public static String getAnswerOne(int[] inputArr, PhoneLetterMap phoneLetterMap) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int in : inputArr) {
            stringBuffer.append(in);
        }
        String inputStr = stringBuffer.toString();
        return translateNumberToLetter(phoneLetterMap, inputStr);

    }

    private static String translateNumberToLetter(PhoneLetterMap phoneLetterMap, String inputStr) {
        for (String emptyKey : phoneLetterMap.getEmptyKey()) {
            inputStr = inputStr.replace(emptyKey, phoneLetterMap.getEmptyStr());
        }
        String inputStrCopy = inputStr;
        int strLength = inputStr.length();
        if (strLength == 0) {
            return "";
        }
        Integer allStrNums = getStringNum(phoneLetterMap, inputStr, strLength);
        if (allStrNums == null) return "param error";
        StringBuffer[] outStrings = new StringBuffer[allStrNums];
        for (int j = 0; j < outStrings.length; j++) {
            StringBuffer outStringBuffer = new StringBuffer();
            outStrings[j] = outStringBuffer;
        }
        int letterLong = outStrings.length;
        for (int i = 0; i < inputStrCopy.length(); i++) {
            String oneKey = String.valueOf(inputStrCopy.charAt(i));
            String[] letterValues = phoneLetterMap.getPhoneKey().get(oneKey);
            letterLong = letterLong/letterValues.length;
            int step = 0;
            int valueStep = 0;
            for (StringBuffer outStringBuffer : outStrings) {
                outStringBuffer.append(letterValues[valueStep]);
                valueStep = step == letterLong - 1 ? (valueStep + 1) % letterValues.length : valueStep;
                step = step == letterLong - 1 ? 0 : step + 1;
            }
        }

        StringBuilder outBuffer = new StringBuilder();
        for (int i = 0; i < outStrings.length; i++) {
            StringBuffer outStringBuffer = outStrings[i];
            outBuffer.append(outStringBuffer);
            if (i != outStrings.length - 1) {
                outBuffer.append(" ");
            }
        }

        return outBuffer.toString();
    }

    public static String getAnswerTwo(int inputNumber, PhoneLetterMap phoneLetterMap) {
        if (inputNumber < 0 || inputNumber > 99) {
            return "param error";
        }
        String inputStr = String.valueOf(inputNumber);
       return translateNumberToLetter(phoneLetterMap, inputStr);
    }

    private static Integer getStringNum(PhoneLetterMap phoneLetterMap, String inputStr, int strLength) {
        int allStrNums = 1;
        for (Map.Entry<String, String[]> entry : phoneLetterMap.getPhoneKey().entrySet()) {
            String key = entry.getKey();
            inputStr = inputStr.replace(key, phoneLetterMap.getEmptyStr());
            int cutLength = strLength - inputStr.length();
            if (cutLength > 0) {
                allStrNums = allStrNums * entry.getValue().length;
                strLength = inputStr.length();
            }
        }
        if (strLength != 0) {
            return null;
        }
        return allStrNums;
    }
}

