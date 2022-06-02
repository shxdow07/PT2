/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp;

/**
 *
 * @author marpo
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import clubfutbolapp.persones.Soci;
import clubfutbolapp.persones.plantilla.Plantilla;
import clubfutbolapp.persones.plantilla.jugadors.Davanter;
import clubfutbolapp.persones.plantilla.jugadors.Defensa;
import clubfutbolapp.persones.plantilla.jugadors.Jugador;
import clubfutbolapp.persones.plantilla.jugadors.Migcampista;
import clubfutbolapp.persones.plantilla.jugadors.Porter;
import clubfutbolapp.persones.plantilla.tecnics.Entrenador;
import clubfutbolapp.persones.plantilla.tecnics.PreparadorFisic;

public class Club implements Serializable{
    private String nom;
    private String CIF;
    private String adreça;
    private String telefon;
    private String email;
    private String web;
    public static String carpeta="src\\clubfutbolapp\\Dades\\clubDades.dat";
    private HashMap<String, Plantilla> plantilla = new HashMap<>();
    private HashMap<String, Soci> socis = new HashMap<>();
    public void gestionarClub() throws IOException, ClassNotFoundException {     
        File file = new File(carpeta);
        if (file.isFile()) {
            llegirDadesFitxer();
        }

        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n---------GESTIONAR CLUB---------");
            System.out.println("1. Consultar les dades del club");
            System.out.println("2. Gestionar socis");
            System.out.println("3. Gestionar la plantilla");
            System.out.println("4. Dades Econòmiques del club");
            System.out.println("S. Sortir i Guardar les dades");

            String sa = sc.next();
            char opcio = sa.charAt(0); 

            switch (opcio) {
                case '1':
                    consultarDadesClub();
                    break;
                case '2':
                    gestionarSocis();
                    break;
                case '3':
                    gestionarPlantilla();
                    break;
                case '4':
                    visualitzarDadesEconomiques();
                    break;
                case 's':
                    System.out.println(" Sortir");
                    persistirDadesClub();
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    persistirDadesClub();
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        
        } while (!sortir);
    }

    

    private void consultarDadesClub() {
        System.out.println("\n---------DADES DEL CLUB---------");
        System.out.println("\nNom: " + this.nom);
        System.out.println("CIF: " + this.CIF);
        System.out.println("Adreça: " + this.adreça);
        System.out.println("Telèfon: " + this.telefon);
        System.out.println("Email: " + this.email);
        System.out.println("Web: " + this.web);
    }

    public void gestionarSocis() {
        Soci soci = new Soci();
        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********GESTIONAR SOCIS**********");
            System.out.println("1. Visualitzar tots els socis");
            System.out.println("2. Donar d'alta un soci");
            System.out.println("3. Modificar un soci");
            System.out.println("4. Donar de baixa un soci");
            System.out.println("S. Sortir");

             String sa = sc.next();
            char opcio = sa.charAt(0);     

            switch (opcio) {
                case '1':
                    visualitzarSocis();
                    break;
                case '2':
                    soci = soci.altaSoci();
                    String dniS = soci.getDni().getDni();
                    socis.put(dniS, soci);
                    System.out.println("Soci donat d'alta correctament!\n");
                    break;
                case '3':
                    dniS = null;
                    System.out.print("Escriu el dni del soci que vols modificar: ");
                    try {
                        dniS = sc.next();
                        soci = socis.get(dniS);
                        soci = soci.modificar(soci);
                    } catch (Exception e) {
                        System.out.println("No s'ha trobat el soci.");
                    }
                    socis.put(dniS, soci);
                    break;
                case '4':
                    try {
                        System.out.print("Escriu el dni del soci que vols donar de baixa: ");
                        dniS = sc.next();
                        if (socis.containsKey(dniS)) {
                            socis.remove(dniS);
                            System.out.println("Soci donat de baixa correctament!\n");
                        } else {
                            System.out.println("No s'ha trobat aquest DNI.");
                        }
                    } catch (Exception e) {
                        System.out.println("No s'ha trobat el soci.");
                    }
                    break;
                case 's':
                    System.out.println(" Sortir");
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        } while (!sortir);
    }

    

    public Club(String nom, String cIF, String adreça, String telefon, String email, String web) {
        this.nom = nom;
        CIF = cIF;
        this.adreça = adreça;
        this.telefon = telefon;
        this.email = email;
        this.web = web;
    }

    public Club() {

    }

    public void gestionarPlantilla() {
        
        boolean sortir = false;
        String dniS;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********GESTIONAR PLANTILLA**********");
            System.out.println("1. Visualitzar la plantilla");
            System.out.println("2. Donar d'alta un treballador");
            System.out.println("3. Modificar un treballador");
            System.out.println("4. Donar de baixa un treballador");
            System.out.println("S. Sortir");

             String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    visualitzarPlantilla();
                    break;
                case '2':       
                    altaTreballador();
                    break;
                case '3':
                    modificarTreballador();
                    break;
                case '4':
                    try {
                        System.out.print("Escriu el dni del treballador que vols donar de baixa: ");
                        dniS = sc.next();
                        if (plantilla.containsKey(dniS)) {
                            plantilla.remove(dniS);
                            System.out.println("Treballador donat de baixa correctament!\n");
                        } else {
                            System.out.println("No s'ha trobat aquest DNI.");
                        }                       
                    } catch (Exception e) {
                        System.out.println("No s'ha trobat el treballador.");
                    }
                    break; 
                case 's':
                    System.out.println(" Sortir");
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        } while (!sortir);
    }

    private void visualitzarDadesEconomiques() {
        System.out.println("\n---------INGRESSOS DEL CLUB---------");
        double ingressos = 0;
        ArrayList<Soci> socisA = new ArrayList<>();
        Iterator<Entry<String, Soci>> itr = socis.entrySet().iterator();
            while (itr.hasNext()) {
                Entry<String, Soci> entry = itr.next();
                socisA.add(entry.getValue());
        }
        for (Soci s : socisA) {
            ingressos += s.getQuota();
        }
        System.out.println("Quotes de socis: " + ingressos + " euros");

        System.out.println("\n---------DESPESES DEL CLUB---------");
        double despeses = 0;
        ArrayList<Plantilla> plantillaA = new ArrayList<>();
        Iterator<Entry<String, Plantilla>> itr2 = plantilla.entrySet().iterator();
            while (itr2.hasNext()) {
                Entry<String, Plantilla> entry = itr2.next();
                plantillaA.add(entry.getValue());
        }
        for (Plantilla p : plantillaA) {
            despeses += p.getSouIncentivat();
        }
        System.out.println("Salari dels treballadors: " + despeses + " euros");
    }

    
    
    private void visualitzarPlantilla() {
        ArrayList<Plantilla> arrayVisualitzar = new ArrayList<>();
        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********VISUALITZAR PLANTILLA**********");
            System.out.println("1. Ordenar per rol");
            System.out.println("2. Ordenar per sou");
            System.out.println("S. Sortir");

             String sa = sc.next();
            char opcio = sa.charAt(0);
            
            switch (opcio) {
                case '1':
                    arrayVisualitzar = Plantilla.ordenarPerRol(plantilla);
                    for (Plantilla p : arrayVisualitzar) {
                        System.out.println("----------------------");
                        System.out.println(p);
                    }
                    break;
                case '2':
                    arrayVisualitzar = Plantilla.ordenarPerSouIncentivat(plantilla);
                    for (Plantilla p : arrayVisualitzar) {
                        System.out.println("----------------------");
                        System.out.println(p);
                    }                    
                    break;
                case 's':
                    System.out.println(" Sortir");
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        } while (!sortir);
    }
    
    private void altaTreballador() { 
        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nQuin treballador vols donar d'alta?");
            System.out.println("1. Entrenador");
            System.out.println("2. Preparador físic");
            System.out.println("3. Davanter");
            System.out.println("4. Defensa");
            System.out.println("5. Migcampista");
            System.out.println("6. Porter");
            System.out.println("S. Sortir");

             String sa = sc.next();
            char opcio = sa.charAt(0);

            switch (opcio) {
                case '1':
                    Entrenador entrenador = new Entrenador();
                    entrenador = entrenador.altaEntrenador();
                    plantilla.put(entrenador.getDni().getDni(), entrenador);
                    System.out.println("Entrenador donat d'alta correctament!");
                    break;
                case '2':
                    PreparadorFisic preparador = new PreparadorFisic();
                    preparador = preparador.altaPreparadorFisic();
                    plantilla.put(preparador.getDni().getDni(), preparador);
                    System.out.println("Preparador fisic donat d'alta correctament!");
                    break;
                case '3':
                    Davanter davanter = new Davanter();
                    davanter = davanter.altaDavanter();
                    plantilla.put(davanter.getDni().getDni(), davanter);
                    System.out.println("Davanter donat d'alta correctament!");           
                    break;
                case '4':
                    Defensa defensa = new Defensa();
                    defensa = defensa.altaDefensa();
                    plantilla.put(defensa.getDni().getDni(), defensa);
                    System.out.println("Defensa donat d'alta correctament!");
                    break;
                case '5':
                    Migcampista mig = new Migcampista();
                    mig = mig.altaMigcampista();
                    plantilla.put(mig.getDni().getDni(), mig);
                    System.out.println("Migcampista donat d'alta correctament!");
                    break;
                case '6':
                    Porter porter = new Porter();
                    porter = porter.altaPorter();
                    plantilla.put(porter.getDni().getDni(), porter);
                    System.out.println("Porter donat d'alta correctament!");
                    break;
                case 's':
                    System.out.println(" Sortir");
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        } while (!sortir);
    }
    
    private void modificarTreballador() {
        String dniS;
        System.out.print("Escriu el dni del treballador que vols modificar: ");
        Scanner sc = new Scanner(System.in);
        try {
            dniS = sc.next();
            plantilla.get(dniS).modificar();
            System.out.println("Treballador modificat correctament!");
        } catch (Exception e) {
            System.out.println("No s'ha trobat el treballador.");
        }
    }
    
    private void visualitzarSocis() {
        ArrayList<Soci> arrayVisualitzar = new ArrayList<>();
        boolean sortir = false;
        Scanner sc = new Scanner(System.in);
        Soci s = new Soci();
        do {
            System.out.println("**********VISUALITZAR SOCIS**********");
            System.out.println("1. Ordenar per cognom");
            System.out.println("2. Ordenar per localitat");
            System.out.println("3. Ordenar per quota");
            System.out.println("S. Sortir");

             String sa = sc.next();
            char opcio = sa.charAt(0);
            
            switch (opcio) {
                case '1':
                    arrayVisualitzar = s.ordenarPerCognom(socis);
                    for (Soci soci : arrayVisualitzar) {
                        System.out.println("-------------------------");
                        System.out.println(soci);
                    }
                    break;
                case '2':
                    arrayVisualitzar = s.ordenarPerLocalitat(socis);
                    for (Soci soci : arrayVisualitzar) {
                        System.out.println("-------------------------");
                        System.out.println(soci); 
                    }
                    break;
                case '3':
                    arrayVisualitzar = s.ordenarPerQuota(socis);
                    for (Soci soci : arrayVisualitzar) {
                        System.out.println("-------------------------");
                        System.out.println(soci);   
                    }
                    break;
                case 's':
                    System.out.println(" Sortir");
                    sortir = true;
                    break;    
                case 'S':
                    System.out.println(" Sortir");
                    sortir = true;
                   break;
                default:
                    System.out.println("Valor no vàlid");
            }
        } while (!sortir);
    }
    
    private void obtenirVariablesEstatiques() {
        int maxNumEmpleat = 0;
        int maxDorsal = 0;
        int maxNumSoci = 0;
        int maxLocalitat = 0;
        ArrayList<Plantilla> plantillaA = new ArrayList<>();
        Iterator<Entry<String, Plantilla>> itr2 = plantilla.entrySet().iterator();
            while (itr2.hasNext()) {
                Entry<String, Plantilla> entry = itr2.next();
                plantillaA.add(entry.getValue());
        }

        for (Plantilla p : plantillaA) {
            if (p.getNumEmpleat() > maxNumEmpleat) {
                maxNumEmpleat = p.getNumEmpleat();
            }
            if (p instanceof Jugador) {
                Jugador jugador = (Jugador) p;
                if (jugador.getDorsal() > maxDorsal) {
                    maxDorsal = jugador.getDorsal();
                }
            } 
        }

        ArrayList<Soci> socisA = new ArrayList<>();
        Iterator<Entry<String, Soci>> itr = socis.entrySet().iterator();
            while (itr.hasNext()) {
                Entry<String, Soci> entry = itr.next();
                socisA.add(entry.getValue());
        }

        for (Soci s : socisA) {
            if (s.getNumSoci() > maxNumSoci) {
                maxNumSoci = s.getNumSoci();
            }
            if (s.getLocalitat() > maxLocalitat) {
                maxLocalitat = s.getLocalitat();
            }
        }
        Soci.setNumLocalitat(maxLocalitat);
        Soci.setNumeroSocis(maxNumSoci);
        Plantilla.setNumeroEmpleats(maxNumEmpleat);
        Jugador.setDorsals(maxDorsal);
    }


    private void persistirDadesClub() throws IOException {
        File file = new File(carpeta);
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream serialitzador = new ObjectOutputStream(fileOutput);
        serialitzador.writeObject(plantilla);
        serialitzador.writeObject(socis);
    }

    private void llegirDadesFitxer() throws IOException, ClassNotFoundException {
        File file = new File(carpeta);
        if (file.isFile()) {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream deserialitzador = new ObjectInputStream(fileInput);
            plantilla = (HashMap<String, Plantilla>) deserialitzador.readObject();
            socis = (HashMap<String, Soci>) deserialitzador.readObject();
            obtenirVariablesEstatiques();
        }
    }
}