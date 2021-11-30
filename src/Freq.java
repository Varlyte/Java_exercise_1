import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Freq implements Command {

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        Scanner scanner1= new Scanner(System.in);
        String path = scanner1.next();
        String content;
        String[] contentTab;
        int pass=0, max=0;
        ArrayList<String> treatedElem = new ArrayList<String>();
        int[] wordLenght = new int[100];
        Path filechemin;
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
        return false;
    }
}