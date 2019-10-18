package models;

import java.util.Random;

public class Utils {


    /**
     * Generates a string by a given length of n
     * @param n
     * @return
     */
    public static String generateId(int n){
        String[] strings = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"
                ,"q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","10","A","B"
                ,"C","D","E","F","G","H","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        String id = "";

        for (int i = 0; i < n; i++) {
            id += strings[new Random().nextInt(strings.length-1)];
        }
        return id;
    }
}
