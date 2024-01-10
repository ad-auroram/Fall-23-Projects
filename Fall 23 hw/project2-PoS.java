import java.util.Scanner;

public class BasicPoS {
    public static void main(String[] args) {

        //set prices
        double apple = 1.00;
        double milk = 1.50;
        double bread = 2.20;

        double total = 0;
        double charity = 0;
        double discount = 0;
        Scanner buy = new Scanner(System.in);

        //menu
        System.out.println("Welcome to the PoS System!");
        System.out.println("-".repeat(50));
        System.out.printf("Apple - $%.2f", apple);
        System.out.printf("\nMilk  - $%.2f", milk);
        System.out.printf("\nBread - $%.2f",bread);
        System.out.println("\n...");

        //get user input
        System.out.print("Enter the number of apples you want to buy: ");
        int appleNum = buy.nextInt();
        System.out.print("Enter how many gallons of milk you want to buy: ");
        int milkNum = buy.nextInt();
        System.out.print("Enter how many loaves of bread you want to buy: ");
        int breadNum = buy.nextInt();

        //calculate total price
        total += (appleNum*apple)+(milkNum*milk)+(breadNum*bread);
        System.out.printf("Your total is $" +"%.2f. ",total);

        //charity
        double round = Math.ceil(total);
        double donate = round - total;
        System.out.printf("Would you like to round up %.2f to donate to the Java Programmers Club? (y/n): ", donate);
        String Ask = buy.next();
        if (Ask.equals("y")){
            charity += donate;
        }

        //buy 2 get 1
        if (appleNum/3>=0) {
            System.out.println("You're in luck! We're having a buy 2 get 1 free sale on apples!");
            discount += (apple*(appleNum/3));
        }else{
            System.out.println("\nWe're actually having a sale on apples if you want to grab more. No? Too bad then.");
        }

        //10% off $20 purchase
        if (total > 20){
            System.out.println("Lucky! We have a 10% discount for purchases above $20!");
            discount += (total*.1);
        }

        //custom discount
        if (appleNum+milkNum+breadNum>7) {
            System.out.println("Woah you had more than 7 items? 7's a cool number, I'll throw in another apple for you.");
            appleNum += 1;
        }
        //print receipt
        System.out.printf("%-10s %-10s %-10s %-10s \n","Item","Quantity  "," Price","Total");
        System.out.println("-".repeat(50));
        System.out.printf("%-10s %-10d  $%-10.2f $%-10.2f\n","Apples",appleNum, apple, (appleNum*apple));
        System.out.printf("%-10s %-10d  $%-10.2f $%-10.2f\n","Milk:", milkNum, milk, (milkNum*milk));
        System.out.printf("%-10s %-10d  $%-10.2f $%-10.2f\n","Bread:", breadNum, bread, (breadNum*bread));
        System.out.println("-".repeat(50));
        //totals
        System.out.printf("%-10s %10s $%-10.2f","Subtotal:", " ", total);
        System.out.printf("\n%-10s %10s $%-10.2f","Discount:","-", discount);
        System.out.printf("\n%-10s %10s $%-10.2f", "Donation:", "+", charity);
        System.out.printf("\n%-10s %10s $%-10.2f","Total"," ", (total-discount+charity));
    }
}