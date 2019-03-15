import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        while(scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        System.out.println("After insertion: ");
        insertZeroBeforeEvenNumbers(numbers);
        printNumbers(numbers);


        System.out.println("After removal: ");
        removeOddNumbers(numbers);
        printNumbers(numbers);

    }


    private static void insertZeroBeforeEvenNumbers(ArrayList<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                numbers.add(i, 0);
                ++i;
            }
        }
    }

    private static void removeOddNumbers(ArrayList<Integer> numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 != 0){
                numbers.remove(i);
                --i;
            }
        }
    }

    private static void printNumbers(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
