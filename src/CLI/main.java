package CLI;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;


public class main {
    public static File ex(boolean parse, String cmd, Vector<String> arguments, File[] arr, File file) {

        Terminal terminal = new Terminal();
        if (parse) {

            if (cmd.equals("cat")) {
                terminal.cat(arguments.get(0), file.getAbsolutePath());
            } else if (cmd.equals("mv")) {
                terminal.mv(arguments.get(0), arguments.get(1));
            } else if (cmd.equals("cp")) {
                terminal.cp(arguments.get(0), arguments.get(1));
            } else if (cmd.equals("cd")) {
                File fx;
                if (arguments.size() == 0) {
                    fx = terminal.cd("Default", file);
                    return fx;
                } else {
                    fx = terminal.cd(arguments.get(0), file);
                }
                if (arguments.size() != 0) {
                    if (file.getAbsolutePath().equals(fx.getAbsolutePath()) && !(arguments.get(0).equals(file.getAbsolutePath()))) {
                        System.out.println("Path not found!");
                    } else {
                        return fx;
                    }
                }

            } else if (cmd.equals("pwd")) {
                try {
                    File f = terminal.pwd(file, arguments);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (cmd.equals("ls")) {
                try {
                    File f = new File(String.valueOf(terminal.ls(file, arguments)));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (cmd.equals("mkdir")) {
                System.out.println(terminal.mkdir(arguments.get(0), file));
            } else if (cmd.equals("clear")) {
                terminal.clear();
            } else if (cmd.equals("rm")) {
                if (arguments.size() == 1) {
                    terminal.rm(arr, arguments.get(0));
                }
            } else if (cmd.equals("date")) {
                terminal.date();
            } else if (cmd.equals("help")) {
                try {
                    File f = terminal.help(arguments);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (cmd.equals("rmdir")) {
                terminal.rmdir(arr, arguments.get(0));
            } else if (cmd.equals("more")) {
                terminal.more(arguments.get(0), file.getAbsolutePath());
            } else if (cmd.equals("args")) {
                try {
                    File f = terminal.args(arguments);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (cmd.equals("exit")){
                terminal.exit();
            }
            else {
                System.out.println("error");
                // rmdir all directories
                //rm all files


            }
        } else {
            System.out.println("error in parsing");
        }
        return file;

    }

    public static void main(String args[]) {
        //String defPath = "D:\\";

        Parser parser = new Parser();

        String cmd;
        Vector<String> arguments;
        boolean function;
        Scanner input = new Scanner(System.in);
        File file = new File("D:\\");
        Terminal terminal = new Terminal();
        Vector<String> files = new Vector<String>();
        files.add("D://lines.txt");
        while (true) {
            System.out.print("✔");
            File arr[] = file.listFiles();
            function = parser.parse(input.nextLine());
            cmd = parser.getCmd();
            arguments = parser.getArguments();
            if (arguments.size() >= 1) {
                if (arguments.get(0).equals("|")) {
                    if (parser.validate(cmd) && parser.validate(arguments.get(1))) {
                        file = ex(true, cmd, arguments, arr, file);
                        arr = file.listFiles();
                        file = ex(true, arguments.get(1), files, arr, file);


                    }
                }
            }

            file = ex(function, cmd, arguments, arr, file);


        }


    }

}

