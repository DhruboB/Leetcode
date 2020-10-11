package leetcode.medium.string;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        while(i>=0 || j>=0){
            int c1=0;
            while(i>=0 && (c1>0 || S.charAt(i)=='#')){
                if(S.charAt(i)=='#'){
                    c1++;
                }else{
                    c1--;
                }
                i--;
            }
            int c2=0;
            while(j>=0 && (c2>0 || T.charAt(j)=='#')){
                if(T.charAt(j)=='#'){
                    c2++;
                }else{
                    c2--;
                }
                j--;
            }
            if(i>=0 && j>=0){
                if(S.charAt(i)!=T.charAt(j)){
                    return false;
                }else{
                    i--;
                    j--;
                }
            }else{
                if(i>=0 || j>=0){
                    return false;
                }
            }
        }
        return i<0 && j<0;
    }

    public static void main(String... args){
        String S = "ab##f";
        String T = "c#d#";
//        String S = "a#c";
//        String T = "b###d#c";
        System.out.println(backspaceCompare(S,T));
    }
}
