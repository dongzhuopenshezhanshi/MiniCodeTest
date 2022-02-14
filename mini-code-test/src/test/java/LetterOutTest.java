import org.junit.Test;
import vo.PhoneLetterMap;

public class LetterOutTest {

    //  arr length limit 10
    private final int[] questionInPutOne = {2,4,5,6,8,9,2,3,5,5};

    @Test
    public void testPhoneLetterOne() {
        PhoneLetterMap phoneLetterMap = PhoneLetterBuilder.getLetterMap();
        System.out.println(PhoneLetterTranslate.getAnswerOne(questionInPutOne, phoneLetterMap));

    }

    @Test
    public void testPhoneLetterTwo() {
        PhoneLetterMap phoneLetterMap = PhoneLetterBuilder.getLetterMap();
        // limit 0 to 99
        int questionInputTwo = 89;
        System.out.println(PhoneLetterTranslate.getAnswerTwo(questionInputTwo, phoneLetterMap));
    }
}
