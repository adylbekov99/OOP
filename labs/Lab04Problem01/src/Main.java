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

        System.out.println("Before reversing: ");
        printNumbers(numbers);

        // TODO reverse
        reverseNumbers(numbers);

        System.out.println("After reversing");
        printNumbers(numbers);

    }

    private static void reverseNumbers(ArrayList<Integer> numbers) {
        for(int i = 0, j = numbers.size() - 1; i < j; ++i, --j){
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, temp);
        }
    }

    private static void printNumbers(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
