
package com.laboratorio.java119.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonaWebService", targetNamespace = "http://ws.java119.laboratorio.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonaWebService {


    /**
     * 
     * @return
     *     returns java.util.List<com.laboratorio.java119.ws.Persona>
     */
    @WebMethod(operationName = "ListarPersonas")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ListarPersonas", targetNamespace = "http://ws.java119.laboratorio.com/", className = "com.laboratorio.java119.ws.ListarPersonas")
    @ResponseWrapper(localName = "ListarPersonasResponse", targetNamespace = "http://ws.java119.laboratorio.com/", className = "com.laboratorio.java119.ws.ListarPersonasResponse")
    public List<Persona> listarPersonas();

    /**
     * 
     * @param apellidos
     * @param fechaNac
     * @param experiencia
     * @param nombres
     * @return
     *     returns com.laboratorio.java119.ws.Resultado
     */
    @WebMethod(operationName = "CrearPersona")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CrearPersona", targetNamespace = "http://ws.java119.laboratorio.com/", className = "com.laboratorio.java119.ws.CrearPersona")
    @ResponseWrapper(localName = "CrearPersonaResponse", targetNamespace = "http://ws.java119.laboratorio.com/", className = "com.laboratorio.java119.ws.CrearPersonaResponse")
    public Resultado crearPersona(
        @WebParam(name = "nombres", targetNamespace = "")
        String nombres,
        @WebParam(name = "apellidos", targetNamespace = "")
        String apellidos,
        @WebParam(name = "fechaNac", targetNamespace = "")
        String fechaNac,
        @WebParam(name = "experiencia", targetNamespace = "")
        int experiencia);

}