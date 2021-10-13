package agh.cs.oop;


public class World {
    public static void main(String [] args){
        System.out.println("Start");
        run(args);
        System.out.println("Stop");
    }
    public static void run(String [] args){
        for(String arg : args)
        switch(arg){
            case "f":
                System.out.println("Przód");
                break;
            case "r":
                System.out.println("Prawo");
                break;
            case "l":
                System.out.println("Lewo");
                break;
            case "b":
                System.out.println("Tył");
                break;
            default:
                System.out.println("Nieznana komenda");
        }
    }
}
