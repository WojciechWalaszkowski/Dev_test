import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbersList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //Scanner sc = new Scanner("2 10 7 5 3 6 6 13 0");
        String [] inputNumbers = sc.nextLine().split(" ");

        for (String num:inputNumbers){
            numbersList.add(Integer.parseInt(num));
        }
        Collections.sort(numbersList);

        // Count occurrences of each number, up to 6 inclusive
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num:numbersList){
            if (num >= 7){
                break;
            }
            if (!occurrences.containsKey(num)) {
                occurrences.put(num, 0);
            }
            occurrences.put(num, occurrences.get(num) + 1);
        }

        List<Integer> distinctList;
        distinctList = numbersList.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);

        // Check the existence of pairs for above numbers
        for (int number = 0; distinctList.get(number) < 7; number++){
            if (distinctList.contains(13 - distinctList.get(number))) {
                for (int value = 0; value < occurrences.get(distinctList.get(number)); value++) {
                    System.out.println(distinctList.get(number) + " " + (13 - distinctList.get(number)));
                }
            }
        }
    }
}
