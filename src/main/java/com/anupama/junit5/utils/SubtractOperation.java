package com.anupama.junit5.utils;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.Check;
@AllArgsConstructor
public class SubtractOperation {

    public int subtract(int a,int b)
    {
        CheckNumber checkNumber = new CheckNumber();
        return checkNumber.checkValidity(a,b);
    }

    public static int staticSubtract(int a,int b)
    {
        CheckNumber checkNumber = new CheckNumber();
        return checkNumber.checkValidity(a,b);
    }

    private int privateSubtract(int a,int b)
    {
        CheckNumber checkNumber = new CheckNumber();
        return checkNumber.checkValidity(a,b);
    }

}
