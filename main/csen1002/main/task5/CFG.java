package csen1002.main.task5;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import static java.lang.System.*;


/**
 * Write your info here
 *
 * @name Bassel Amgad
 * @id 43-6927
 * @labNumber 08
 *
 */
public class CFG {

	ArrayList<String> variables;
	Hashtable<String, ArrayList<String>> transitions;
	public CFG(String description) {
		variables = new ArrayList<>();
		transitions = new Hashtable<>();
		String[] lines = description.split(";");
		String[] splitter;
		ArrayList<String> set;
		/* Put our variables in the array list and
		 * their transitions in the hashtable
		 */
		for(String line : lines){
			splitter = line.split(",");
			variables.add(splitter[0]);
			set = new ArrayList<>(Arrays.asList(splitter).subList(1, splitter.length));
			transitions.put(splitter[0],set);

		}

		out.println("Non-Terminals: "+variables);
		out.println("Old-Transitions: "+transitions);

	}

	public void immediateLeftRecursionRemoval(int x){
		String a = variables.get(x);
		String aDash=a+"'";
		ArrayList<String> goesTo = transitions.get(a);
		ArrayList<String> new1 = new ArrayList<>(),new2 = new ArrayList<>();

		for(String s : goesTo){
			 // first variable is equal to original variable
			final boolean equals = a.equals(s.charAt(0) + "");
			if(equals){
				new2.add(s.substring(1)+aDash);
			}

			// its recursive but needs first variable not equal to original
			if(!equals){
				new1.add(s +aDash);
			}

			// If there is a new transition
			if(!new2.isEmpty()){
				transitions.put(a,new1);
				transitions.put(aDash,new2);
			}
			}

	}

	public String transitionsString(String s){
		StringBuilder output= new StringBuilder();
		output.append(s);
		ArrayList<String> goesTo = transitions.get(s);
		for(String t : goesTo){
			output.append(",").append(t);
		}
		if(s.contains("'"))
			output.append(",").append("e");
		output.append(";");
		return output.toString();
	}

	public String outputBuilder(){
		StringBuilder output= new StringBuilder();
		String sDash;
		for(String s : variables){
			output.append(transitionsString(s));
			sDash = s+"'";
			if(transitions.containsKey(sDash)){
				output.append(transitionsString(sDash));
			}
		}

		output.deleteCharAt(output.length() - 1);
		return output.toString();
	}

	// law eshtaghalet ha3yat :`)
	public ArrayList<String> spaghetti(String s,String j,ArrayList<String> t){
		ArrayList<String> result = new ArrayList<>();
		int index=-1;
		for(int i =0 ;i<s.length();i++){
			if(j.equals(s.charAt(i)+"")){
				index = i;
				break;
			}
		}

		if(index==0){
			for(String tx: t){
				result.add(tx+s.substring(1));
			}
		}
		if(index==s.length()-1){
			for(String tx: t){
				result.add(s.substring(0,index)+tx);
			}
		}
		if(index>0&&index<s.length()-1){
			for(String tx: t){
				result.add(s.substring(0,index)+tx+s.substring(index+1));
			}
		}
		return result;
	}

	public void substitute(int a , int b){
		String va = variables.get(a);
		String vb= variables.get(b);
		ArrayList<String> new1 = new ArrayList<>();
		@SuppressWarnings("unchecked")
		ArrayList<String> itrans = (ArrayList<String>) transitions.get(va).clone();
		ArrayList<String> jtrans = transitions.get(vb);
		for(String s: itrans){
				if(vb.equals(s.charAt(0)+"")){
					new1.addAll(spaghetti(s,vb,jtrans));
				}
				else{

					new1.add(s);
				}
		}
		transitions.put(va,new1);




	}

	public static ArrayList<String> removeDuplicates(ArrayList<String> arr){

		ArrayList<String> result = new ArrayList<>();
		for(String s : arr){
			if(!result.contains(s))
				result.add(s);
		}
		return result;

	}

	public String lre() {
		for (int i = 0;i<variables.size();i++){
			for(int j = 0;j<i;j++){
				substitute(i,j);
			}
			immediateLeftRecursionRemoval(i);
		}
		transitions.replaceAll((s, v) -> removeDuplicates(v));
		out.println("New-Transitions: "+transitions);
		String result =outputBuilder();
		out.println("NEW CFG: "+result);
		return result;
	}

	public static void main(String[]args){
		CFG cfg3=new CFG("S,ScT,Sa,T,b;T,aSb,iaLb,i;L,SdL,S");
		out.println(cfg3.lre());
	}

}
