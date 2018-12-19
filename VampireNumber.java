import java.util.*;
public class VampireNumber{
    private static int length(long num){
        return Long.toString(num).length();
    }

    private static boolean Check(long num, long num1, long num2){
        if(Long.toString(num1).endsWith("0") && Long.toString(num2).endsWith("0")) return false;

        int numLen = length(num);
        if(length(num1) != numLen / 2 || length(num2) != numLen / 2) return false;

        char[] numBytes = Long.toString(num).toCharArray();
        char[] num12Bytes = (Long.toString(num1) + Long.toString(num2)).toCharArray();

        Arrays.sort(numBytes);
        Arrays.sort(num12Bytes);
        return Arrays.equals(numBytes, num12Bytes);
    }

    public static void main(String[] args) {
        TreeSet<Long> vamps = new TreeSet<Long>();
        for (long i = 10; vamps.size() <= 100; i++) {
            if ((length(i) % 2) != 0) {
                i = i * 10 - 1;
                continue;
            }
            for (long num1 = 2; num1 <= Math.sqrt(i) + 1; num1++) {
                if (i % num1 == 0) {
                    long num2 = i / num1;
                    if (Check(i, num1, num2) && num1 <= num2) {
                        vamps.add(i);

                    }
                }
            }
        }
        for(long l:vamps){
            System.out.println(l);
        }
    }}