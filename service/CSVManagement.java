package service;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import people.Person;

public class CSVManagement {
    
    //filename: dirPath + File.separator + filename
    public List<Person> readCSV(String filename, List<Person> persons) throws IOException{
        
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        
        //List<Person> persons = new ArrayList<>();
        String line = "";
        while (!((line = br.readLine() )== null)){
            System.out.println(line);

            String[] lineData = line.split(",");
            Person p = new Person (lineData[0], lineData[1], Integer.parseInt(lineData[2].trim()));
            persons.add(p);
            
        }
        br.close();
        fr.close();
        return persons;
    }

    public void writeCSV(String fullDirPathFilename, List<Person> persons) throws IOException{
        FileWriter fw = new FileWriter (fullDirPathFilename);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Person p: persons){
            bw.append(p.getName());
            bw.append(",");
            bw.append(p.getMrtStation());
            bw.append(",");
            bw.append(String.valueOf(p.getBirthYear()));
            bw.newLine();
            
        }
        bw.flush();
        bw.close();
        fw.close();
    }

}
