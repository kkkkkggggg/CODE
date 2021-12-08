package com.atck.admin;

public class TestingAStackDemo
{
    // Stack<Object> stack;
    //
    // @Test
    // @DisplayName("is instantiated with new Stack()")
    // void isInstantiatedWithNew() {
    //     new Stack<>();
    //
    //     /**
    //      * 在嵌套测试情况下，外层的Test不能驱动内层的BeforeEach/All等方法
    //      */
    //     assertNotNull(stack);
    // }
    //
    // @Nested
    // @DisplayName("when new")
    // class WhenNew {
    //
    //     @BeforeEach
    //     void createNewStack() {
    //         stack = new Stack<>();
    //     }
    //
    //     @Test
    //     @DisplayName("is empty")
    //     void isEmpty() {
    //         assertTrue(stack.isEmpty());
    //     }
    //
    //     @Test
    //     @DisplayName("throws EmptyStackException when popped")
    //     void throwsExceptionWhenPopped() {
    //         assertThrows(EmptyStackException.class, stack::pop);
    //     }
    //
    //     @Test
    //     @DisplayName("throws EmptyStackException when peeked")
    //     void throwsExceptionWhenPeeked() {
    //         assertThrows(EmptyStackException.class, stack::peek);
    //     }
    //
    //     @Nested
    //     @DisplayName("after pushing an element")
    //     class AfterPushing {
    //
    //         String anElement = "an element";
    //
    //         @BeforeEach
    //         void pushAnElement() {
    //             stack.push(anElement);
    //         }
    //
    //         /**
    //          * 内层的Test可以驱动外层的Test
    //          */
    //         @Test
    //         @DisplayName("it is no longer empty")
    //         void isNotEmpty() {
    //             assertFalse(stack.isEmpty());
    //         }
    //
    //         @Test
    //         @DisplayName("returns the element when popped and is empty")
    //         void returnElementWhenPopped() {
    //             assertEquals(anElement, stack.pop());
    //             assertTrue(stack.isEmpty());
    //         }
    //
    //         @Test
    //         @DisplayName("returns the element when peeked but remains not empty")
    //         void returnElementWhenPeeked() {
    //             assertEquals(anElement, stack.peek());
    //             assertFalse(stack.isEmpty());
    //         }
    //     }
    // }
}
