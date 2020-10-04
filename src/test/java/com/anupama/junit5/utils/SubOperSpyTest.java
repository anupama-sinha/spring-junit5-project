package com.anupama.junit5.utils;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubOperSpyTest{
    @InjectMocks
    SubtractOperation testClass;

    @Spy
    CheckNumber spyCheckNumber;

    @Test
    @DisplayName("TestSubtractOperation")
    public void testSubtractOperation(){
        //given
        int expected = 7;
        //when
        when(spyCheckNumber.checkValidity(1,1)).thenReturn(3);
        int actual = testClass.subtract(14,7);
        //then
        assertEquals(expected,actual,"Subtract Operation Testing");
    }
}