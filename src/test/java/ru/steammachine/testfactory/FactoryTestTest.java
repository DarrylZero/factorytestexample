package ru.steammachine.testfactory;

import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.provider.Arguments;

public class FactoryTestTest {


    @TestFactory
    Stream<DynamicNode> testSomething() {

        return getTokens().map((Function<Arguments, DynamicTest>) args -> DynamicTest
                .dynamicTest(String.class.cast(args.get()[1]),
                        () -> Assertions.assertFalse(
                                String.class.cast(args.get()[0]).contains("cannot"))));

    }

    public static Stream<Arguments> getTokens() {
        return Stream.of(
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken1"),
                Arguments.arguments("cannot get token", "TestOfToken2"),
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken3"),
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken4"),
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken5"),
                Arguments.arguments("cannot get token", "TestOfToken6"),
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken6"),
                Arguments.arguments("wertyuikjhgfdghjk", "TestOfToken7")
        );
    }

}
