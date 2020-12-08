package laxer;

import java.util.LinkedList;
import java.util.List;
import java.io.*;

public class MyScanner {
    /**
     * 将文件按空格和换行符分开，结果存放在list中
     */
    public final List<String> list;

    public MyScanner(String fileName) {
        list = new LinkedList<>();

        try {
            Reader in = new InputStreamReader(new FileInputStream(fileName));
            char c;
            String word = "";
            while ((c = (char) in.read()) != (char) -1) {
                if (c != ' ' && c != '\n' && c != '\r') {
                    // 如果c不是空格或回车
                    word = word.concat(String.valueOf(c)); // word += c
                } else {
                    if (!word.isEmpty()) {
                        list.add(word);
                        word = "";
                    }
                }
            }
            list.add(word);

            in.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        MyScanner myScanner = new MyScanner("laxer/test.c");
        for (String item : myScanner.list) {
            System.out.println(item.toCharArray());
        }
    }
}
