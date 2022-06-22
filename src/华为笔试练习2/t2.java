package 华为笔试练习2;

import java.util.*;

public class t2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Log, Integer> map = new HashMap<>();
        int idx = 0;
        while (sc.hasNextLine()) {
            String[] in = sc.nextLine().split(" ");
            String[] name = in[0].split("\\\\");
            String filename = name[name.length - 1];
            int line = Integer.parseInt(in[1]);
            Log log = new Log(filename, line, idx);
            idx++;
            map.put(log, map.getOrDefault(log, 0) + 1);
        }
        ArrayList<Map.Entry<Log, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Log, Integer>>() {
            @Override
            public int compare(Map.Entry<Log, Integer> o1, Map.Entry<Log, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    if (o1.getKey().idx < o2.getKey().idx) {
                        return -1;
                    } else if (o1.getKey().idx > o2.getKey().idx) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        for (int i = 0; i < list.size() && i < 8; i++) {
            Log log = list.get(i).getKey();
            String s = log.shortname + " " + String.valueOf(log.line) + " " + String.valueOf(list.get(i).getValue());
            System.out.println(s);
        }
    }
}

class Log {
    String filename;
    int line;
    int idx;
    String shortname;

    public Log(String filename, int line, int idx) {
        this.filename = filename;
        this.line = line;
        this.idx = idx;
        if (filename.length() > 16) {
            shortname = filename.substring(filename.length() - 16);
        } else {
            shortname = filename;
        }
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