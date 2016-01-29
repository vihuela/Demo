package com.hadlink.bitcal.test;

import android.test.InstrumentationTestCase;

/**
 * @author Created by lyao on 2016/1/26.
 * @description
 */
public class BitCalTest extends InstrumentationTestCase {

    public void testBasic() {
        final int x = 4;//0000 0000 0000 0100 | -4 //1111 1111 1111 1111
        final int y = 7;//0000 0000 0000 0111
        final int res1 = x & y;//0000 0000 0000 0100
        final int res2 = x | y;//0000 0000 0000 0111
        final int res3 = x ^ y;//0000 0000 0000 0011
        final int res4 = ~x;

        assertEquals(res1, 4);
        assertEquals(res2, 7);
        assertEquals(res3, 3);
        assertEquals(res4, 3);
    }

    /**
     * 增加、清除标志位
     */
    public void testApply1() {
        final int x = 0x00000010;
        final int y = 0X00000001;
        final int res1 = x | y;
        final int res2 = x & x;
        final int res3 = res1 & ~y;//res1中清除y
        final int res4 = res3 | y;//res3附加y

        final boolean isExistX1 = (res1 & x) != 0;//包含x

        final boolean isExistX2 = (res1 & ~y) == x;//包含x


        assertEquals(res1, 17);
        assertEquals(res2, 16);
        assertEquals(res3, 16);
        assertEquals(res4, 17);
        assertEquals(isExistX1, isExistX2);
    }

    /**
     * 奇偶数
     */
    public void testCheckEven() {
        assertEquals(checkEven(2), true);
    }

    private boolean checkEven(int num) {
        return (num & 1) == 0;
    }

    /**
     * 取某个int数的某位
     */
    public void testGetIntForPosition() {
        final int x = 256;
        final int res = (x >> 2) & 1;
        assertEquals(res, 5);
    }

}
