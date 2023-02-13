package com.isa.jjdzr;

import com.isa.jjdzr.deserializer.JsonDeserializer;
import com.isa.jjdzr.deserializer.Resort;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Code crunchers" );
        System.out.println();

        List<Resort> resorts = JsonDeserializer.deserialize();
        SearchEngine sE = new SearchEngine();

        // wyszukiwanie po nazwie, w miejsce stringa wskoczy to co poda użytkownik
        sE.searchByName("Wieżyca Koszałkowo", resorts);
        // wyszukiwanie po województwie, w miejsce stringa wskoczy to co poda użytkownik
        sE.searchByRegion("śląskie", resorts);









    }
}
