//import java.io.Console;
//import java.io.File;
//import java.io.IOException;
import java.io.*;
import java.util.logging.FileHandler;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.*;

import javax.annotation.processing.FilerException;

import people.Person;
import service.CSVManagement;

public class App {
    public static void main(String[] args) throws IOException {
        //args[0] = "C:\data"
        //args[1] = "myfile.txt"
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName; // file separator helps to put the backslash

        //check if directory exits
        //if doesnt exist, create the directory

    File directory = new File(dirPath);
    
    if (directory.exists()){
        System.out.println(directory.toString() + " exists");
    }
    else{
        directory.mkdir();
    }

    // check if file exists
    //if file does not exist, create file
    File file = new File(dirPathFileName);

    if (file.exists()){
        System.out.println(dirPathFileName + " exists");
    }
    else{
        file.createNewFile();
    }

    //File writer and reader

    /* Console console = System.console();
    String keyboardInput = console.readLine("Enter a sentence: "); */

/*     FileWriter fw = new FileWriter(file, true); //append = true means it will add on to the document instead of replacing
    fw.write(keyboardInput);
    fw.flush();
    fw.close();

    //use FileReader to read a file
    FileReader fr = new FileReader(file);
    int dataRead = fr.read();
    while (dataRead != -1){
        System.out.println((char) dataRead);
        fr.read();
    }
    fr.close(); */
    
    
    // Buffered writer

/*     FileWriter fw = new FileWriter(file, true);
    BufferedWriter bw = new BufferedWriter(fw);
    bw.append(keyboardInput);
    bw.flush();
    bw.close();

    FileReader fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line = "";
    while ((line = br.readLine()) != null){
        System.out.println(line);
    }
    br.close();
    fr.close(); */


    //try try thingy
    // .....



    // Outputstream and Input stream

    /* FileOutputStream fos = new FileOutputStream(file, true);
    byte[] byteContent = keyboardInput.getBytes();
    fos.write(byteContent);
    fos.flush();
    fos.close();

    FileInputStream fis = new FileInputStream(file);
    int contentRead = 0;
    while ((contentRead = fis.read()) != -1) {
        System.out.print((char) contentRead);
    }
    fis.close(); */



    // Decorator pattern


/*     //Gzip
    FileOutputStream fos = new FileOutputStream(file, true);
    GZIPOutputStream gos = new GZIPOutputStream(fos);
    byte[] contents = keyboardInput.getBytes();
    gos.write(contents);
    gos.flush();
    gos.close();
    fos.close();

    FileInputStream fis = new FileInputStream(file);
    GZIPInputStream gis = new GZIPInputStream(fis);
    int gizContent = 0;
    while(!((gizContent = gis.read()) == -1 )){
        System.out.print((char)gizContent);
    }
    gis.close();
    fis.close(); */


    //Dataoutputstream

    /* FileOutputStream fos = new FileOutputStream(file, false);
    DataOutputStream dos = new DataOutputStream (fos);
    byte[] outputBytes = keyboardInput.getBytes();
    dos.write(outputBytes);
    dos.close();
    fos.close();

    FileInputStream fis = new FileInputStream(file);
    DataInputStream dis = new DataInputStream(fis);
    int disContent = 0;
    while(!((disContent = dis.read()) == -1)){
        System.out.print((char) disContent);
    }
    dis.close();
    fis.close(); */

    List<Person> persons = new ArrayList<>();
    CSVManagement csv = new CSVManagement();
    csv.readCSV(dirPathFileName, persons);


    //1. 
    //2. 
    //3. quit 
    Console console = System.console();
    Integer selection = 0;
    while (selection != 3){
        System.out.println("Press 1 to enter new person details");
        System.out.println("Press 2 to Save to new csv file");
        System.out.println("Press 3 to quit");
        selection = Integer.parseInt(console.readLine(">>>>>"));



        switch (selection) {
            case 1:
                Console cons1 = System.console();
                String name1 = cons1.readLine("Enter person name");
                String mrtStation1 = cons1.readLine("Enter person mrt station");
                String birthyear1 = cons1.readLine("Enter person birth year");

                Person person1 = new Person(name1, mrtStation1, Integer.parseInt(birthyear1));
                persons.add(person1);
                break;

            case 2:
                Console cons2 = System.console();
                String path2 = cons2.readLine("Enter file name with path to save in");
                csv.writeCSV(path2, persons);
                
                break;
        
            default:
                break;
        }
    }





    }
}