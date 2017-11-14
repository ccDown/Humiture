package soul.listener.com.humiture.activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kuan
 *         Created on 2017/11/14.
 * @description
 */

public class Test {
    public static void main(String[] args){
        String testString = "qwertyuiopasdfghjklzxcvbnm";
        System.out.print(test(testString));
    }

    public static String test(String testString){
        List list = new ArrayList<Integer>();
        for (int i = 65;i<90;i++){
            list.add(i);
        }

        for (int i = 0 ; i<testString.length();i++){
            char charat = testString.charAt(i);
            if (charat>=65&&charat<=90){
                list.add(charat-65,0);
                list.remove(charat-65);
            }else if (charat>=97&&charat<=125){
                list.add(charat-97,0);
                list.remove(charat-97);
            }
        }

        for (int i = 0 ; i < list.size();i++){
            if ((Integer)list.get(i) == 0){
                return null;
            }
        }
        return testString;

    }
}
