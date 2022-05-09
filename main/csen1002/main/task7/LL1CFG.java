package csen1002.main.task7;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name John Smith
 * @id 43-0234
 * @labNumber 07
 */
public class LL1CFG {
	/**
	 * LL1 CFG constructor
	 *
	 */

	Hashtable<String, ArrayList<String>> grammar,first,follow;
	Hashtable<String,String> ptable;



	ArrayList<String> variables,terminals;
	ArrayList<String> rules;

	public LL1CFG(String description) {
		//  #S,z,n,e;T,z,no;N,n,e    #S,$;T,o;N,o"
		String [] split1 = description.split("#");
		String [] g = split1[0].split(";");
		String [] f = split1[1].split(";");
		String [] fol = split1[2].split(";");
		grammar = new Hashtable<>();
		first = new Hashtable<>();
		follow = new Hashtable<>();
		rules = new ArrayList<>();
		variables = new ArrayList<>();
		terminals = new ArrayList<>();
		ptable = new Hashtable<>();
		construct(g,grammar);
		constructFirst(f);
		constructFollow(fol);
		constructTerminals(description);
		constructTable();


		System.out.println("Grammar: "+grammar);
		System.out.println("First: "+first);
		System.out.println("Follow: "+follow);
		System.out.println("ptable: "+ptable);

	}

	private void constructTable() {
		for(String v: variables){
			for(String r :rules){
				for(String t: terminals){
					if(first.get(r).contains(t)){
						ptable.put(v+t,r);
					}
					else{
						if(grammar.get(v).contains("e")){
							if(follow.get(v).contains(t)){
								ptable.put(v+t,"e");
							}
						}
					}
				}
			}

		}
	}


	private void constructTerminals(String description){
		for(int i =0;i<description.length();i++){
			if(Character.isLowerCase(description.charAt(i))&&description.charAt(i)!='e')
				terminals.add(description.charAt(i)+"");
		}
	}

	private void constructFollow(String[] fol) {
		for(String r: fol){
			String[] tmp = r.split(",");
			String key = tmp[0];
			String t = tmp[1];
			ArrayList<String> k =new ArrayList<>();
			for(int j = 0;j<t.length();j++){
				k.add(t.charAt(j)+"");
			}
			follow.put(key,k);
		}
	}

	private void constructFirst(String[] f) {
		ArrayList<String> firstslist = new ArrayList<>();
		int counter =0;
		for(String r : f){
			String [] tmp = r.split(",");
			for (int i = 1;i<tmp.length;i++){
				firstslist.add(tmp[i]);
			}
		}
		for(String r : rules){
			ArrayList <String> tmp = new ArrayList<>();
			String t = firstslist.get(counter);
			for(int i=0;i<t.length();i++)
				tmp.add(t.charAt(i)+"");
			first.put(r,tmp);
			counter++;
		}
	}

	private void construct(String[] g,Hashtable<String,ArrayList<String>> h) {
		for( String r: g){
			ArrayList<String> list1 = new ArrayList<>();
			String[] tmp = r.split(",");
			String key = tmp[0].charAt(0)+"";
			variables.add(key);
			rules.addAll(Arrays.asList(tmp).subList(1, tmp.length));
			list1.addAll(Arrays.asList(tmp).subList(1, tmp.length));
			h.put(key,list1);
		}
	}


	/**
	 * Returns A string encoding a derivation is a comma-separated sequence of sentential forms each representing a step in the derivation..
	 * 
	 * @param input is the string to be parsed by the LL(1) CFG.
	 * @return returns a string encoding a left-most derivation.
	 */
	public String parse(String input) {
		Stack<String> stack = new Stack<>();
		stack.push("$");
		stack.push("S");
		String result="";
		String r="S,";
		int pointer = 0;
		String character,top;
		while(true){
			character = input.charAt(pointer)+"";
			top = stack.peek();

			//end of input
			if(top.equals("$")&& character.equals("$")){
				break;
			}

			// terminal
			if(top.equals(character)){
				pointer++;
				r+=top;
				stack.pop();
				continue;
			}
			//
			if(ptable.containsKey(top+character)){

			}




			break;
		}



		return null;
	}


	public static void main(String []args){
		String ll1cfg1 = "S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o";

		LL1CFG c =new LL1CFG(ll1cfg1);

		String input1 = "zzooo";
		String input2 = "zoozznooo";


	}

}


