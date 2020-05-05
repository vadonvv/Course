package ru.vvv.readJava;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;

public class JavaReader {
    private StringBuilder code = new StringBuilder();
    private HashSet<String> allKeyWords = new HashSet<>(Arrays.asList("abstract","assert","boolean","break","byte","case","catch","char","class","const","continue","default","double","do","else","enum","extends","final","finally","float","for","goto","if","implements","import","instanceof","int","interface","long","native","new","package","private","protected","public","return","short","static","strictfp","super","switch","synchronized","this","throw","throws","transient","try","void","volatile","while"));
    private HashSet<Character> delimeters = new HashSet<>(Arrays.asList(' ','+','=','\n','-',',','\t','(',')','[',']','*',';','.','<','>'));
    private HashSet<String> foundKeyWords = new HashSet<>();
    private HashSet<String> foundWords = new HashSet<>();

    public void loadFile(String path){
        byte[] buffer = new byte[1000];
        InputStream in=null;

        try {
            int bytesread;
            in = new FileInputStream(path);
            while ((bytesread = in.read(buffer))>0){
                for (int i = 0; i < bytesread; i++) {
                    code.append((char)buffer[i]);
                }
            }
            in.close();
            //TODO: не разобраля как закрывать в finally не нарвавшись на NPE
        }
        catch (Exception e){
            //do bothing
        }
    }
    public void printKeyWords(){
        calcKeyWords();
        System.out.println(foundKeyWords.toString());
    }
    private void calcKeyWords(){
        splitCode1();
        for (String word:foundWords) {
            if (allKeyWords.contains(word)){
                foundKeyWords.add(word);
            }
        }

    }

    private void splitCode1(){
        StringBuilder currWord = new StringBuilder();
        boolean quoteflag = false;
        boolean slashflag = false;
        boolean commentflag = false;
        boolean precommentflag = false;
        for (char curr:code.toString().toCharArray()) {
            if (delimeters.contains(curr) && !quoteflag && !commentflag){
                foundWords.add(currWord.toString());
                currWord = new StringBuilder();
            }
            else{
                if(curr == '"' && !slashflag && !commentflag){
                    quoteflag = !quoteflag;
                }else {
                    if (!quoteflag) {
                        if(curr == '\n'){
                            precommentflag = false;
                            commentflag = false;
                        }
                        if (!commentflag) {
                            currWord.append(curr);
                        }
                        if (curr == '/' && precommentflag){
                            commentflag = true;
                        }
                        if (curr == '/' && !precommentflag){
                            foundWords.add(currWord.toString());
                            currWord = new StringBuilder();
                            precommentflag = true;
                        }else {
                            precommentflag = false;
                        }

                    }
                }
                slashflag = curr == '\\';
            }
        }
    }
}
