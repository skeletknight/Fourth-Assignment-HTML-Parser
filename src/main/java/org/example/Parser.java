package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        //TODO
        sortedByName.sort(Comparator.comparing(Country::getName));
        for(Country country:sortedByName){
            System.out.println("name of the country: "+country.getName() +"\nCapital: "+country.getCapital() );

        }
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation).reversed());
        for(Country country:sortedByPopulation){
            System.out.println("name of the country: "+country.getName() +"\nPopulation: "+country.getPopulation() );

        }
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);

        // Sort countries by area (most)
        //TODO
        sortedByArea.sort(Comparator.comparing(Country::getArea).reversed());
        for(Country country:sortedByArea){
            System.out.println("name of the country: "+country.getName() +"\nArea: "+country.getArea()+"km^2" );

        }
        //System.out.println(sortedByArea.get(0).getName());
        return sortedByArea;

    }
    public void findCapital(){
        System.out.println("enter the name of the country");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        for(Country country:countries){
            if(Objects.equals(country.getName(), input)){
                System.out.println(country.getCapital());
            }
        }
    }

    public void setUp() throws IOException {


        try {
            Document doc = Jsoup.parse(new File("D:\\fourth1\\src\\main\\java\\org\\example\\country-list.html"), "UTF-8");

            Elements countryElements = doc.select(".country");

            for (Element country : countryElements) {

                String countryName = country.select(".country-name").text();
                String capital = country.select(".country-capital").text();
                String countryArea = country.select(".country-area").text();
                String countryPopulation = country.select(".country-population").text();
                double area = Double.parseDouble(countryArea);
                int population = Integer.parseInt(countryPopulation);
                Country country1 = new Country(countryName ,capital,population,area);
                countries.add(country1);

               // System.out.println("Country: " + countryName + ", Area: " + countryArea + " km², Population: " + countryPopulation);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //you can test your code here before you run the unit tests ;)
        Parser parser = new Parser();
        parser.setUp();
        boolean boool = true;
        while (boool) {
            System.out.println("welcome to contries information");
            System.out.println("what do you want to do");
         System.out.println("1.see contries sorted by area\n2.see countries sorted by population\n3.see countries sorted by name\n4.do you want to see the capital of a specefic country?\n5.exit");
         int input = scanner.nextInt();
         switch (input) {
            case 1:
                parser.sortByArea();
                break;
            case 2:
                parser.sortByPopulation();
                break;
            case 3:
                parser.sortByName();
                break;
            case 4:
                parser.findCapital();
                break;
             case 5:
                 boool = false;
                 break;


            }
        }
    }
}
