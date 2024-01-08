
package com.laboratorio.java119.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.laboratorio.java119.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearPersona_QNAME = new QName("http://ws.java119.laboratorio.com/", "CrearPersona");
    private final static QName _CrearPersonaResponse_QNAME = new QName("http://ws.java119.laboratorio.com/", "CrearPersonaResponse");
    private final static QName _ListarPersonas_QNAME = new QName("http://ws.java119.laboratorio.com/", "ListarPersonas");
    private final static QName _ListarPersonasResponse_QNAME = new QName("http://ws.java119.laboratorio.com/", "ListarPersonasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.laboratorio.java119.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearPersona }
     * 
     */
    public CrearPersona createCrearPersona() {
        return new CrearPersona();
    }

    /**
     * Create an instance of {@link CrearPersonaResponse }
     * 
     */
    public CrearPersonaResponse createCrearPersonaResponse() {
        return new CrearPersonaResponse();
    }

    /**
     * Create an instance of {@link ListarPersonas }
     * 
     */
    public ListarPersonas createListarPersonas() {
        return new ListarPersonas();
    }

    /**
     * Create an instance of {@link ListarPersonasResponse }
     * 
     */
    public ListarPersonasResponse createListarPersonasResponse() {
        return new ListarPersonasResponse();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link Resultado }
     * 
     */
    public Resultado createResultado() {
        return new Resultado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearPersona }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearPersona }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.java119.laboratorio.com/", name = "CrearPersona")
    public JAXBElement<CrearPersona> createCrearPersona(CrearPersona value) {
        return new JAXBElement<CrearPersona>(_CrearPersona_QNAME, CrearPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearPersonaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearPersonaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.java119.laboratorio.com/", name = "CrearPersonaResponse")
    public JAXBElement<CrearPersonaResponse> createCrearPersonaResponse(CrearPersonaResponse value) {
        return new JAXBElement<CrearPersonaResponse>(_CrearPersonaResponse_QNAME, CrearPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonas }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPersonas }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.java119.laboratorio.com/", name = "ListarPersonas")
    public JAXBElement<ListarPersonas> createListarPersonas(ListarPersonas value) {
        return new JAXBElement<ListarPersonas>(_ListarPersonas_QNAME, ListarPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPersonasResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPersonasResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.java119.laboratorio.com/", name = "ListarPersonasResponse")
    public JAXBElement<ListarPersonasResponse> createListarPersonasResponse(ListarPersonasResponse value) {
        return new JAXBElement<ListarPersonasResponse>(_ListarPersonasResponse_QNAME, ListarPersonasResponse.class, null, value);
    }

}
