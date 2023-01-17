package org.eugens21.luma.hook;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.SoftAssertions;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class GenericHooks {

    public static SoftAssertions softAssertions;

    @BeforeAll
    public static void doInitializeAssert() {
        softAssertions = new SoftAssertions();
    }

    @AfterAll
    public static void doAssertAll() {
        softAssertions.assertAll();
    }

}
