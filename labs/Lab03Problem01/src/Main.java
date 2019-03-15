import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Rational a = new Rational(1, 2);
//        Rational b = new Rational(1, 2);
//        Rational result = a.add(b);
//        System.out.println(result);
        Scanner scanner = new Scanner(System.in);


        System.out.println("Calculator of Rational numbers");
        do {
            System.out.print("Enter 1st rational (Ctrl-Z: exit): ");
            if(!scanner.hasNext()) break;
            Rational a;
            try {
                a = Rational.parse(scanner.nextLine());
            } catch(Exception e) {
                System.err.println(e.getMessage());
                continue;
            }

            // TODO
            System.out.print("Enter operator: ");
            if(!scanner.hasNext()) break;
            String operator = scanner.nextLine();

            System.out.print("Enter 2nd rational (Ctrl-Z: exit): ");
            if(!scanner.hasNext()) break;
            Rational b;
            try {
                b = Rational.parse(scanner.nextLine());
            } catch(Exception e){
                System.err.println(e.getMessage());
                continue;
            }

            String result = "";
            switch (operator) {
                case "+":
                    result = a.add(b).toString();
                    break;
                case "-":
                    result = a.sub(b).toString();
                    break;
                case "*":
                    result = a.mul(b).toString();
                    break;
                case "/":
                    result = a.div(b).toString();
                    break;
                case "<":
                    result = String.valueOf(a.compareTo(b) < 0);
                    break;
                case ">":
                    result = String.valueOf(a.compareTo(b) > 0);
                    break;
                case "=":
                    result = String.valueOf(a.compareTo(b) == 0);
                    break;
                case "!=":
                    result = String.valueOf(a.compareTo(b) != 0);
                    break;
                case "<=":
                    result = String.valueOf(a.compareTo(b) <= 0);
                    break;
                case ">=":
                    result = String.valueOf(a.compareTo(b) >= 0);
                    break;
                default:
                    System.err.println("Incorrect operator: " + operator);
                    continue;
            }
            System.out.printf("Result: %s %s %s = %s%n", a, b, operator, result);
        } while(true);
    }
}
