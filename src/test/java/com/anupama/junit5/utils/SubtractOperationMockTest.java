package com.anupama.junit5.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SubtractOperationMockTest{
    @InjectMocks
    SubtractOperation testClass;

//    @Mock
//    CheckNumber mockCheckNumber;

    //Below was used earlier for MockitoExtension.class alternative
    /*@BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }*/

    @Test
    @DisplayName("TestPositives")
    void testPositives(){
        //given
        int expected = 14;
        //when
//        when(mockCheckNumber.checkValidity(14,7)).thenReturn(7);
//         int actual = testClass.subtract(14,pr);
        //then
//         assertEquals(expected,actual,"Positive Mock Testing");
    }
}
