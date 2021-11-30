import java.util.Scanner;

public class Fibo implements Command {
    @Override
    public String name(){
        return "fibo";
    }
    @Override
    public boolean run(Scanner scanner) {
        int nbr, nbr1 = 0, nbr2 = 1, nbr3=0;
        scanner = new Scanner(System.in);
        nbr = scanner.nextInt();
        for (int i = 2; i < nbr+1; i++) {
            nbr3 = nbr1 + nbr2;
            nbr1 = nbr2;
            nbr2 = nbr3;
        }
        System.out.println("" + nbr3);
        nbr1 = 0;
        nbr2 = 1;
        //Src algo fibo : https://waytolearnx.com/2018/11/lalgorithme-de-fibonacci-en-java.html
        return false;
    }
}