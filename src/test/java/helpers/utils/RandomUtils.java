package helpers.utils;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomUtils {

    private static Logger logger = LoggerFactory.getLogger(RandomUtils.class);

    private static String emailDomain = "@jbtd.no";

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static String getRandomCharUp(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static String getRandomCharLow(int length) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }

    public static String getRandomStringInt(int length) {
        String SALTCHARS = "1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }


    public static String getRandomStringText(int length) {
        String SALTCHARS = "йцукенгшщзхъфывапролджэёячсмитьбюЙЦУКЕНГШЩЗХЪЁЭЖДЛОРПАВЫФЯЧСМИТЬБЮ";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }
        return result.toString();
    }


    public static String getRandomMessage(int min, int max) {
        String[] words = {"and", "or", "but", "because",
                "red", "white", "Jane", "John", "Bobby",
                "man", "woman", "fish", "elephant", "unicorn",
                "a", "the", "every", "some", "any", "all",
                "big", "tiny", "pretty", "bald", "small",
                "runs", "jumps", "talks", "sleeps", "walks",
                "loves", "hates", "sees", "knows", "looks for", "finds",
                ", ", ", ", ", ", ". ", ". "};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words.length - 1);
            message.append(words[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        logger.info("Generated message: " + readyMessage);

        return readyMessage;
    }


    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L) + "7";
    }


    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getRandomSNILS() {
        int[] number = new int[9];
        for (int i = 0; i < 9; i++) {
            number[i] = getRandomInt(0,9);
        }
        String K = "";
        int K1 =(number[0]*9 +number[1]*8 +number[2]*7 +number[3]*6 +number[4]*5 +number[5]*4 +number[6]*3 +number[7]*2 +number[8]*1)%101;
        if (K1 / 10 == 0){
            K = "0" + K1;
        } else {
            K = String.valueOf(K1);
        }

        String snils = String.valueOf(number[0]) + number[1] + number[2] + number[3] + number[4] + number[5] + number[6] + number[7] + number[8] + K;
                ;
        return snils;
    }

}
