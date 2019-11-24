package models;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    public static String input(String msg){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        do{
            System.out.print(msg + ": ");
            try{
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("invalid input");
                e.printStackTrace();
            }
        }while (input == null);

        return input.trim();
    }

    public static String input(String msg, String regex){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        do{
            System.out.print(msg + ": ");
            try{
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("invalid input");
                e.printStackTrace();
            }
        }while (input == null || !input.matches(regex));

        return input.trim();
    }

    public static String input(String msg, Object ...args){

        List<String> argsList = Arrays.asList(args).stream().map(arg->arg.toString().toLowerCase()).collect(Collectors.toList());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        do{
            System.out.print(msg + ": ");
            try{
                input = br.readLine();
            } catch (IOException e) {
                System.out.println("invalid input");
                e.printStackTrace();
            }
        }while (input == null || !argsList.contains(input));

        return input.trim();
    }

    public static void pause(){
        input("Press enter to continue");
    }

    public static List<String> readFileLines(File file){

        try {
            List<String> names = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null){
                names.add(line);
                line = br.readLine();
            }
            return names;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
