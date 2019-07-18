package greedyAlgorithm;

import java.util.*;

/**
 * @author Komratov-VA
 * @ created 17.07.2019
 * Задача на программирование: непрерывный рюкзак
 *
 * Первая строка содержит количество предметов 1≤n≤103 и вместимость рюкзака 0≤W≤2⋅106.
 * Каждая из следующих n строк задаёт стоимость 0≤ci≤2⋅106 и объём 0<wi≤2⋅106 предмета (n, W, ci, wi — целые числа).
 * Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся),
 * помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
 */
public class zni4_1_2
{
    public static void main(String[] args)
    {
        Comparator comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2)
            {
                String[] strs1 = s1.split(",");
                String[] strs2 = s2.split(",");

                if( (Double.valueOf(strs1[2])-Double.valueOf(strs2[2])) !=0)
                    if((Double.valueOf(strs2[2])-Double.valueOf(strs1[2]))> 0)
                    return 1;
                    else
                        return -1;
                return Integer.valueOf(strs2[1])-Integer.valueOf(strs1[1]);
            }
        };
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int capacity = scanner.nextInt();
        int cost,size =0;
        double rez=0;
        for(int i =0;i<number;i++){
            cost = scanner.nextInt();
            size = scanner.nextInt();
            rez = Double.valueOf(String.valueOf(cost)) / Double.valueOf(String.valueOf(size));
           list.add(cost+","+size+","+rez);
        }
        Collections.sort(list,comp);
        System.out.println(list);
        double answer=0;
    for (int i=0;i<list.size();i++){
    String[] strs1 = list.get(i).split(",");
    if(Integer.valueOf(strs1[1]) <=capacity && capacity !=0){
            answer +=Integer.valueOf(strs1[0]);
            capacity -=Integer.valueOf(strs1[1]);
    }else if(capacity ==0){
        break;
    }else{
        answer+= Double.valueOf(strs1[2]) *capacity;
        capacity =0;
    }

    }

        System.out.printf("%.3f%n",answer);

    }

}
//5 9022
//3316 1601
//5375 8940
//2852 6912
//3336 9926
//1717 8427
//answers = 7777.731