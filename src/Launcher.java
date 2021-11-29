import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.nio.file.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !");
        Scanner var = new Scanner(System.in);
        String Svar = var.next();
        String path, content;
        String[] contentTab;
        Path filechemin;
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
                nbr1 = 0;
                nbr2 = 1;
                //Src algo fibo : https://waytolearnx.com/2018/11/lalgorithme-de-fibonacci-en-java.html
            }
            if(Svar.equals("freq")){
                path = var.next();
                filechemin = Paths.get(path);
                try{
                    content = Files.readString(filechemin);
                    content = content.replaceAll("\\.", " ");
                    content = content.replaceAll("\\?", " ");
                    content = content.replaceAll("\\!", " ");
                    content = content.replaceAll("\\:", " ");
                    content = content.replaceAll("\\;", " ");
                    content = content.replaceAll("\\,", " ");
                    content = content.replaceAll("\\'", " ");
                    content = content.replaceAll("\n", " ");
                    content = content.toLowerCase(Locale.ROOT);
                    contentTab = content.split(" ");
                    for(String word : contentTab){
                        if(word.isBlank()) {
                            word = null;
                        }
                        System.out.println(word);
                    }
                    //System.out.println(content);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Unknown command");
            }
            Svar = var.next();
        }
    }
}