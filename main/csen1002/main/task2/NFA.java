package csen1002.main.task2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class NFA {

    HashMap<String, HashSet<String>> zeroTransitions, oneTransitions,   closure;
    HashSet<String> acceptStates;



    public NFA(String description) {

        System.out.println("-------------------Properties-------------------");
        String[] arr = description.split("#");
        zeroTransitions = createTransitions(arr[0]);
        System.out.println("Zero Transitions: "+zeroTransitions);
        oneTransitions = createTransitions(arr[1]);
        System.out.println("One Transitions: "+oneTransitions);
        closure = createTransitions(arr[2]);
        acceptStates = createAcceptStates(arr[3]);
        System.out.println("Accept States: "+acceptStates);
        EpsilonClosure();
        System.out.println("-----------------------------------------------------------------------------------");
    }


    public static HashSet<String> createAcceptStates(String s){
        HashSet<String> acceptStates=new HashSet<>();
        String [] states=s.split(",");
        Collections.addAll(acceptStates, states);
        return acceptStates;
    }

    public static HashMap<String, HashSet<String>> createTransitions(String s) {
        HashMap<String, HashSet<String>> set = new HashMap<>();
        String[] splited = s.split(";");
        String current;
        for (String value : splited) {
            String[] g = value.split(",");
            current = g[0];
            HashSet<String> newSet;
            if (set.containsKey(current)) {
                newSet = set.get(current);
            } else {
                newSet = new HashSet<>();
            }
            newSet.add(g[1] + "");
            set.put(current, newSet);
        }
        return set;
    }

    public void EpsilonClosure() {
        HashMap<String, HashSet<String>> oldClosure = closure;
        //System.out.println("Initial Closure: "+closure);
        boolean theEnd = false;
        while (!theEnd) {
            // loop over each hashmap element
            for (String state : closure.keySet()) {
                // loop over each element in the hashset and add their epsilon set if it exists to current
                @SuppressWarnings("unchecked")
                HashSet<String> newSet = (HashSet<String>) closure.get(state).clone();
                for (String elem : closure.get(state)) {
                    // if it exists in the epsilon closure
                    if (closure.containsKey(elem)) {
                        // add its set to the current set
                        HashSet<String> newAddition = closure.get(elem);
                        newSet.addAll(newAddition);
                    }
                }
                closure.put(state, newSet);
            }
            // check if new closure equal to the new one
            if (closure.equals(oldClosure))
                theEnd = true;
            else {
                oldClosure = closure;
            }

        }
        System.out.println("Epsilon Closure: " + closure);
    }


    public HashSet<String> getEpsilon(String s){
        HashSet<String>state= new HashSet<>();
        if(closure.containsKey(s)){
            state.addAll(closure.get(s));
        }else{
            state.add(s);
        }

        return state;
    }

    public boolean run(String input) {
        System.out.println("-------------------RUN----------------");
        // If i have the closure and I create the initial state I can start running
        HashSet<String> currentState= getEpsilon("0");
        currentState.add("0");
        System.out.print(currentState+" --> ");
        HashSet<String> newState,temp;
        for(int i=0;i<input.length();i++){
            newState = new HashSet<>();
            temp=new HashSet<>();
            if(input.charAt(i)=='0')
                // add zero transitions that each number in the state has
                for(String s : currentState){
                    if(zeroTransitions.containsKey(s)){
                        newState.addAll(zeroTransitions.get(s));
                    }

                }

            if(input.charAt(i)=='1')
                // add one transitions that each number in the state has
                for(String s : currentState)
                    if(oneTransitions.containsKey(s))
                        newState.addAll(oneTransitions.get(s));

            // add epsilon closure that each state can have
            while(true){
            for(String s: newState){
                temp.add(s);
                if(closure.containsKey(s))
                    temp.addAll(closure.get(s));
            }
                if(temp.equals(newState))
                    break;
                newState=temp;
                temp=new HashSet<>();
            }

            // now the new state has all needed numbers
            newState.addAll(temp);
            currentState=newState;
            System.out.print(currentState+" --> ");
        }

        System.out.println("END ");
        // It exits the loop when the input ends
        for(String s : currentState){
            if(acceptStates.contains(s)){
                System.out.println("ACCEPTED \n");
                return true;
            }

        }
        System.out.println("REJECTED \n");
        return false;
    }



    public static void main(String[] args) {

        NFA nfa1 = new NFA("1,2;4,5;8,9#3,4;6,7#0,1;0,3;2,1;2,3;5,6;5,8;7,10;9,10#10");
        String input1 ="10101010";
        nfa1.run(input1);

    }
}
