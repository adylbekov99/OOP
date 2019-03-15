
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int n, led = 0, len;
        String number;
        Scanner input = new Scanner(System.in);
        do {
            n = input.nextInt();
            for(int i = 0; i < n; i++){
                number = input.next();
                len = number.length();
                for(int j = 0; j < len; j++){
                    if(number.charAt(j) == '1') {
                        led += 2;
                    }
                    else if(number.charAt(j) == '2' || number.charAt(j) == '3' || number.charAt(j) == '5'){
                        led+=5;
                    }
                    else if(number.charAt(j) == '4'){
                        led += 4;
                    }
                    else if(number.charAt(j) == '0' || number.charAt(j) == '9' || number.charAt(j) == '6'){
                        led += 6;
                    }
                    else if(number.charAt(j) == '7'){
                        led += 3;
                    }
                    else if(number.charAt(j) == '8'){
                        led += 7;
                    }
                }
                System.out.printf("%d leds%n", led);
                led = 0;
            }
        } while(!(1 <= n && n <= 2000));

    }
}



