package com.anupama.junit5.utils;

public class CheckNumber {
    public int checkValidity(int a, int b){
        if(a>10)
            return a;
        else
            return (a-b);
    }

}
