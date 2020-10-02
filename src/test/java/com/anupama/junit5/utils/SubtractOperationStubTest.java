package com.anupama.junit5.utils;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //Not a good practice
class SubtractOperationStubTest {
    @Test
    @DisplayName("TestPositives")
    @Order(1)
    void testCorrectSubtractOperation(){
        SubtractOperation testClass = new SubtractOperation();

        //given
        int expected = 2;
        //when
        int actual = testClass.subtract(9,7);
        //then
        assertEquals(expected,actual,"Positive Testing");
    }

    @Test
    @DisplayName("TestNegatives")
    @Order(2)
    void testInCorrectSubtractOperation(){
        SubtractOperation testClass = new SubtractOperation();

        //given
        int expected = 0;
        //when
        int actual = testClass.subtract(-1,-1);
        //then
        assertEquals(expected,actual,"Negative Testing");
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("In @BeforeAll");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("\n"+"In @BeforeEach");
    }


    @Test
    public void testDummy() {
        System.out.println("\n"+"In testDummy()");
    }

    @Test
    public void testData() {
        System.out.println("\n"+"In testData()");
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("\n"+"In @AfterEach");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("\n"+"In @AfterAll");
    }
}
