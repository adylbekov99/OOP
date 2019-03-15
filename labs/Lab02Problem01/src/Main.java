import java.util.Scanner;

public class Main {

    private final static int DEFAULT_FIELD_WIDTH = 20;
    private final static int DEFAULT_FIELD_HEIGHT = 20;

    public static void main(String[] args) {
        Turtle turtle = new Turtle();
        Field field = new Field(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT);
        Scanner scanner = new Scanner(System.in);
        String line;

        boolean working = true;
        do {
            line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0].toLowerCase();
            switch(command) {
                case "penup":
                    turtle.putPenUp();
                    break;
                case "pendown":
                    turtle.putPenDown();
                    break;
                case "turnright":
                    turtle.turnRight();
                    break;
                case "turnleft":
                    turtle.turnLeft();
                    break;
                case "move":
                    if(parts.length >= 2) {
                        int steps = Integer.parseInt(parts[1]);
                        turtle.move(steps, field);
                    } else {
                        System.err.println("Please, specify the number of steps.");
                    }
                    break;
                case "print":
                    field.print(turtle);
                    break;
                case "exit":
                    working = false;
                    break;
                default:
                    System.err.println("Invalid command, please try again.");
                    break;
            }
        } while(working);

    }
}
