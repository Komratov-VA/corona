package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Komratov-VA
 * @ created 18.07.2019
 * Задача на программирование: различные слагаемые
 * По данному числу 1≤n≤109 найдите максимальное число k,
 * для которого n можно представить как сумму k различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.
 */
public class zni4_1_3
{
    public static void main(String[] args)
    {
        Scanner scanner =  new Scanner(System.in);
        int number = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int i=1;
        while (number !=0){
            if(number>i && number-i<i+1){
                i++;
            }else
            {
                list.add(i);
                number -= i;
                i++;
            }

        }
        System.out.println(list.size());
        StringBuilder str = new StringBuilder();
        for (Integer t:list
             )
        {
            str.append(t+" ");
        }
        System.out.println(str.toString().trim());
    }
}
