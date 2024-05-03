package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class hackiinfo {


    public void setUp() throws IOException {

        try {
            // Load the HTML file (replace with the actual path to your "hockey" file)
            File inputFile = new File("D:\\fourth1\\src\\main\\java\\org\\example\\hockey.html");
            Document doc = Jsoup.parse(inputFile, "UTF-8");

            // Select all rows with class "team"
            Elements teamRows = doc.select("tr.team");

            for (Element row : teamRows) {
                String teamName = row.select(".name").text().trim();
                String year = row.select(".year").text().trim();
                String wins = row.select(".wins").text().trim();
                String losses = row.select(".losses").text().trim();

                System.out.println("Team: " + teamName);
                System.out.println("Year: " + year);
                System.out.println("Wins: " + wins);
                System.out.println("Losses: " + losses);
                System.out.println(); // Add a newline for readability
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        hackiinfo info = new hackiinfo();
        info.setUp();

    }

}




