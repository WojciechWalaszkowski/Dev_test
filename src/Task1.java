import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        List<Integer> distinctList;
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner("1 10 20 20 2 5");
        String [] inputNumbers = sc.nextLine().split(" ");

        for (String num:inputNumbers){
            numbersList.add(Integer.parseInt(num));
        }

        // Distinct elements
        distinctList = numbersList.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);

        System.out.println(distinctList.stream().map(Object::toString).collect(Collectors.joining(" ")));
        System.out.println("count: " + numbersList.size());
        System.out.println("distinct: " + (long) distinctList.size());
        System.out.println("min: " + Collections.min(numbersList));
        System.out.println("max: " + Collections.max(numbersList));
    }
}
