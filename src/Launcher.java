import java.util.Scanner;

public class Launcher {
    public static void main (String[] args){
        System.out.println("Welcome !");
        Scanner var = new Scanner(System.in);
        String Svar = var.next();
        if (Svar.equals("quit")){
            return;
        }
        else{
            System.out.println("Unknown command");
            return;
        }
    }
}