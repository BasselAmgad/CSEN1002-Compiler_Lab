package csen1002.tests.task4;

import csen1002.main.task4.FDFA;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task4_oldtest {

	@Test
	@Timeout(5)
	public void TestFDFA1() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,1,3,C;3,1,0,D#3");
		assertEquals("0100,B;", fdfa.run("0100"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA2() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,1,3,C;3,1,0,D#3");
		assertEquals("10011,D;", fdfa.run("10011"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA3() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,1,3,C;3,1,0,D#3");
		assertEquals("1000011011,D;", fdfa.run("1000011011"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA4() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,1,3,C;3,1,0,D#3");
		assertEquals("011,D;001,C;", fdfa.run("011001"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA5() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,1,3,C;3,1,0,D#3");
		assertEquals("10011,D;11010,B;", fdfa.run("1001111010"));
	}
	// 2nd FDFA
	@Test
	@Timeout(5)
	public void TestFDFA6() {
		FDFA fdfa = new FDFA("0,1,3,A;1,2,3,B;2,2,4,C;3,1,4,D;4,2,4,E#2,4");
		assertEquals("01110110,C;", fdfa.run("01110110"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA7() {
		FDFA fdfa = new FDFA("0,1,3,A;1,2,3,B;2,2,4,C;3,1,4,D;4,2,4,E#2,4");
		assertEquals("0101001,E;", fdfa.run("0101001"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA8() {
		FDFA fdfa = new FDFA("0,1,3,A;1,2,3,B;2,2,4,C;3,1,4,D;4,2,4,E#2,4");
		assertEquals("1010,B;", fdfa.run("1010"));
	}

	@Test
	@Timeout(5)
	public void TestFDFA9() {
		FDFA fdfa = new FDFA("0,1,3,A;1,2,3,B;2,2,4,C;3,1,4,D;4,2,4,E#2,4");
		assertEquals("101011001,E;", fdfa.run("101011001"));
	}
	
	@Test
	@Timeout(5)
	public void TestFDFA10() {
		FDFA fdfa = new FDFA("0,1,3,A;1,2,3,B;2,2,4,C;3,1,4,D;4,2,4,E#2,4");
		assertEquals("11110,C;", fdfa.run("11110"));
	}

	// 3rd FDFA
	@Test
	@Timeout(5)
	public void TestFDFA11() {
		FDFA fdfa = new FDFA("0,1,0,A;1,0,2,B;2,0,2,C#1");
		assertEquals("0,B;11110,B;", fdfa.run("011110"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA12() {
		FDFA fdfa = new FDFA("0,1,0,A;1,0,2,B;2,0,2,C#1");
		assertEquals("110,B;110,B;", fdfa.run("110110"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA13() {
		FDFA fdfa = new FDFA("0,1,0,A;1,0,2,B;2,0,2,C#1");
		assertEquals("0100,B;11,A;", fdfa.run("010011"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA14() {
		FDFA fdfa = new FDFA("0,1,0,A;1,0,2,B;2,0,2,C#1");
		assertEquals("0,B;1111,A;", fdfa.run("01111"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA15() {
		FDFA fdfa = new FDFA("0,1,0,A;1,0,2,B;2,0,2,C#1");
		assertEquals("10,B;110,B;11,A;", fdfa.run("1011011"));
	}

	// 4th FDFA
	@Test
	@Timeout(5)
	public void TestFDFA16() {
		FDFA fdfa = new FDFA("0,0,1,A;1,2,1,B;2,3,3,C;3,4,1,D;4,5,2,E;5,4,1,F#4,5");
		assertEquals("0010,C;", fdfa.run("0010"));

	}
	@Test
	@Timeout(5)
	public void TestFDFA17() {
		FDFA fdfa = new FDFA("0,0,1,A;1,2,1,B;2,3,3,C;3,4,1,D;4,5,2,E;5,4,1,F#4,5");
		assertEquals("10100,F;1,B;", fdfa.run("101001"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA18() {
		FDFA fdfa = new FDFA("0,0,1,A;1,2,1,B;2,3,3,C;3,4,1,D;4,5,2,E;5,4,1,F#4,5");
		assertEquals("101001000,E;1,B;", fdfa.run("1010010001"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA19() {
		FDFA fdfa = new FDFA("0,0,1,A;1,2,1,B;2,3,3,C;3,4,1,D;4,5,2,E;5,4,1,F#4,5");
		assertEquals("1010,E;10,C;", fdfa.run("101010"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA20() {
		FDFA fdfa = new FDFA("0,0,1,A;1,2,1,B;2,3,3,C;3,4,1,D;4,5,2,E;5,4,1,F#4,5");
		assertEquals("001101,D;", fdfa.run("001101"));
	}

	// 5th FDFA
	@Test
	@Timeout(5)
	public void TestFDFA21() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,2,3,C;3,3,4,D;4,4,4,E#1,3");
		assertEquals("10,B;10,B;", fdfa.run("1010"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA22() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,2,3,C;3,3,4,D;4,4,4,E#1,3");
		assertEquals("011,D;1,A;", fdfa.run("0111"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA23() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,2,3,C;3,3,4,D;4,4,4,E#1,3");
		assertEquals("0,B;1,A;", fdfa.run("01"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA24() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,2,3,C;3,3,4,D;4,4,4,E#1,3");
		assertEquals("011,D;10,B;", fdfa.run("01110"));
	}
	@Test
	@Timeout(5)
	public void TestFDFA25() {
		FDFA fdfa = new FDFA("0,1,0,A;1,1,2,B;2,2,3,C;3,3,4,D;4,4,4,E#1,3");
		assertEquals("10101,D;", fdfa.run("10101"));
	}

}