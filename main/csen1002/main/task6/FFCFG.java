package csen1002.main.task6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

import static java.lang.System.out;

/**
 * Write your info here
 * 
 * @name Bassel Amgad
 * @id 43-6927
 * @labNumber 08
 */

public class FFCFG {
	int k;
	ArrayList<String> variables,literals;
	Hashtable<String, ArrayList<String>> transitions;
	Hashtable<String, ArrayList<String>> first,follow;
	Hashtable<String, ArrayList<String>> transitionsClone;

	public FFCFG(String description) {
		first = new Hashtable<>();
		follow = new Hashtable<>();
		variables = new ArrayList<>();
		transitions = new Hashtable<>();
		literals = new ArrayList<>();
		transitionsClone = (Hashtable<String, ArrayList<String>>) transitions.clone();
		String[] lines = description.split(";");
		String[] splitter;
		ArrayList<String> set;
		for(String line : lines){
			splitter = line.split(",");
			variables.add(splitter[0]);
			set = new ArrayList<>(Arrays.asList(splitter).subList(1, splitter.length));
			transitions.put(splitter[0],set);

		}
		for(int i = 0; i<description.length();i++){
			if(Character.isLowerCase(description.charAt(i))){
				literals.add(description.charAt(i)+"");
			}
		}

		this.k = variables.size();
		out.println("Variables "+variables);
		out.println("Literals: "+literals);
		out.println("Transitions: "+transitions);
	}

	public String createFirstOutput(){
		return getString(first);
	}

	public String createFollowOutput(){
		return getString(follow);
	}

	private String getString(Hashtable<String, ArrayList<String>> follow) {
		StringBuilder output = new StringBuilder();
		for(int i = 0;i<k;i++){
			output.append(variables.get(i)).append(",");
			ArrayList<String> tmp = follow.get(variables.get(i));
			Collections.sort(tmp);
			boolean dollar=false;
			for(String s :tmp){
				if(s.equals("$"))
					dollar=true;
				else
					output.append(s);
			}
			if(dollar){
				output.append("$");
			}

			if(i!=k-1)
				output.append(";");
		}
		return output.toString();
	}

	public void addAllNoDup(ArrayList<String> list, ArrayList<String>list2){

		for(String s : list2){
			if(!list.contains(s)){
				list.add(s);
			}
		}


	}

	public boolean epsilonAll(String s,int index){
			for(int i = 0;i<index;i++){
				if(!first.get(s.charAt(i)+"").contains("e"))
					return false;
			}
		return true;
	}

	public boolean firstSubset(String v, String s){
		ArrayList<String> l = (ArrayList<String>) first.get(s).clone();
		l.remove("e");
		return !first.get(v).contains(l);
	}

	public boolean followSubset(String A,String B){
		ArrayList<String> l = follow.get(A);
		return follow.get(B).contains(l);
	}

	// it works and i have no idea how :)
	public String first() {
		// Creating first of all literals
		initialize(first);
		boolean change = true;
		Hashtable<String, ArrayList<String>> firstOld=new Hashtable<>();
		while(change){
			change = false;
			// Loop over Rules R
			for(String v : transitions.keySet()){
				ArrayList<String> trans= transitions.get(v);
				for(String rule:trans) {

					if (epsilonAll(rule, rule.length())) {
						if (!first.get(v).contains("e")) {
							ArrayList<String> tmp = first.get(v);
							tmp.add("e");
							first.put(v, tmp);
							change = true;
						}
					}

					for (int i = 0; i < rule.length(); i++) {
						if (epsilonAll(rule, i)) {
							if (firstSubset(v, rule.charAt(i) + "")) {
								ArrayList<String> tmp = (ArrayList<String>) first.get(rule.charAt(i) + "").clone();
								ArrayList<String> vList = first.get(v);
								tmp.remove("e");
								addAllNoDup(vList, tmp);
								change = true;
							}
						}
					}
				}
			}
			if(first.equals(firstOld))
				break;
			firstOld= (Hashtable<String, ArrayList<String>>) first.clone();
			first.put("hello",new ArrayList<>());

		}

		String output = createFirstOutput();
		out.println("First: "+ output);

		return output;
	}

