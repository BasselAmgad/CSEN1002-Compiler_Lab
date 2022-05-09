package csen1002.tests.task6;

import static org.junit.jupiter.api.Assertions.*;

import csen1002.main.task6.FFCFG;
import org.junit.jupiter.api.Test;

/*
 * @author Hamahmi
 * @version 1.0
 * @since 2020-04-03
 */

class FirstFollowTests2 {

    // https://www.facebook.com/groups/1640157849618962/permalink/2256719911296083/
    private final String cfg1 = "S,ScT,T;T,aSb,iaLb,e;L,SdL,S";
    private final String first1 = "S,acei;T,aei;L,acdei";
    private final String follow1 = "S,bcd$;T,bcd$;L,b";

    private final String cfg2 = "S,aTbS,e;T,aTb,e";
    private final String first2 = "S,ae;T,ae";
    private final String follow2 = "S,$;T,b";

    private final String cfg3 = "S,SAB,SBC,e;A,aAa,e;B,bB,e;C,cC,e";
    private final String first3 = "S,abce;A,ae;B,be;C,ce";
    private final String follow3 = "S,abc$;A,abc$;B,abc$;C,abc$";

    private final String cfg4 = "S,AB;A,aA,b;B,CA;C,cC,d";
    private final String first4 = "S,ab;A,ab;B,cd;C,cd";
    private final String follow4 = "S,$;A,cd$;B,$;C,ab";

    private final String cfg5 = "S,lAr,a;A,lArB,aB;B,cSB,e";
    private final String first5 = "S,al;A,al;B,ce";
    private final String follow5 = "S,cr$;A,r;B,r";

    private final String cfg6 = "S,aA;A,SB,e;B,bA,cA";
    private final String first6 = "S,a;A,ae;B,bc";
    private final String follow6 = "S,bc$;A,bc$;B,bc$";

    // https://www.facebook.com/groups/1640157849618962/permalink/2260641134237294/
    private final String cfg7 = "S,ABCDZ;A,a,e;B,b,e;C,c;D,d,e;Z,z,e";
    private final String first7 = "S,abc;A,ae;B,be;C,c;D,de;Z,ez";
    private final String follow7 = "S,$;A,bc;B,c;C,dz$;D,z$;Z,$";

    private final String cfg8 = "S,TX;X,aTX,e;T,FV;V,bFV,e;F,cSd,i";
    private final String first8 = "S,ci;X,ae;T,ci;V,be;F,ci";
    private final String follow8 = "S,d$;X,d$;T,ad$;V,ad$;F,abd$";

    private final String cfg9 = "S,ACB,CbB,Ba;A,da,BC;B,g,e;C,h,e";
    private final String first9 = "S,abdegh;A,degh;B,eg;C,eh";
    private final String follow9 = "S,$;A,gh$;B,agh$;C,bgh$";

    private final String cfg10 = "S,Bb,Cd;B,aB,e;C,cC,e";
    private final String first10 = "S,abcd;B,ae;C,ce";
    private final String follow10 = "S,$;B,b;C,d";

    private final String cfg11 = "S,aBDh;B,cC;C,bC,e;D,EF;E,g,e;F,f,e";
    private final String first11 = "S,a;B,c;C,be;D,efg;E,eg;F,ef";
    private final String follow11 = "S,$;B,fgh;C,fgh;D,h;E,fh;F,h";

    private final String cfg12 = "S,A;A,aBF;F,dF,e;B,b;C,g";
    private final String first12 = "S,a;A,a;F,de;B,b;C,g";
    private final String follow12 = "S,$;A,$;F,$;B,d$;C,";

    private final String cfg13 = "S,bLc,a;L,SQ;Q,dSQ,e";
    private final String first13 = "S,ab;L,ab;Q,de";
    private final String follow13 = "S,cd$;L,c;Q,c";

    private final String cfg14 = "S,AaAb,BbBa;A,e;B,e";
    private final String first14 = "S,ab;A,e;B,e";
    private final String follow14 = "S,$;A,ab;B,ab";

    private final String cfg15 = "S,TQ;Q,aTQ,e;T,FW;W,xFW,e;F,bSc,i";
    private final String first15 = "S,bi;Q,ae;T,bi;W,ex;F,bi";
    private final String follow15 = "S,c$;Q,c$;T,ac$;W,ac$;F,acx$";

    private final String cfg16 = "S,ACB,CbB,Ba;A,da,BC;B,g,e;C,h,e";
    private final String first16 = "S,abdegh;A,degh;B,eg;C,eh";
    private final String follow16 = "S,$;A,gh$;B,agh$;C,bgh$";

    @Test
    public void testFirst1() {
        FFCFG cfg = new FFCFG(cfg1);
        String firstEncoding = cfg.first();
        assertEquals(first1, firstEncoding);
    }

    @Test
    public void testFollow1() {
        FFCFG cfg = new FFCFG(cfg1);
        String followEncoding = cfg.follow();
        assertEquals(follow1, followEncoding);
    }

    @Test
    public void testFirst2() {
        FFCFG cfg = new FFCFG(cfg2);
        String firstEncoding = cfg.first();
        assertEquals(first2, firstEncoding);
    }

    @Test
    public void testFollow2() {
        FFCFG cfg = new FFCFG(cfg2);
        String followEncoding = cfg.follow();
        assertEquals(follow2, followEncoding);
    }

