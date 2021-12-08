package com.atck.admin;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("junit5功能测试类")
@SpringBootTest
public class Junit5Test
{



    // @DisplayName("测试DisplayName注解")
    // @Test
    // void testDisplayName()
    // {
    //     System.out.println(1);
    // }
    //
    // @Disabled
    // @DisplayName("测试DisplayName注解2")
    // @Test
    // void test2()
    // {
    //     System.out.println(2);
    // }
    //
    // @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    // void testTimeOut() throws InterruptedException
    // {
    //     // Thread.sleep(600);
    //     Thread.sleep(400);
    //
    // }
    // @BeforeEach
    // void testBeforeEach()
    // {
    //     System.out.println("测试就要开始了。。。。");
    // }
    //
    // @AfterEach
    // void afterBeforeEach()
    // {
    //     System.out.println("测试结束了。。。。");
    // }
    //
    // @BeforeAll
    // static void beforeAll()
    // {
    //     System.out.println("所有测试就要开始了。。。。");
    // }
    //
    // @AfterAll
    // static void afterAll()
    // {
    //     System.out.println("所有测试都结束了。。。。");
    // }
    //
    // @RepeatedTest(5)
    // @Test
    // void test3()
    // {
    //     System.out.println(5);
    // }
    //
    // /**
    //  * 前面断言失败，后面的断言不会出现
    //  */
    // @DisplayName("测试简单断言")
    // @Test
    // void tetsSimpleAssertions()
    // {
    //     int cal = cal(3, 3);
    //     // assertEquals(5,cal,"业务逻辑计算失败");
    //     assertEquals(6,cal,"业务逻辑计算失败");
    //
    //     Object obj1 = new Object();
    //     Object obj2 = new Object();
    //     assertSame(obj1,obj2,"两个对象不一样");
    //
    // }
    //
    // int cal(int i,int j)
    // {
    //     return i + j;
    // }
    //
    // @Test
    // @DisplayName("arrayt assertions")
    // void testArray()
    // {
    //     assertArrayEquals(new int[]{1,2},new int[]{1,2},"两个数组不同");
    // }
    //
    //
    // /**
    //  * 所有断言都成功才能成功
    //  */
    // @Test
    // @DisplayName("组合断言")
    // void all()
    // {
    //     assertAll("test", () -> assertTrue(true && true),
    //             () -> assertEquals(1,1));
    // }
    //
    // @Test
    // @DisplayName("异常断言")
    // void testException()
    // {
    //     // assertThrows(ArithmeticException.class,() -> {int i = 10 / 1;},"业务逻辑居然正常运行？");
    //     assertThrows(ArithmeticException.class,() -> {int i = 10 / 0;},"业务逻辑居然正常运行？");
    //
    // }
    //
    // @Test
    // @DisplayName("快速失败")
    // void testFail()
    // {
    //     if (false)
    //     {
    //
    //         fail("测试失败");
    //     }
    // }
    //
    // /**
    //  * 测试前置条件
    //  */
    // @Test
    // @DisplayName("测试前置条件")
    // void testAssumption()
    // {
    //     // Assumptions.assumeTrue(false,"结果不是true");
    //     Assumptions.assumeTrue(true,"结果不是true");
    //     System.out.println(11111111);
    // }
}
