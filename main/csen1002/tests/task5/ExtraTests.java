package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task5.CFG;

class ExtraTests {

    @Test
    @Timeout(5)
    public void testReg1() {
        CFG cfg = new CFG("S,SaT,T;T,TzG,G;G,i");
        assertEquals("S,TS';S',aTS',e;T,GT';T',zGT',e;G,i",cfg.lre());
    }

    @Test
    @Timeout(5)
    public void testReg2() {
        CFG cfg = new CFG("S,ScT,Sm,T,n;T,mSn,imLn,i;L,SdL,S");
        assertEquals("S,TS',nS';S',cTS',mS',e;T,mSn,imLn,i;L,mSnS'dL,imLnS'dL,iS'dL,nS'dL,mSnS',imLnS',iS',nS'", cfg.lre());
    }

    @Test
    @Timeout(5)
    public void testReg3() {
        CFG cfg = new CFG("S,SpT,Sq,T,b;T,qSb,iqKb,i;K,SdK,S");
        assertEquals("S,TS',bS';S',pTS',qS',e;T,qSb,iqKb,i;K,qSbS'dK,iqKbS'dK,iS'dK,bS'dK,qSbS',iqKbS',iS',bS'", cfg.lre());
    }

    @Test
    @Timeout(5)
    public void testReg4() {
        CFG cfg = new CFG("S,LW,Wd;L,SW,LS,m;W,SL,m");
        assertEquals("S,LW,Wd;L,WdWL',mL';L',WWL',SL',e;W,mL'WLW',mW';W',dWL'WLW',dLW',e",cfg.lre());
    }

    @Test
    @Timeout(5)
    public void testReg5() {
        CFG cfg = new CFG("S,ScT,Sq,T,b;T,qSb,iqHb,i;H,SdH,S");
        assertEquals("S,TS',bS';S',cTS',qS',e;T,qSb,iqHb,i;H,qSbS'dH,iqHbS'dH,iS'dH,bS'dH,qSbS',iqHbS',iS',bS'", cfg.lre());
    }

    @Test
    @Timeout(5)
    public void testReg6() {
        CFG cfg = new CFG("S,ScT,T;T,aSb,iaLb,i;L,SdL,S");
        assertEquals("S,TS';S',cTS',e;T,aSb,iaLb,i;L,aSbS'dL,iaLbS'dL,iS'dL,aSbS',iaLbS',iS'", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg7() {
        CFG cfg = new CFG("S,Sa,b");
        assertEquals("S,bS';S',aS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg8() {
        CFG cfg = new CFG("S,Sab,cd");
        assertEquals("S,cdS';S',abS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg9() {
        CFG cfg = new CFG("S,SuS,SS,Ss,lSr,a");
        assertEquals("S,lSrS',aS';S',uSS',SS',sS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg10() {
        CFG cfg = new CFG("S,SuT,T;T,TF,F;F,Fs,P;P,a,b");
        assertEquals("S,TS';S',uTS',e;T,FT';T',FT',e;F,PF';F',sF',e;P,a,b", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg11() {
        CFG cfg = new CFG("S,z,To;T,o,Sz");
        assertEquals("S,z,To;T,oT',zzT';T',ozT',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg12() {
        CFG cfg = new CFG("S,lLr,a;L,LbS,S");
        assertEquals("S,lLr,a;L,lLrL',aL';L',bSL',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg13() {
        CFG cfg = new CFG("S,BC,C;B,Bb,b;C,SC,a");
        assertEquals("S,BC,C;B,bB';B',bB',e;C,bB'CCC',aC';C',CC',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg14() {
        CFG cfg = new CFG("S,ScT,Sn,T,b;T,nSb,inGb,i;G,SdG,S");
        assertEquals("S,TS',bS';S',cTS',nS',e;T,nSb,inGb,i;G,nSbS'dG,inGbS'dG,iS'dG,bS'dG,nSbS',inGbS',iS',bS'", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg15() {
        CFG cfg = new CFG("S,EJ,Jd;E,SJ,ES,c;J,SE,c");
        assertEquals("S,EJ,Jd;E,JdJE',cE';E',JJE',SE',e;J,cE'JEJ',cJ';J',dJE'JEJ',dEJ',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg16() {
        CFG cfg = new CFG("S,SdT,T;T,TmJ,J;J,x");
        assertEquals("S,TS';S',dTS',e;T,JT';T',mJT',e;J,x", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg17() {
        CFG cfg = new CFG("S,SdS,SmS,n");
        assertEquals("S,nS';S',dSS',mSS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg18() {
        CFG cfg = new CFG("S,nSt,nS,c");
        assertEquals("S,nSt,nS,c", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg19() {
        CFG cfg = new CFG("S,ScT,Sm,T,n;T,mSn,imLn,i;L,SdL,S");
        assertEquals("S,TS',nS';S',cTS',mS',e;T,mSn,imLn,i;L,mSnS'dL,imLnS'dL,iS'dL,nS'dL,mSnS',imLnS',iS',nS'", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg20() {
        CFG cfg = new CFG("S,HG,Gd;H,SG,HS,c;G,SH,c");
        assertEquals("S,HG,Gd;H,GdGH',cH';H',GGH',SH',e;G,cH'GHG',cG';G',dGH'GHG',dHG',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg21() {
        CFG cfg = new CFG("S,SaT,T;T,TzG,G;G,i");
        assertEquals("S,TS';S',aTS',e;T,GT';T',zGT',e;G,i", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg22() {
        CFG cfg = new CFG("S,SaS,SzS,m");
        assertEquals("S,mS';S',aSS',zSS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg23() {
        CFG cfg = new CFG("S,mSt,mS,c");
        assertEquals("S,mSt,mS,c", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg24() {
        CFG cfg = new CFG("S,ScT,Sa,T,b;T,aSb,iaLb,i;L,SdL,S");
        assertEquals("S,TS',bS';S',cTS',aS',e;T,aSb,iaLb,i;L,aSbS'dL,iaLbS'dL,iS'dL,bS'dL,aSbS',iaLbS',iS',bS'", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg25() {
        CFG cfg = new CFG("S,EF,Fd;E,SF,ES,c;F,SE,c");
        assertEquals("S,EF,Fd;E,FdFE',cE';E',FFE',SE',e;F,cE'FEF',cF';F',dFE'FEF',dEF',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg26() {
        CFG cfg = new CFG("S,StT,T;T,TxF,F;F,id");
        assertEquals("S,TS';S',tTS',e;T,FT';T',xFT',e;F,id", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg27() {
        CFG cfg = new CFG("S,StS,SxS,a");
        assertEquals("S,aS';S',tSS',xSS',e", cfg.lre());
    }
    @Test
    @Timeout(5)
    public void testReg28() {
        CFG cfg = new CFG("S,aSt,aS,c");
        assertEquals("S,aSt,aS,c", cfg.lre());
    }
}