package 趋势科技笔试;

public class t2 {
    public static void main(String[] args) {
        String template = "%%FILENAME%VIRUSNAME%balabalabala%VIRUSNAME%FILENAME%";
        String[] keys = {"SENDER", "RCPTS", "SUBJECT", "FILENAME", "VIRUSNAME", "ACTION"};
        String[] values = {"abc@test.com", "test@company.com", "Test", "Myfile", "ICAN", "Delete"};
        t2 t = new t2();
        t.f(template, keys, values);
    }

    String f(String template, String[] keys, String[] values) {
        String res = "";
        for (int i = 0; i < template.length(); i++) {
            char ch = template.charAt(i);
            res += ch;
            if (ch == '%') {
                for (int j = 0; j < keys.length; j++) {
                    res = res.replaceAll("%" + keys[j] + "%", values[j]);
                }
            }
        }
        return res;
    }
}
