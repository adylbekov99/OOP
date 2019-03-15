public class Turtle {
    // state
    final static char TURTLE_CELL = 'T';

    private int x, y;
    private int dx, dy;
    private boolean isPenDown;

    // behavior
    Turtle() {
        x = 0;
        y = 0;
        dx = 1;
        dy = 0;
        isPenDown = false;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void putPenUp() {
        isPenDown = false;
    }

    void putPenDown() {
        isPenDown = true;
    }
    void turnRight() {
        int temp = dx;
        dx = dy;
        dy = temp;

        dx = -dx;
    }
    void turnLeft() {
        int temp = dx;
        dx = dy;
        dy = temp;

        dy = -dy;
    }

    void move(int steps, Field field){
        for(int i = 0; i < steps; i++){
            int nextX = x + dx;
            int nextY = y + dy;
            if(nextX < 0 || nextY < 0 || nextX >= field.getWidth() || nextY >= field.getHeight()) {
                break;
            }

            if(isPenDown) {
                field.mark(x, y);
            }

            x = nextX;
            y = nextY;
        }

    }
}
