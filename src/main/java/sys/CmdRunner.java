package sys;

import bin.*;
import sys.bin.*;

import java.util.Arrays;

import static org.fusesource.jansi.Ansi.ansi;

public class CmdRunner {
    public static void run(String[] cmd) {
        String[] args = cmd.length >= 2 ? Arrays.copyOfRange(cmd, 1, cmd.length) : new String[] {""};

        try {
            switch (cmd[0]) {
                // 程序
                case "time" -> new Time();
                case "calc" -> new Calc();

                // 系统操作
                case "help" -> new Help(args);
                case "ls" -> new Ls(args);
                case "clear" -> Utils.clear();
                case "version" -> new Version();
                case "exit", "shutdown" -> System.exit(0);
                case "restart" -> new DumpOS();
                default -> throw new IllegalArgumentException("Unknown command: " + cmd[0]);
            }
        } catch (Exception e) {
            System.err.println("Error: " + ansi().fgRed().a(e.getMessage()).reset());
        }
    }
}