    @Test
    public void testFirst3() {
        FFCFG cfg = new FFCFG(cfg3);
        String firstEncoding = cfg.first();
        assertEquals(first3, firstEncoding);
    }

    @Test
    public void testFollow3() {
        FFCFG cfg = new FFCFG(cfg3);
        String followEncoding = cfg.follow();
        assertEquals(follow3, followEncoding);
    }

    @Test
    public void testFirst4() {
        FFCFG cfg = new FFCFG(cfg4);
        String firstEncoding = cfg.first();
        assertEquals(first4, firstEncoding);
    }

    @Test
    public void testFollow4() {
        FFCFG cfg = new FFCFG(cfg4);
        String followEncoding = cfg.follow();
        assertEquals(follow4, followEncoding);
    }

    @Test
    public void testFirst5() {
        FFCFG cfg = new FFCFG(cfg5);
        String firstEncoding = cfg.first();
        assertEquals(first5, firstEncoding);
    }

    @Test
    public void testFollow5() {
        FFCFG cfg = new FFCFG(cfg5);
        String followEncoding = cfg.follow();
        assertEquals(follow5, followEncoding);
    }

    @Test
    public void testFirst6() {
        FFCFG cfg = new FFCFG(cfg6);
        String firstEncoding = cfg.first();
        assertEquals(first6, firstEncoding);
    }

    @Test
    public void testFollow6() {
        FFCFG cfg = new FFCFG(cfg6);
        String followEncoding = cfg.follow();
        assertEquals(follow6, followEncoding);
    }

    @Test
    public void testFirst7() {
        FFCFG cfg = new FFCFG(cfg7);
        String firstEncoding = cfg.first();
        assertEquals(first7, firstEncoding);
    }

    @Test
    public void testFollow7() {
        FFCFG cfg = new FFCFG(cfg7);
        String followEncoding = cfg.follow();
        assertEquals(follow7, followEncoding);
    }

    @Test
    public void testFirst8() {
        FFCFG cfg = new FFCFG(cfg8);
        String firstEncoding = cfg.first();
        assertEquals(first8, firstEncoding);
    }

    @Test
    public void testFollow8() {
        FFCFG cfg = new FFCFG(cfg8);
        String followEncoding = cfg.follow();
        assertEquals(follow8, followEncoding);
    }

    @Test
    public void testFirst9() {
        FFCFG cfg = new FFCFG(cfg9);
        String firstEncoding = cfg.first();
        assertEquals(first9, firstEncoding);
    }

    @Test
    public void testFollow9() {
        FFCFG cfg = new FFCFG(cfg9);
        String followEncoding = cfg.follow();
        assertEquals(follow9, followEncoding);
    }

    @Test
    public void testFirst10() {
        FFCFG cfg = new FFCFG(cfg10);
        String firstEncoding = cfg.first();
        assertEquals(first10, firstEncoding);
    }

    @Test
    public void testFollow10() {
        FFCFG cfg = new FFCFG(cfg10);
        String followEncoding = cfg.follow();
        assertEquals(follow10, followEncoding);
    }

    @Test
    public void testFirst11() {
        FFCFG cfg = new FFCFG(cfg11);
        String firstEncoding = cfg.first();
        assertEquals(first11, firstEncoding);
    }

    @Test
    public void testFollow11() {
        FFCFG cfg = new FFCFG(cfg11);
        String followEncoding = cfg.follow();
        assertEquals(follow11, followEncoding);
    }

    @Test
    public void testFirst12() {
        FFCFG cfg = new FFCFG(cfg12);
        String firstEncoding = cfg.first();
        assertEquals(first12, firstEncoding);
    }

    @Test
    public void testFollow12() {
        FFCFG cfg = new FFCFG(cfg12);
        String followEncoding = cfg.follow();
        assertEquals(follow12, followEncoding);
    }

    @Test
    public void testFirst13() {
        FFCFG cfg = new FFCFG(cfg13);
        String firstEncoding = cfg.first();
        assertEquals(first13, firstEncoding);
    }

    @Test
    public void testFollow13() {
        FFCFG cfg = new FFCFG(cfg13);
        String followEncoding = cfg.follow();
        assertEquals(follow13, followEncoding);
    }

    @Test
    public void testFirst14() {
        FFCFG cfg = new FFCFG(cfg14);
        String firstEncoding = cfg.first();
        assertEquals(first14, firstEncoding);
    }

    @Test
    public void testFollow14() {
        FFCFG cfg = new FFCFG(cfg14);
        String followEncoding = cfg.follow();
        assertEquals(follow14, followEncoding);
    }

    @Test
    public void testFirst15() {
        FFCFG cfg = new FFCFG(cfg15);
        String firstEncoding = cfg.first();
        assertEquals(first15, firstEncoding);
    }

    @Test
    public void testFollow15() {
        FFCFG cfg = new FFCFG(cfg15);
        String followEncoding = cfg.follow();
        assertEquals(follow15, followEncoding);
    }

    @Test
    public void testFirst16() {
        FFCFG cfg = new FFCFG(cfg16);
        String firstEncoding = cfg.first();
        assertEquals(first16, firstEncoding);
    }

    @Test
    public void testFollow16() {
        FFCFG cfg = new FFCFG(cfg16);
        String followEncoding = cfg.follow();
        assertEquals(follow16, followEncoding);
    }

}
