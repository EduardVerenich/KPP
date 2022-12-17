package com.example.integraltrapezia;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
public class IntegralTrapeziaApplication {
    public static double fun(double x)
    {
        double a = Math.sin(x);
        return a;
    }
    public static String Trapezia(String a, String b)
    {
        double startInter = Double.parseDouble (a);
        double endInter = Double.parseDouble(b);
        double T=0;
        while(startInter<0.875)
        {
            startInter=startInter+0.125;
            T+=fun(startInter);
        }
        double I = (0.125/2)*(fun(startInter)+2*T+fun(endInter));
        String i = Double.toString (I);
        return i;
    }

    public static void main(String[] args) {

        SpringApplication.run(IntegralTrapeziaApplication.class, args);
    }
    @GetMapping("/integral")
    public String sayHello(@RequestParam(value="start", defaultValue="0")String start,
                           @RequestParam(value="end",defaultValue="0") String end)

    // private String start;
    //

    {
        String answer = Trapezia(start, end);
        return String.format("The integral of sin(x)dx with the beginning of the interval %s " +
                "and the end of the interval %s is:\n%s",start,end, answer);}


}

