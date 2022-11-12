package CLI;

import java.util.ArrayList;
import java.util.Vector;

public class Parser {

    private String cmd;
    private ArrayList<String> LOC = new ArrayList<String>();
    private ArrayList<Integer> LOCpar = new ArrayList<Integer>();
    private int counter;
    private Vector<String> args;

    Parser() {

        cmd = null;
        args = new Vector<String>();
/*
        LOCpar.add(1);
        LOCpar.add(0);
        LOCpar.add(2);
        LOCpar.add(1);
        LOCpar.add(1);
        LOCpar.add(1);
        LOCpar.add(1);
        LOCpar.add(2);
        LOCpar.add(1);
        LOCpar.add(0);
        LOCpar.add(0);
        LOCpar.add(0);
        LOCpar.add(0);
        LOCpar.add(0);
  */
        LOC.add("cd");
        LOC.add("ls");
        LOC.add("cp");
        LOC.add("cat");
        LOC.add("more");
        LOC.add("mkdir");
        LOC.add("rmdir");
        LOC.add("mv");
        LOC.add("rm");
        LOC.add("args");
        LOC.add("date");
        LOC.add("help");
        LOC.add("pwd");
        LOC.add("clear");
        LOC.add("exit");
    }


    public boolean validate(String cmd) {
        if (LOC.contains(cmd))
            return true;
        else
            return false;
    }

    public boolean parse(String input) {
        String[] Substrings = input.split(" ");
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i < args.size(); i++) {
            args.clear();
        }

        for (int i = 0; i < Substrings.length; i++) {
            if (Substrings[i].contains(" ")) {
                return false;
            }
        }
        //for(int i=0;i<LOC.size();i++){
        //  if(Substrings[0].equals(LOC.get(i))){
        //    idx=i;
        //}
        //}

        //if(LOCpar.get(idx)==(Substrings.length-1))
        //  flag= true;

        // if(flag==true){


        if (Substrings.length > 1) {
            for (int i = 0; i < Substrings.length - 1; i++) {
                args.add(Substrings[i + 1]);

            }

        }
        if (validate(Substrings[0])) {
            this.cmd = Substrings[0];
            return true;
        } else {
            return false;
        }
    }
    //  else
    //{
    //  return false;
    //}

    //}

    public String getCmd() {
        return cmd;
    }

    public Vector<String> getArguments() {
        return args;
    }
}

