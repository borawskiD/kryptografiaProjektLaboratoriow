package com.example.kryptografiazadanie6;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/kryptografia")
    ResponseEntity<String> findById(@RequestParam String number) {
        Integer num = 0;
        LinkedList<String> list = new LinkedList<>();
        list.add("Lxprcx napx bdv"); //cogito ergo sum
        list.add("Jlcdb qxvrwrb, wxw mrpwrcjb rdmrlncda"); //Actus hominis, non dignitas iudicetur
        list.add("Jbbrmdn jmmrblnwb jm bnwrdv enwrx"); //Assidue addiscens ad senium venio
        list.add("Jdmnwmdv nbc: oxacnb jmrdejc rybj Enwdb"); //Audendum est: fortes adiuvat ipsa Venus
        list.add("Vjpwj mr ldajwc, yjaej wnpunpdwc"); //Magna di curant, parva neglegunt

        try{
            num = Integer.valueOf(number);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body("Blad - podaj numer jako napis" + number);
        }
        Random random = new Random();

        return ResponseEntity.status(HttpStatus.OK).body("Dobra robota, twoją unikalna liczbą jest " + (num % 997 + random.nextInt(1000) + ". Odszyfruj zdanie: " + list.get(random.nextInt(list.size()))));
    }
}
