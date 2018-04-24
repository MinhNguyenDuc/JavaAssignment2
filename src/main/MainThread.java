/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;

/**
 *
 * @author nguye
 */
public class MainThread {
    public static void main(String[] args) throws MalformedURLException, IOException {
        // Make a URL to the web page
        URL url = new URL("https://vnexpress.net/");

        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is =con.getInputStream();

        // Once you have the Input Stream, it's just plain old Java IO stuff.

        // For this case, since you are interested in getting plain-text web page
        // I'll use a reader and output the text content to System.out.

        // For binary content, it's better to directly read the bytes from stream and write
        // to the target file.


        BufferedReader br = new BufferedReader(new InputStreamReader(is));

            
        File folderName = new File("saved_pages");
        if(!folderName.exists()){
            folderName.mkdir();
        }
        
        File indexPage = new File(folderName + "/index1.html");
        if(!indexPage.exists()){
            indexPage.createNewFile();
        }
        FileWriter fw = new FileWriter(indexPage);
        BufferedWriter writer = new BufferedWriter(fw);
        String line;  
        while ((line = br.readLine()) != null) {
            writer.write(line);           
        }
        writer.close();
    }
}

