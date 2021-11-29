import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !");
        Scanner var = new Scanner(System.in);
        String Svar = var.next();
        int nbr1 = 0, nbr2 = 1, nbr3=0, i, nbr;
        while (!Svar.equals("quit")) {
            if (Svar.equals("fibo")) {
                nbr = var.nextInt();
                for (i = 2; i < nbr+1; i++) {
                    nbr3 = nbr1 + nbr2;
                    nbr1 = nbr2;
                    nbr2 = nbr3;
                }
                System.out.println("" + nbr3);
            } else {
                System.out.println("Unknown command");
            }
            Svar = var.next();
        }
    }
}