package greedyAlgorithm;

import java.security.KeyStore;
import java.util.*;

/**
 * @author Komratov-VA
 * @ created 12.07.2019
 * Задача на программирование: покрыть отрезки точками
 *
 * По данным n отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит хотя бы одну из точек.
 *
 * В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк содержит по два числа 0≤l≤r≤109, задающих начало и конец отрезка.
 * Выведите оптимальное число m точек и сами m точек. Если таких множеств точек несколько, выведите любое из них.
 */
public class zni4_1
{

    public static void main(String[] args)
    {
        Comparator<point> comparator2 = new Comparator<point>(){public int compare(point o1, point o2) {

            if(o1.getB() != o2.getB())
                return o1.getB() - o2.getB();
            return o1.getA() - o2.getA();
        }};
        Scanner scanner = new Scanner(System.in);
        Set<point> set = new TreeSet<>(comparator2);
        int per=0;
        int koll = scanner.nextInt();
        for (int i=0;i<koll;i++){

            set.add(new point(scanner.nextInt(),scanner.nextInt()));


        }

        int rez;
        String str ="";
        Iterator<point> iterator = set.iterator();
        ArrayList<point> list = new ArrayList<>(set);
        int y=list.get(0).getB();

       for (int i=1;i<list.size();i++){
           if(y>=list.get(i).getA()){
               list.remove(i);
               i--;
                          }
           else {
               y=list.get(i).getB();
           }
       }
        System.out.println(list.size());

        for (point o: list
        )
        {
            str+=o.getB();
        }
        System.out.println(str.trim());
    }

}
class point{
    public int getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    private   int a;
    private   int b;
    public point(int a,int b){
        this.a = a;
        this.b = b;
    }
}