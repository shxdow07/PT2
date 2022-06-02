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
import java.io.IOException;

public class ClubFutbolApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Club c = new Club("Guissona F.C", "123456789", "C/ Rambla dels Segadors", "685423565", "guissonaFC@gmail.com", "www.guissonaFC.com");
        c.gestionarClub();
    }
}