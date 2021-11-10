package net.technologyrediscovery;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingletonLoadOnceTest
{

    private final TestCaseClass testClass = new TestCaseClass();

    @Test
    protected void loadResources() {
        testClass.example = "value";
        Assertions.assertEquals(testClass.example, "value", "This failed.");
    }

    @Test
    protected void updateValue() {
        Assertions.assertEquals(testClass.example, "value", "This value is incorrect.");
        testClass.example = "newVariable";
        Assertions.assertEquals(testClass.example, "newVariable", "This failed as well.");
    }

    @Test
    protected void checkValue() {

    }

}
