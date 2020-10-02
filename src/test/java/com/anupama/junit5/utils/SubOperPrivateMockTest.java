package com.anupama.junit5.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class SubOperPrivateMockTest {
    @InjectMocks
    SubtractOperation subtractOperation;

    @Test
    @Disabled
    public void testPrivate() throws Exception{
        //given

        //when
//        Mockito.when(subtractOperation.privateSubtract(1,1)).thenReturn(0);
        int result = Whitebox.invokeMethod(SubtractOperation.class,"subtractOperation.privateSubtract(1,1)","Invoking Private Method");

        //then
        Assertions.assertEquals(0,result,"Testing Subtract for Private Method");
    }
}
