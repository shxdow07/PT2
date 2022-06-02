/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.persones;

/**
 *
 * @author marpo
 */
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;

public class Soci extends Persona implements Comparable<Soci>, Comparator<Soci>, Serializable{
    private static int numLocalitat = 499;
    private static int numeroSocis;
    private int numSoci;
    private int localitat;
    private double quota;

    public static int getNumLocalitat() {
        return numLocalitat;
    }

    public static void setNumLocalitat(int numLocalitat) {
        Soci.numLocalitat = numLocalitat;
    }

    public static int getNumeroSocis() {
        return numeroSocis;
    }

    public static void setNumeroSocis(int numeroSocis) {
        Soci.numeroSocis = numeroSocis;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public Scanner getSC() {
        return sc;
    }

    private transient final Scanner sc = new Scanner(System.in);

    public ArrayList<Soci> ordenarPerCognom(HashMap<String, Soci> socis) {
        ArrayList<Soci> arrayVisualitzar = new ArrayList<>();
        Iterator<Entry<String, Soci>> iterador = socis.entrySet().iterator();
            while (iterador.hasNext()) {
                Entry<String, Soci> entry = iterador.next();
                arrayVisualitzar.add(entry.getValue());
            }
            Collections.sort(arrayVisualitzar);      
            
        return arrayVisualitzar;

    }

    public ArrayList<Soci> ordenarPerLocalitat(HashMap<String, Soci> socis) {
        ArrayList<Soci> arrayVisualitzar = new ArrayList<>();
        Iterator<Entry<String, Soci>> iterador = socis.entrySet().iterator();
            while (iterador.hasNext()) {
                Entry<String, Soci> entry = iterador.next();
                arrayVisualitzar.add(entry.getValue());
            }
        arrayVisualitzar.sort(new Comparator<Soci>() {
            @Override
            public int compare(Soci s1, Soci s2) {
                return (int) s1.getLocalitat() - s2.getLocalitat();
            }
        });
        
        return arrayVisualitzar;
    }

    public ArrayList<Soci> ordenarPerQuota(HashMap<String, Soci> socis) {
        ArrayList<Soci> arrayVisualitzar = new ArrayList<>();
        Iterator<Entry<String, Soci>> iterador = socis.entrySet().iterator();
            while (iterador.hasNext()) {
                Entry<String, Soci> entry = iterador.next();
                arrayVisualitzar.add(entry.getValue());
            }
        arrayVisualitzar.sort(new Comparator<Soci>() {
            @Override
            public int compare(Soci s1, Soci s2) {
                return (int)(s1.getQuota() - s2.getQuota());
            }
        });
        
        return arrayVisualitzar;
    }

    public Soci altaSoci() {
        Dni dni = new Dni();
        String dniS;

        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el dni del soci: ");
            dniS = sc.nextLine();
        } while (!dni.validarDNI(dniS));

        dni.setDni(dniS);
        setDni(dni);
        System.out.println("--------------------------------");
        System.out.print("Escriu el nom: ");
        String nom = sc.nextLine();
        System.out.print("Escriu el primer cognom: ");
        String cognom1 = sc.nextLine();
        System.out.print("Escriu el segon cognom: ");
        String cognom2 = sc.nextLine();

        boolean dataCorrecta;
        LocalDate data_naix = null;
        do {
            dataCorrecta = true;
            System.out.println("--------------------------------");
            System.out.print("Escriu la data de naixement (YYYY-MM-DD): ");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
            try {
                data_naix = (LocalDate.parse(sc.next(), dateFormat));
            } catch (Exception e) {
                dataCorrecta = false;
            }
        } while (!dataCorrecta);

        Telefon telefon = new Telefon();
        String telefonStr;

        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el número de telèfon: ");
            sc.nextLine();
            telefonStr = (sc.next());
        } while (!telefon.validarTel(telefonStr));

        telefon.setTelf(telefonStr);
        setTelefon(telefon);

        Correu email = new Correu();
        String emailStr;
        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el correu electrònic: ");
            sc.nextLine();
            emailStr = (sc.next());
        } while (!email.validarCorreu(emailStr));

        email.setCorreu(emailStr);
        setEmail(email);
        System.out.println("--------------------------------");
        System.out.print("Escriu la quota del soci: ");
        int quota = sc.nextInt();
        
        Soci s = new Soci(dni, nom, cognom1, cognom2, data_naix, telefon, email, quota);
        return s;
    }

    public Soci modificar(Soci soci) {     
        System.out.println("--------------------------------");
        System.out.println("Estàs Modificant al Soci: " + soci.getNom() + " " + soci.getCognom1());
        super.modificar();

        System.out.print("Escriu la nova QUOTA: ");
        double quota = sc.nextInt();
        if (quota != 0) {
            setQuota(quota);
        }

        return soci;
    }

    public int getNumSoci() {
        return numSoci;
    }

    public void setNumSoci(int numSoci) {
        this.numSoci = numSoci;
    }

    public int getLocalitat() {
        return localitat;
    }

    public void setLocalitat(int localitat) {
        this.localitat = localitat;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public Soci(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon, Correu email, double quota) {
        super(dni, nom, cognom1, cognom2, data_naix, telefon, email);
        this.quota = quota;
        this.localitat = ++numLocalitat;
        this.numSoci = ++numeroSocis;
    }

    public Soci() {

    }

    @Override
    public String toString() {
        return super.toString() + "\nQuota: " + getQuota() + "\nNº soci: " + getNumSoci() + "\nLocalitat: " + getLocalitat(); 
    }

    @Override
    public int compareTo(Soci s) {
        return this.getCognom1().compareToIgnoreCase(s.getCognom1());
    }

    @Override
    public int compare(Soci o1, Soci o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
  
    
}
