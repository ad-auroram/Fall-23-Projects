import java.util.Scanner;
public class ISBN {
    public static void main(String[] args) {

        //get the ISBN
        Scanner getISBN = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN: ");
        int ISBN = getISBN.nextInt();
        //first number
        int d1 = ISBN/100000000;
        //find second number
        int n1 = (ISBN-(d1*100000000));
        int d2 = n1/10000000;
        //find third number
        int n2 = (n1-(d2*10000000));
        int d3 = n2/1000000;
        //find fourth number
        int n3 = (n2-(d3*1000000));
        int d4 = n3/100000;
        //fifth number
        int n4 = (n3-(d4*100000));
        int d5 = n4/10000;
        //sixth
        int n5 = (n4-(d5*10000));
        int d6 = n5/1000;
        //seventh
        int n6 = (n5-(d6*1000));
        int d7 = n6/100;
        //eighth
        int n7 = (n6-(d7*100));
        int d8 = n7/10;
        //ninth
        int d9 = (n7-(d8*10));

        //calculate tenth number
        System.out.print("The ISBN-10 number is: ");
        System.out.print(d1);
        System.out.print(d2);
        System.out.print(d3);
        System.out.print(d4);
        System.out.print(d5);
        System.out.print(d6);
        System.out.print(d7);
        System.out.print(d8);
        System.out.print(d9);
        int check = (d1+d2*2+d3*3+d4*4+d5*5+d6*6+d7*7+d8*8+d9*9)%11;
        if (check==10){
            String d10 = "X";
            System.out.println(d10);
        }else{
            System.out.println(check);
        }

    }
}