	public boolean firstSubsetFollow(String B, String beta){
		ArrayList<String> l = (ArrayList<String>) first.get(beta).clone();
		l.remove("e");
		return follow.get(B).contains(l);

	}

	public boolean allBetaIsEpsilon(String beta){
		for(int i=0;i<beta.length();i++){
			if(!(first.get(beta.charAt(i)+"").contains("e"))){
				return false;
			}
		}
		return true;
	}
	public String follow() {
		// Initializing follow
		// of all variables
		first();
		for(String v: variables){
			ArrayList<String> x = new ArrayList<>();
			follow.put(v,x);
		}
		follow.get("S").add("$");
		first.put("e",new ArrayList<>());
		Hashtable<String, ArrayList<String>> transitionsClone = (Hashtable<String, ArrayList<String>>) transitions.clone();

		epsilonTransitions(transitionsClone);

		transitions = (Hashtable<String, ArrayList<String>>) transitionsClone.clone();
		boolean change = true;
		Hashtable<String, ArrayList<String>> followOld = new Hashtable<>();
		int c = 0;
		while(change){
			c++;
			change = false;
			for(String A : variables){
				ArrayList<String> trans = transitions.get(A);
				for(String rule : trans){
					// TODO: Loop over every variable :D
					int len=rule.length();
					String B,beta;
					for(int i =0;i<len;i++){
						if(Character.isUpperCase(rule.charAt(i))){
							B = rule.charAt(i)+"";
							if(i==len-1){
								beta = "e";
							}else {
								beta = rule.charAt(i + 1) + "";
							}
							if(!firstSubsetFollow(B, beta)){
								ArrayList<String> followB = follow.get(B );
								ArrayList<String> firstBeta = (ArrayList<String>) first.get(beta).clone();
								firstBeta.remove("e");
								addAllNoDup(followB, firstBeta);
								change = true;
							}

							if(allBetaIsEpsilon(rule.substring(i+1,len))||beta.equals("e")){
								if(!followSubset(A,B)){
									ArrayList<String> followB = follow.get(B);
									ArrayList<String> followA = follow.get(A);
									addAllNoDup(followB,followA);
									change = true;
								}
							}

						}
					}
				}
			}
			//out.println(follow);

			if(c==30)
				break;

			if(follow.equals(followOld))
				c=29;

			followOld= (Hashtable<String, ArrayList<String>>) follow.clone();
			follow.put("hello",new ArrayList<>());

		}

		String output = createFollowOutput();
		out.println("Follow: "+follow);
		return output;
	}

	private void epsilonTransitions(Hashtable<String, ArrayList<String>> transitionsClone) {
		for(String v : variables){
			ArrayList<String> t = transitions.get(v);
			for(String r:t){
				for(int i=0;i<r.length();i++){
					if(first.get(r.charAt(i)+"").contains("e")&&Character.isUpperCase(r.charAt(i))){
						ArrayList<String> tmp = (ArrayList<String>) transitionsClone.get(v).clone();
						transitionsClone.remove(v);
						tmp.add(r.replace(r.charAt(i)+"",""));
						transitionsClone.put(v,tmp);
					}
				}
			}
		}
		out.println("Epsilon Variables removed: "+ transitionsClone);
	}

	private void initialize(Hashtable<String, ArrayList<String>> follow) {
		for(String l:literals){
			ArrayList<String> x = new ArrayList<>();
			x.add(l);
			follow.put(l,x);
		}

		for(String v: variables){
			ArrayList<String> x = new ArrayList<>();
			follow.put(v,x);
		}
	}

	public static void main(String []args){
		FFCFG f1 = new FFCFG("S,ScT,T;T,aSb,iaLb,e;L,SdL,S");
		f1.follow();
	}

}
