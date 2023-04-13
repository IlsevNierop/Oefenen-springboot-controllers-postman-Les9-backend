package com.example.les9demospringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class NameController {
    public static ArrayList<String> names = new ArrayList<>(Arrays.asList("Ilse", "Kees", "Pietje", "Jacqueline", "Patricia", "Linda"));

    @GetMapping ("/show")
    public String showNames(){

        // beter stringbuilder doen - is de nette manier
        String helloNames = "";

        for (int i = 0; i < names.size(); i++) {
            helloNames += "Hello " + names.get(i) + "\n";
        }
        return helloNames;
    }

    // stringbuilder optie:
//    ArrayList @GetMapping("/show")
//    public String getNames() {
//        StringBuilder sb = new StringBuilder("hello");
//        for (String name : names) { sb.append(" ");
//            sb.append(name);
//        }
//        return sb.toString(); }

    // kan ook door de reverse method van de string builder

    @GetMapping ("/showreversed")
    public String showReversedNames(){
        String reversedNames = "";
        // for each loop gebruiken bij beide for loops (bij tweede loopm moet je dan de karakters aan de voorkant eraan plakken)
        for (int i = 0; i < names.size(); i++) {
            char chRN[] = names.get(i).toCharArray();
            String reversedName = "";
            for (int j = chRN.length-1; j >= 0; j--) {
                reversedName += chRN[j];
            }
            reversedNames += reversedName + " ";
        }
        return reversedNames;
    }





    // kan ook door de arraylist in een hashset te doen - dan krijg je ook geen dubbele namen
    @PostMapping ("/add")
    public void addName(@RequestParam String name){
        boolean canAdd = true;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)){
                canAdd = false;
                // break toevoegen zodat de forloop stopt zodra de naam bestaat.
                break;
            }
        }
        if (canAdd) {
            this.names.add(name);
        }
    }

    //of:
//    @PostMapping ("/add")
//    public void addName(@RequestParam String name){
//    {
//        if (!names.contains(name)) {
//            names.add(name);
//        }
//    }
}
