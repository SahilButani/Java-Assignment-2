import java.util.*;
public class VampireNumber{
    /*
     *This function returns the length of a number.
     */
    private static int length(long num){
        return Long.toString(num).length();
    }
    
    /*
     *This function checks if a number is vampire number of not and returns a boolean.
     */
    
    private static boolean checkVampireNumber(long vampire_number, long factor_1, long factor_2){
        if(Long.toString(factor_1).endsWith("0") && Long.toString(factor_2).endsWith("0")) return false;

        int vampire_number_length = length(vampire_number);
        if(length(facotr_1) != vampire_number_length / 2 || length(factor_2) != vampire_number_length / 2) return false;

        char[] factor_1_bytes = Long.toString(vampire_number).toCharArray();
        char[] factor_2_bytes = (Long.toString(factor_1) + Long.toString(factor_2)).toCharArray();

        Arrays.sort(factor_1_bytes);
        Arrays.sort(factor_2_bytes);
        return Arrays.equals(factor_1_bytes, factor_2_bytes);
    }
    /*
     *This function generates two factor of a number and then calls checkVampireNumber and if it's a vampire number
     *it is added to a treeset and printed.
     */ 
    public static void main(String[] args)
    {
        TreeSet<Long> vampire_set = new TreeSet<Long>();
        for (long i = 10; vampire_set.size() <= 100; i++) {
            if ((length(i) % 2) != 0) {
                i = i * 10 - 1;
                continue;
            }
            for (long factor_1 = 2; factor_1 <= Math.sqrt(i) + 1; factor_1++) {
                if (i % factor_1 == 0) {
                    long factor_2 = i / factor_1;
                    if (checkVampireNumber(i, factor_1, factor_2) && factor_1 <= factor_2) {
                        vampire_set.add(i);

                    }
                }
            }
        }
        for(long l:vampire_set){
            System.out.println(l);
        }
    }}
