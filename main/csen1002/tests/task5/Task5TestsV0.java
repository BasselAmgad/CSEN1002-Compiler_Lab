package csen1002.tests.task5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import csen1002.main.task5.CFG;

class Task5TestsV0 {

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
		assertEquals("S,TS',nS';" +
				"S',cTS',mS',e;" +
				"T,mSn,imLn,i;" +
				"L,mSnS'dL,imLnS'dL,iS'dL,nS'dL,mSnS',imLnS',iS',nS'", cfg.lre());
	}
	
	@Test
	@Timeout(5)
	public void testReg3() {
		CFG cfg = new CFG("S,SpT,Sq,T,b;T,qSb,iqKb,i;K,SdK,S");
		assertEquals("S,TS',bS';" +
				"S',pTS',qS',e;" +
				"T,qSb,iqKb,i;" +
				"K,qSbS'dK,iqKbS'dK,iS'dK,bS'dK,qSbS',iqKbS',iS',bS'", cfg.lre());
	}
	
	@Test
	@Timeout(5)
	public void testReg4() {
		CFG cfg = new CFG("S,LW,Wd;L,SW,LS,m;W,SL,m");
		assertEquals("S,LW,Wd;" +
				"L,WdWL',mL';" +
				"L',WWL',SL',e;W,mL'WLW',mW';W',dWL'WLW',dLW',e",cfg.lre());
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
	
}