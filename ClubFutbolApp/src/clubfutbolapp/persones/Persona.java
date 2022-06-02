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
import java.util.Scanner;
import clubfutbolapp.validacions.Correu;
import clubfutbolapp.validacions.Dni;
import clubfutbolapp.validacions.Telefon;



public abstract class Persona implements Serializable {
    private Dni dni;
    private String nom;
    private String cognom1;
    private String cognom2;
    private LocalDate data_naix;
    private Telefon telefon;
    private Correu email;
    public Persona(Dni dni, String nom, String cognom1, String cognom2, LocalDate data_naix, Telefon telefon, Correu email) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.data_naix = data_naix;
        this.telefon = telefon;
        this.email = email;
    }
    public Persona() {

    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public LocalDate getData_naix() {
        return data_naix;
    }

    public void setData_naix(LocalDate data_naix) {
        this.data_naix = data_naix;
    }

    public Telefon getTelefon() {
        return telefon;
    }

    public void setTelefon(Telefon telefon) {
        this.telefon = telefon;
    }

    public Correu getEmail() {
        return email;
    }

    public void setEmail(Correu email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "\nDni: " + getDni() + "\nNom: " + getNom() + "\nCognoms: " + cognom1 + " " + cognom2 + "\nData naixement: " + data_naix + "\nEmail: " + email + "\nTelefon: " + telefon;
    }

    public void altaPersona() {
        Dni dni = new Dni();
        String dniS;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el dni del empleat: ");
            dniS = sc.nextLine();
            if(!dni.validarDNI(dniS)){
                System.out.println("DNI Incorrecte");
            }
        } while (!dni.validarDNI(dniS));

        dni.setDni(dniS);
        setDni(dni);
        System.out.println("--------------------------------");
        System.out.print("Escriu el nom: ");
        setNom(sc.nextLine());
        System.out.print("Escriu el primer cognom: ");
        setCognom1(sc.nextLine());;
        System.out.print("Escriu el segon cognom: ");
        setCognom2(sc.nextLine());

        boolean dataCorrecta;
        LocalDate data_naix = null;
        do {
            dataCorrecta = true;
            System.out.println("--------------------------------");
            System.out.print("Escriu la data de naixement (YYYY-MM-DD): ");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
            try {
                setData_naix(LocalDate.parse(sc.next(), dateFormat));
            } catch (Exception e) {
                dataCorrecta = false;
            }
        } while (!dataCorrecta);

        Telefon telefon = new Telefon();
        String telefonS;

        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el número de telèfon: ");
            sc.nextLine();
            telefonS = (sc.next());
            if(!telefon.validarTel(telefonS)){
                    System.out.println("Telefon Incorrecte");
                }
        } while (!telefon.validarTel(telefonS));

        telefon.setTelf(telefonS);
        setTelefon(telefon);

        Correu email = new Correu();
        String emailS;
        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el correu electrònic: ");
            sc.nextLine();
            emailS = (sc.next());
            if(!email.validarCorreu(emailS)){
                    System.out.println("Email Incorrecte");
                }
        } while (!email.validarCorreu(emailS));

        email.setCorreu(emailS);
        setEmail(email);
    }

    public void modificar() {
        String nom, cognom1, cognom2;
        LocalDate data_naix;
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.print("Escriu el NOM: ");
        nom = sc.nextLine();

        if (!nom.isEmpty()) {
            setNom(nom);
        }

        System.out.print("Escriu el PRIMER COGNOM: ");
        cognom1 = sc.nextLine();

        if (!cognom1.isEmpty()) {
            setCognom1(cognom1);
        }

        System.out.print("Escriu el SEGON COGNOM: ");
        cognom2 = sc.nextLine();        

        if (!cognom2.isEmpty()) {
            setCognom2(cognom2);
        }

        boolean dataCorrecta;
        do {
            dataCorrecta = true;
            System.out.println("--------------------------------");
            System.out.print("Escriu la DATA NAIXEMENT: ");
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-M-d");
            try {
                data_naix = (LocalDate.parse(sc.next(), dateFormat));
            } catch (Exception e) {
                dataCorrecta = false;
            }
        } while (!dataCorrecta);

        Telefon telefon = new Telefon();
        String telefonS;

        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el número de telèfon: ");
            sc.nextLine();
            telefonS = sc.nextLine();
            if (!telefonS.isEmpty()) {
                telefon.setTelf(telefonS);
                setTelefon(telefon);
                if(!telefon.validarTel(telefon.getTelf())){
                    System.out.println("Telefon Incorrecte");
                }
            }
        } while (!telefon.validarTel(telefon.getTelf()));

        Correu email = new Correu();
        String emailS;
        do {
            System.out.println("--------------------------------");
            System.out.print("Escriu el correu electrònic: ");
            emailS = sc.nextLine();
            if (!emailS.isEmpty()) {
                email.setCorreu(emailS);
                setEmail(email);
                if(!email.validarCorreu(emailS)){
                    System.out.println("Email Incorrecte");
                }
            }     
        } while (!email.validarCorreu(emailS));
    }

}

