package laxer;

import java.util.LinkedList;
import java.util.List;

public class Lexer {
    public List<AbstractTocken> results = new LinkedList<>();

    static public boolean isInSameSet(char a, char b) {
        /**
         * @param a,b 待比较的字符
         * @return ab是否是同一个类型，分隔符算作不同的类型
         */ 
        if (Delimit.delimit_set.contains(a) || Delimit.delimit_set.contains(b)) {
            return false;
        }
        if (Character.isDigit(a) && Character.isDigit(b)) {
            return true;
        }
        if (Operator.operator_set.contains(a) && Operator.operator_set.contains(b)) {
            return true;
        }
        if (Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
            return true;
        }

        return false;
    }

    public Lexer(String fileName) {
        List<String> wordList = new MyScanner(fileName).list;
        for (String word : wordList) {
            int leftPtr = 0;
            String subStr = "";
            char[] arr = (word + '\0').toCharArray(); // 增加一个字符便于判断
            for (int rightPtr = 0; rightPtr < arr.length; ++rightPtr) {
                if (rightPtr != leftPtr && !isInSameSet(arr[rightPtr], arr[leftPtr])) {
                    subStr = word.substring(leftPtr, rightPtr);
                    leftPtr = rightPtr;
                    results.add(AbstractTocken.create(subStr));
                }
            }

        }
    }

    public static void main(String[] args) {
        Lexer l = new Lexer("./laxer/test.c");
        System.out.println(l.results);
    }
}
