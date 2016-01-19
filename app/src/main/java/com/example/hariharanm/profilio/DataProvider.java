package com.example.hariharanm.profilio;

/**
 * Created by hariharanm on 9/1/2015.
 */
import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static List<Course> data = new ArrayList<>();

    public static List<Course> getData() {
        return data;
    }

    static {

        data.add(new Course("UsainBolt","World's fastest man","http://www.biography.com/people/usain-bolt-20702091",10101));

        data.add(new Course("Robert Downey Jr","World's highest paid actor","http://downeyunlimited.com/",10102));

        data.add(new Course("Floyd Mayweather","World's highest paid sportsmen","http://www.mayweatherpromotions.com/",10103));

        data.add(new Course("Dr. Dre","World's highest paid Musician","http://www.dr-dre.com/",10104));

        data.add(new Course("Shelly ann fraser pryce","World's fastest woman","http://www.biography.com/people/shelly-ann-fraser-pryce-20830469",10105));

        data.add(new Course("Jim Parsons","World's Highest Paid Tv Actor","http://jimparsons.net/",10106));

    }

}

