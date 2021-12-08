package com.atck.admin;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ParameterizedTest
{

    @org.junit.jupiter.params.ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void test(int i)
    {
        System.out.println(i);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @DisplayName("参数化测试2")
    @MethodSource("stringProvider")
    void test2(String s)
    {
        System.out.println(s);
    }

    static Stream<String> stringProvider()
    {
        return Stream.of("apple","banana","atck");
    }
}
