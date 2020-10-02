package com.anupama.junit5.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SubtractOperation.class)
public class SubOperStaticMockTest {
    @InjectMocks
    SubtractOperation subtractOperation;

    @Test
    @Disabled
    public void testStatic() throws Exception{
        //given
        PowerMockito.mockStatic(SubtractOperation.class);

        //when
        Mockito.when(subtractOperation.staticSubtract(1,1)).thenReturn(0);

        //then
        Assertions.assertEquals(0,SubtractOperation.staticSubtract(1,1),"Testing Subtract for Static Method");
    }
}
