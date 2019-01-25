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

/*
OUTPUT:
1260
1395
1435
1530
1827
2187
6880
102510
104260
105210
105264
105750
108135

110758
115672
116725
117067
118440
120600
123354
124483
125248
125433
125460
125500
126027
126846
129640
129775
131242
132430
133245
134725
135828
135837
136525
136948
140350
145314
146137
146952
150300
152608
152685
153436
156240
156289

156915
162976
163944
172822
173250
174370
175329
180225
180297
182250
182650
186624
190260
192150
193257
193945
197725
201852
205785
211896
213466
215860
216733
217638
218488
226498
226872
229648
233896
241564
245182
251896
253750
254740

260338
262984
263074
284598
284760
286416
296320
304717
312475
312975
315594
315900
319059
319536
326452
329346
329656
336550
336960
338296
*/
