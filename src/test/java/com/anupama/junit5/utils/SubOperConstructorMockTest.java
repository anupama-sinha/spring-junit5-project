package com.anupama.junit5.utils;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SubtractOperation.class)
public class SubOperConstructorMockTest {
    @InjectMocks
    SubtractOperation subtractOperation;

    @Test
    @Disabled
    public void testStatic() throws Exception{
        //given

        //when
        PowerMockito.whenNew(Integer.class).withAnyArguments().thenReturn(1);
//        int result = subtractOperation.SubtractOperation(1);

        //then
    }
}
