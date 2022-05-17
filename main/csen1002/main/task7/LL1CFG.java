package csen1002.main.task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Stack;

/**
 * Write your info here
 * 
 * @name Bassel Amgad
 * @id 43-6927
 * @labNumber 08
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
				if(grammar.get(v).contains(r)){
					for(String t: terminals){
						if(first.get(r).contains(t)){
							if(!ptable.containsKey(v+t))
								ptable.put(v+t,r);
						}
						else{
							if(grammar.get(v).contains("e")){
								if(follow.get(v).contains(t)){
									if(!ptable.containsKey(v+t))
										ptable.put(v+t,"e");
								}
							}
						}
					}
				}

			}

		}
	}


	private void constructTerminals(String description){
		terminals.add("$");
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
			firstslist.addAll(Arrays.asList(tmp).subList(1, tmp.length));
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
			String[] tmp = r.split(",");
			String key = tmp[0].charAt(0)+"";
			variables.add(key);
			rules.addAll(Arrays.asList(tmp).subList(1, tmp.length));
			ArrayList<String> list1 = new ArrayList<>(Arrays.asList(tmp).subList(1, tmp.length));
			h.put(key,list1);
		}
	}

	private String getStackString(Stack<String> s){
		StringBuilder result = new StringBuilder();
		Object[] a =  s.toArray();
		for(int i = a.length-1;i>=0;i--){
			Object t = a[i];
			if(t.equals("$"))
				continue;
			if(t.equals("e"))
				continue;
			result.append(t);
		}
		return result.toString();
	}

	/**
	 * Returns A string encoding a derivation is a comma-separated sequence of sentential forms each representing a step in the derivation..
	 * 
	 * @param input is the string to be parsed by the LL(1) CFG.
	 * @return returns a string encoding a left-most derivation.
	 */
	public String parse(String input) {
		input+="$";
		Stack<String> s = new Stack<>();
		s.push("$");
		s.push("S");
		String buffer ="";
		String output = "S,";
		int pointer = 0;
		boolean error=false;

		do{
			String key = s.peek()+input.charAt(pointer);
			if(key.equals("$$")){
				break;
			}
			if(s.peek().equals("e")){
				s.pop();
				continue;
			}

			if(s.peek().equals(input.charAt(pointer)+"")){
				buffer+=s.peek();
				s.pop();
				pointer++;
				continue;
			}

			if(!ptable.containsKey(key)){
				error=true;
				break;
			}

			String rule = ptable.get(key);
			s.pop();
			for(int i = rule.length()-1;i>=0;i--){
				s.push(rule.charAt(i)+"");
			}

			output+=buffer+getStackString(s)+",";

		} while(true);
		if(error){
			output+="ERROR,";
		}
		System.out.println(output.substring(0,output.length()-1));
		System.out.println("-------------------------------------------------------------------------------------- \n");
		return output.substring(0,output.length()-1);
	}


	public static void main(String []args){
		String ll1cfg1 = "S,zToS,n,e;T,zTo,No;N,n,e#S,z,n,e;T,z,no;N,n,e#S,$;T,o;N,o";
		LL1CFG c =new LL1CFG(ll1cfg1);
		String input1 = "zzooo";
		String input2 = "zzznoooon";
		c.parse(input2);



	}

}


