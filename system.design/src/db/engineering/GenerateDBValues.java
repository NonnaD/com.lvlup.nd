package db.engineering;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateDBValues {

    public static void main(String[] args) {
        generateDBRecords();
    }


    //Random db values generator
    public static void generateDBRecords(){
        String[] names = {"Samanta", "Alexia", "Miranda", "Lupa", "Bob", "Stiven", "Karen", "David",
                "Ning", "Niao", "Mola", "Nancy", "Karl", "Denis", "Delvin", "Selena"};

        String[] lnames = {"Martinez", "Alfreso", "Jonson", "King", "Li", "Kong", "Pao", "Fu", "Gorzia", "Petrov",
                "Popov", "Klement", "Mercalez"};

        String[] years = {"1965-05-06", "1965-05-06", "1936-05-06","1945-12-08","1965-02-16","1905-05-06","1998-05-06","1945-08-01","1945-03-04","1955-05-06"};

        for (int i = 5; i < 3000; i++) {
            System.out.println("insert into Patient values ("+ i +", '"+ names[ThreadLocalRandom.current().nextInt(0,  names.length -1)] +"', '" +
                    ""+ lnames[ThreadLocalRandom.current().nextInt(0,  lnames.length -1)]
                    +"', '"+years[ThreadLocalRandom.current().nextInt(0,  years.length -1)] +"');");
        }
    }
}
