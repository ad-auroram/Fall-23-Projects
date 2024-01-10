import java.util.Scanner;
    public class Pyramid {
          public static void main(String[] args) {
              Scanner getNum = new Scanner(System.in);
              System.out.print("Enter a number of lines:");
              int lines = getNum.nextInt();
              for (int i = lines; i >=1; i--) {
                  for (int j = 1; j <= i * 2; j++) {
                      System.out.print(" ");
                  }
                  for (int j = i; j <= lines; j++){
                        if (j < 10) {
                            System.out.printf("%2d", j);
                        } else {
                             System.out.printf("%3d", j);
                  }
              }
                  for (int j = lines-1; j>=i; j--){
                      if (j < 10) {
                          System.out.printf("%2d", j);
                      } else {
                          System.out.printf("%3d", j);
                      }
                  }
                  System.out.println();

              }
          }
}
