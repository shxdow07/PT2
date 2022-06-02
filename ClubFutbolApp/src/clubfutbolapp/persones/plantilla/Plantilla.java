/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.persones.plantilla;

/**
 *
 * @author marpo
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import clubfutbolapp.persones.Persona;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;

public abstract class Plantilla extends Persona implements Comparable<Plantilla>, Serializable {
    private static int numeroEmpleats;
    private int numEmpleat;
    private String nss;
    private double souBase;
    private double souIncentivat;
    private transient final Scanner sc = new Scanner(System.in);
    public static ArrayList<Plantilla> ordenarPerRol(HashMap<String, Plantilla> p) {
        ArrayList<Plantilla> arrayVisualitzar = new ArrayList<>();
        Iterator<Entry<String, Plantilla>> itr = p.entrySet().iterator();
            while (itr.hasNext()) {
                Entry<String, Plantilla> entry = itr.next();
                arrayVisualitzar.add(entry.getValue());
            }
        Collections.sort(arrayVisualitzar);
        
        return arrayVisualitzar;
    }

    public static ArrayList<Plantilla> ordenarPerSouIncentivat(HashMap<String, Plantilla> p) {
        ArrayList<Plantilla> arrayVisualitzar = new ArrayList<>();
        Iterator<Entry<String, Plantilla>> itr = p.entrySet().iterator();
            while (itr.hasNext()) {
                Entry<String, Plantilla> entry = itr.next();
                arrayVisualitzar.add(entry.getValue());
            }
        arrayVisualitzar.sort(new Comparator<Plantilla>() {
            @Override
            public int compare(Plantilla p1, Plantilla p2) {
                return (int) (p1.getSouIncentivat() - p2.getSouIncentivat());
            }
        });
        
        return arrayVisualitzar;
    }

    public static int getNumeroEmpleats() {
        return numeroEmpleats;
    }

    public static void setNumeroEmpleats(int numeroEmpleats) {
        Plantilla.numeroEmpleats = numeroEmpleats;
    }

    @Override
    public int compareTo(Plantilla a) {
        return this.getClass().getSimpleName().compareToIgnoreCase(a.getClass().getSimpleName());
    }

    public int getNumEmpleat() {
        return numEmpleat;
    }

    public void setNumEmpleat(int numEmpleat) {
        this.numEmpleat = numEmpleat;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public double getSouBase() {
        return souBase;
    }

    public void setSouBase(double souBase) {
        this.souBase = souBase;
    }
    
    public double getSouIncentivat() {
        return souIncentivat;
    }

    public void setSouIncentivat(double souIncentivat) {
        this.souIncentivat = souIncentivat;
    }
    public Plantilla() {

    }

    public Plantilla(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon,
            Correu email, String nss, double souBase) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.numEmpleat = ++numeroEmpleats;
        this.nss = nss;
        this.souBase = souBase;
        calcularSouIncentivat();
    }

    public abstract void calcularSouIncentivat();

    public void altaTreballador() {
        altaPersona();
        System.out.println("--------------------------------");
        System.out.print("Escriu el NSS: ");
        setNss(sc.next());

        System.out.print("Escriu el sou base: ");
        setSouBase(sc.nextInt());

        setNumEmpleat(++numeroEmpleats);
    }
    
     @Override
    public String toString() {
        return super.toString() + "\nNSS: " + getNss() + "\nNumEmpleat: " + getNumEmpleat() + "\nSou Base: " + getSouBase() + "\nSou Incentivat: " + getSouIncentivat();
    }

    @Override
    public void modificar() {
        super.modificar();

        System.out.print("Escriu el nou SOU: ");
        double sou = sc.nextDouble();
        setSouBase(sou);
    }
}
