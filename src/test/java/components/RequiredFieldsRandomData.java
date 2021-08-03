package components;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.RandomUtils.getRandomItem;

public class RequiredFieldsRandomData {

    private final static List<String> GENDERS = Arrays.asList("Male", "Female", "Other");

    private final Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String gender = getRandomItem(GENDERS);


    public Map<String, String> requiredDataForCheck = new HashMap<String, String>() {{
        put("Student Name", firstName + " " + lastName);
        put("Gender", gender);
    }};
}
