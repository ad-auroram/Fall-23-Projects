
import java.util.Scanner;
public class Quadratic {
    public static void main(String[] args) {
        //enter numbers here
        Scanner getNum = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double numA = getNum.nextDouble();
        double numB = getNum.nextDouble();
        double numC = getNum.nextDouble();
        //System.out.println(numA+" "+numB+" "+numC);

        //find the discriminant
        double dis= Math.pow(numB,2)-4*numA*numC;
        //System.out.println(dis);

        //find roots
        double r1 = ((0-numB)+Math.sqrt(dis))/2*numA;
        double r2 = ((0-numB)-Math.sqrt(dis))/2*numA;

        //return number of roots
        if (dis < 0){
            System.out.println("There are no roots for the quadratic equation with these coefficients.");
        } else if (dis > 0){
            System.out.println("There are two roots for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
        } else {
            System.out.println("There is one root for the quadratic equation with these coefficients.");
            System.out.println("r1 = " + r1);
        }
    }
}
