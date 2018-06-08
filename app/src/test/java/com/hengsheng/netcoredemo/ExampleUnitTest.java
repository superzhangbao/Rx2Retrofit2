package com.hengsheng.netcoredemo;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private String a = "1234567890";

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    /**
     * 字符串反转的几种方法
     * 1.调用reversel（）方法实现翻转
     */
    @Test
    public void reverse1() throws Exception {
        StringBuilder stringBuilder = new StringBuilder(a);
        String s = stringBuilder.reverse().toString();
        System.out.println("reverse1()-->"+s);
    }

    //2.通过字符串数组实现从尾部开始逐个逆序放入字符串中
    @Test
    public void reverse2() throws Exception {
        char[] chars = a.toCharArray();
        StringBuilder reverse = new StringBuilder();
        for (int i = chars.length -1 ; i>=0 ;i--) {
            reverse.append(chars[i]);
        }
        System.out.println("reverse2()-->"+reverse);
    }

    //3.通过字符串数组实现从头部开始逐个正序放入字符串中
    @Test
    public void reverse3() throws Exception {
        int length = a.length();
        String reverse = "";
        for (int i = 0; i < length; i++) {
            reverse = a.charAt(i) + reverse;
        }
        System.out.println("reverse3()-->"+reverse);
    }

    @Test
    public void reverse4() throws Exception {
        char[] chars = a.toCharArray();
        int n = chars.length -1;
        int halfLength = n/2;
        for (int i = 0; i < halfLength; i++) {
            char temp = chars[i];
            chars[i] = chars[n-i];
            chars[n-i] = temp;
        }
        System.out.println("reverse4()-->"+new String(chars));
    }
}