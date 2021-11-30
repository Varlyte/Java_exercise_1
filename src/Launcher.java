import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.nio.file.*;
import java.util.stream.Stream;
import java.util.ArrayList;


public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !");
        Scanner var = new Scanner(System.in);
        String Svar = var.next();
        String path, content;
        String[] contentTab;
        ArrayList<String> treatedElem = new ArrayList<String>();
        Path filechemin;
        int[] wordLenght = new int[100];

        int nbr1 = 0, nbr2 = 1, nbr3=0, i, nbr, pass=0, max=0;
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
                    int cpt, indice=0;
                    for(String word : contentTab) {
                        if (!word.isBlank()) {
                            //if word not in arraylist treatedElem
                            if(!treatedElem.contains(content)){
                                cpt=0;
                                for(int c=0; c< contentTab.length; c++){
                                    if(contentTab.equals(contentTab[c])){
                                        cpt+=1;
                                    }
                                }
                                wordLenght[indice] = cpt;
                                treatedElem.add(word);
                                for(int k=0; k<wordLenght.length; k++){
                                    if(max < wordLenght[k]){
                                        max=wordLenght[k];
                                        pass=k;
                                    }
                                }
                            }
                        }
                        indice+=1;
                    }
                    System.out.println("le mot le plus utilise est "+contentTab[pass]);
                    //N'affiche que le premier mot, je ne comprends pas pourquoi : mes compteurs sont bien incrémenter
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