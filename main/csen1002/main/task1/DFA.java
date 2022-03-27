package csen1002.main.task1;


public class DFA {

    String[] transition;

    String[] Goal;
    /**
     * DFA constructor
     *
     * @param description is the string describing a DFA
     */
    public DFA(String description) {
        String[] s1 = description.split("#");
        transition= s1[0].split(";");
        Goal=s1[1].split(",");
    }

    /**
     * Returns true if the string is accepted by the DFA and false otherwise.
     *
     * @param input is the string to check by the DFA.
     * @return if the string is accepted or not.
     */
    public boolean run(String input) {
        String currentState="0";
        // Traverse sequence and move through csen1002.main.task1.DFA
        for(int i =0;i<input.length();i++)
            currentState = transition[Integer.parseInt(currentState)].charAt(input.charAt(i) == '0' ? 2 : 4) + "";

        // Check if the final state is a goal
        for (String s : Goal)
            if (s.equals(currentState))
                return true;
        return false;
    }

    public static void main(String []args){
        String d1 ="0,0,1;1,2,1;2,0,3;3,3,3#1,3";
        DFA dfa1=new DFA(d1);
        System.out.println(dfa1.run("100010010"));
    }
}
