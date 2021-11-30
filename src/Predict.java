import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Predict implements Command {
    @Override
    public String name(){
        return "predict";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter filepath");
        Scanner scanner1= new Scanner(System.in);
        String path = scanner1.next();
        String content;
        String[] contentTab;
        Path filechemin;
        filechemin = Paths.get(path);
        try{
            content = Files.readString(filechemin);
            contentTab = content.split(" ");
            for(String word : contentTab){
                if(!word.isBlank()){
                    System.out.println(""+word);
                }
            }
        }
        catch(IOException e){
            System.out.println("Unreadable file: ");
            e.printStackTrace();
        }
        return false;
    }
}