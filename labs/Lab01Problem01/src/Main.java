import java.util.Scanner;

public class Main {
    // Turtle Data

    final static char TURTLE = 'T';
    static int turtleX, turtleY;
    static int dx, dy;
    static boolean isPenDown;

    // Field data

    static final char MARKED_CELL = '*';
    final static char EMPTY_CELL = '.';
    final static int WIDTH = 20;
    final static int HEIGHT = 20;
    static char[][] field;

    // Turtle Methods

    public static void initTurtle() {
        turtleX = 0;
        turtleY = 0;
        dx = 1;
        dy = 0;
        isPenDown = false;
    }
    public static void putPenUp() {
        isPenDown = false;
    }

    public static void putPenDown() {
        isPenDown = true;
    }
    public static void turnRight() {
        int temp = dx;
        dx = dy;
        dy = temp;

        dx = -dx;
    }
    public static void turnLeft() {
        int temp = dx;
        dx = dy;
        dy = temp;

        dy = -dy;
    }

    public static void move(int steps){
        for(int i = 0; i < steps; i++){
            int nextX = turtleX + dx;
            int nextY = turtleY + dy;
            if(nextX < 0 || nextY < 0 || nextX >= WIDTH || nextY >= HEIGHT) {
                break;
            }

            if(isPenDown) {
                field[turtleY][turtleX] = MARKED_CELL;
            }

            turtleX = nextX;
            turtleY = nextY;
        }
    }

    // Field methods
    public static void initField() {
        field = new char[HEIGHT][WIDTH];
        for(int y = 0; y < HEIGHT; y++){
            for(int x = 0; x < WIDTH; x++){
                field[y][x] = EMPTY_CELL;
            }
        }
    }
    public static void printField() {
        for(int y = 0; y < HEIGHT; y++){
            for(int x = 0; x < WIDTH; x++){
                if(x == turtleX && y == turtleY){
                    System.out.print(TURTLE);
                }
                else {
                    System.out.print(field[y][x]);
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        initTurtle();
        initField();
        Scanner scanner = new Scanner(System.in);
        String line;

        boolean working = true;
        do {
            line = scanner.nextLine();
            String[] parts = line.split(" ");
            String command = parts[0].toLowerCase();
            switch(command) {
                case "penup":
                    putPenUp();
                    break;
                case "pendown":
                    putPenDown();
                    break;
                case "turnright":
                    turnRight();
                    break;
                case "turnleft":
                    turnLeft();
                    break;
                case "move":
                    if(parts.length >= 2) {
                        int steps = Integer.parseInt(parts[1]);
                        move(steps);
                    } else {
                        System.err.println("Please, specify the number of steps.");
                    }
                    break;
                case "print":
                    printField();
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
