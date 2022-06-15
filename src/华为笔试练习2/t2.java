package 华为笔试练习2;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Log, Integer> map = new HashMap<>();
        while (sc.hasNextLine()) {
            String[] logstring = sc.nextLine().split(" ");
            String[] name = logstring[0].split("\\\\");
            String filename = name[name.length - 1];
            int line = Integer.parseInt(logstring[1]);
            Log log = new Log(filename, line);
            map.put(log, map.getOrDefault(log, 0) + 1);
        }
    }

}

class Log {
    String filename;
    String shortname;
    int line;

    public Log(String filename, int line) {
        this.filename = filename;
        this.line = line;
        shortname = filename.substring(filename.length() - 16);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Log log = (Log) o;
        return line == log.line && Objects.equals(filename, log.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, line);
    }
}