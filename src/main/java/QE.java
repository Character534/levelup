
import java.util.Scanner;
import java.lang.Math;

/**
 * Created by Character on 19.02.2016.
 */


public class QE {
    public static void main(String[] args) {

        double a;
        double b;
        double c;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите коэффициенты:");
        System.out.print("A = ");
        a = scanner.nextDouble();
        System.out.print("B = ");
        b = scanner.nextDouble();
        System.out.print("C = ");
        c = scanner.nextDouble();

        double d = Math.pow(b, 2) - 4 * a * c;

        if (d < 0)
            System.out.println("Корней нет!");
        else if (d == 0) {
            System.out.println("x = " + (-b) / (2 * a));
        } else {
            System.out.println("x1 = " + (-b+Math.sqrt(d))/(2*a) + " x2 = " + (-b-Math.sqrt(d))/(2*a));
    }
    }


}
