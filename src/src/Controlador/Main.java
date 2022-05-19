package src.Controlador;


import src.Clases.Perro;

public class Main {
    public static void main(String[] args) {
        Perro yo = new Perro(1,"Daniel","NISUPU","verde",false,9);
        System.out.println(yo.getNombre()+"|");
        System.out.println(yo.getRaza()+"|");
        System.out.println(yo.getId());
        System.out.println(yo);
        System.out.println(Perro.SIZE);
        System.out.println(Character.SIZE/8);
        byte[] cadena = yo.getNombre().getBytes();


        Perro victor = new Perro();
        victor = victor.leerPerro();
        System.out.println(victor);
    }
    }

