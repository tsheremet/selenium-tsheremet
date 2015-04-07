package testlink.models;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by tanya on 3/20/15.
 */
public class TestSuite {
    public String name = getCorrectName();

    public String getCorrectName() {
        name = "TS Name Tan - " +RandomStringUtils.randomAlphabetic(10);
        return name;
    }
}
