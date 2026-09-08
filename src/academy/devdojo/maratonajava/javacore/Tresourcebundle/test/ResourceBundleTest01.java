package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        ResourceBundle messages = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(messages.getString("good.night"));

        ResourceBundle messages_enUS = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(messages_enUS.getString("good.night"));
        System.out.println(messages_enUS.getString("hi"));
        System.out.println(messages.getString("hi"));
    }
}
