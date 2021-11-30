
import java.util.Scanner;
import java.util.ArrayList;


public class Launcher {
    public static void main(String[] args) {

        Scanner var = new Scanner(System.in);
        boolean running = false;
        ArrayList<Command> CommandList = new ArrayList<>();
        CommandList.add(new Quit());
        CommandList.add(new Fibo());
        CommandList.add(new Freq());
        CommandList.add(new Predict());
        int index =-1;
        System.out.println("Welcome !");
        while(!running){
            String Svar = var.next();
            for(int i = 0; i < CommandList.size(); i++){
                if(Svar.equals(CommandList.get(i).name())){
                    index=i;
                }
            }
            if(index == -1){
                System.out.println("Unknown command");
            }
            else {
                running = CommandList.get(index).run(var);
            }
        }
    }
}