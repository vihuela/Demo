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

    public void testApply1() {
        final int x = 3;
        final int y = 4;
        final int res1 = x ^ y;

        assertEquals(res1, 4);
    }

    public void testApply2() {
        final int x = 0x00000010;
        final int y = 0X00000001;
        final int res1 = x | y;
        final int res2 = res1 & ~x;//res1中清除x


        assertEquals(res1, 17);
        assertEquals(res2, 1);
    }

}
