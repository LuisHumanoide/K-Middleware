/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.FileUtils;

/**
 *
 * @author Laptop
 */
public class test {

    public static void main(String args[]) {
        String route = "src/middlewareEjemplo/";
        String a = FileUtils.readFile(new File(route + "config/AreaNames.java"));
        //System.out.println(matches("number a", a));
        System.out.println(replace(a, "@insertNumber", "Area2"));
    }

    private static int matches(String keyword, String text) {
        int matches = 0;
        Matcher matcher = Pattern.compile(keyword, Pattern.CASE_INSENSITIVE).matcher(text);
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    static String replace(String text, String key, String areaName) {
        int m = matches(key, text);
        int t = matches("\"" + areaName + "\"", text);
        System.out.println(" m: "+m+" , t:"+t);
        for (int i = t-m; i < t; i++) {
            text = text.replaceFirst(key, "" + (i));
        }
        return text;
    }

    /*static void rewriteAreaNames(String areaName) {
        String newAreaNames = replace(AreaNames, "@insertNumber", areaName);
        FileUtils.write(route + "config/AreaNames", newAreaNames, "java");
        readConfigs();
    }*/

}
