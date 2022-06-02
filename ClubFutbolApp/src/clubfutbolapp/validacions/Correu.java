/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clubfutbolapp.validacions;

/**
 *
 * @author marpo
 */
import java.io.Serializable;
import java.util.regex.Pattern;

public class Correu implements Serializable {
    private String correu;

    public boolean validarCorreu(String correu) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        java.util.regex.Matcher mather = pattern.matcher(correu);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }

    public Correu(String correu) {
        this.correu = correu;
    }

    public Correu() {
        this.correu = correu;
    }

    @Override
    public String toString() {
        return correu;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }
}