
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayListInt numbers = new ArrayListInt();

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

        System.out.println("After insertion: ");
        insertZeroBeforeEvenNumbers(numbers);
        printNumbers(numbers);


        System.out.println("After removal: ");
        removeOddNumbers(numbers);
        printNumbers(numbers);

    }

    private static void reverseNumbers(ArrayListInt numbers) {
        for(int i = 0, j = numbers.size() - 1; i < j; ++i, --j){
            int temp = numbers.get(i);
            numbers.set(i, numbers.get(j));
            numbers.set(j, temp);
        }
    }

    private static void insertZeroBeforeEvenNumbers(ArrayListInt numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                numbers.add(i, 0);
                ++i;
            }
        }
    }

    private static void removeOddNumbers(ArrayListInt numbers) {
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 != 0){
                numbers.remove(i);
                --i;
            }
        }
    }

    private static void printNumbers(ArrayListInt numbers) {
        for (int i = 0; i < numbers.size(); ++i) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }

}
