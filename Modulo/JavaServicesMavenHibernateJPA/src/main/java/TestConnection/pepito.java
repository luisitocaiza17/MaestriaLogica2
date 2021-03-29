/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestConnection;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author pc030
 */
public class pepito {
    @JsonProperty("id")
    public int id;
    @JsonProperty("Nombre")
    public String nombre;
    @JsonProperty("Apellido")
    public String apellido;

    public int id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
