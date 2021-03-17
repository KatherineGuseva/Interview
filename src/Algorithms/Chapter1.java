package Algorithms;

public class Chapter1 {


    public static boolean isUniquChars(String str){

        if (str.length() > 128) return false;

        boolean[] checkArray = new boolean[128];

        for (int i=0; i<str.length(); i++){
            int ch = str.charAt(i);
            if(checkArray[ch]) return false;
            checkArray[ch]=true;
        }
        return true;

    }

}
