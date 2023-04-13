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
        String helloNames = "";

        for (int i = 0; i < names.size(); i++) {
            helloNames += "Hello " + names.get(i) + "\n";
        }
        return helloNames;
    }
    @GetMapping ("/showreversed")
    public String showReversedNames(){
        String backwardsNames = "";
        for (int i = 0; i < names.size(); i++) {
            char chRN[] = names.get(i).toCharArray();
            String reversedName = "";
            for (int j = chRN.length-1; j >= 0; j--) {
                reversedName += chRN[j];
            }
            backwardsNames += reversedName + " ";
        }
        return backwardsNames;
    }



    @PostMapping ("/add")
    public void addName(@RequestParam String name){
        boolean canAdd = true;
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equals(name)){
                canAdd = false;
            }
        }
        if (canAdd) {
            this.names.add(name);
        }
    }
}
