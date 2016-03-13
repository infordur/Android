package rafa.edu.eltiempo;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by zaladriel on 29/02/16.
 */
public class ParseDom {
    private URL rssUrl;
    private boolean creado;


    public ParseDom(String url)
    {
        try
        {
            this.rssUrl = new URL(url);
            creado = true;
        }
        catch (MalformedURLException e)
        {
            creado=false;
        }
    }

    public Ciudad parse()
    {
        //Instanciamos la fábrica para DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Ciudad ciudad = new Ciudad();

        try
        {
            //Creamos un nuevo parser DOM
            DocumentBuilder builder = factory.newDocumentBuilder();

            //Realizamos lalectura completa del XML
            Document dom = builder.parse(this.getInputStream());

            //Localizamos todos los elementos <item>
            NodeList items = dom.getElementsByTagName("current");

            //Obtenemos la noticia actual
            Node item = items.item(0);

            ciudad.setNombre(item.getChildNodes().item(0).getAttributes().item(1).getNodeValue());


            ciudad.setPais(item.getChildNodes().item(0).getChildNodes().item(1).getChildNodes().item(0).getNodeValue());

            int celsius = Integer.parseInt(item.getChildNodes().item(1).getAttributes().item(0).getNodeValue().substring(0,3)) - 274;

            ciudad.setTemp(String.valueOf(celsius)+"ºC");

            ciudad.setHumedad(item.getChildNodes().item(2).getAttributes().item(0).getNodeValue()+"%");

            ciudad.setEstadoTiempo(item.getChildNodes().item(8).getAttributes().item(1).getNodeValue());




        }
        catch (Exception ex)
        {
            creado=false;
        }

        return ciudad;
    }


    private String obtenerTexto(Node dato)
    {
        StringBuilder texto = new StringBuilder();
        NodeList fragmentos = dato.getChildNodes();

        for (int k=0;k<fragmentos.getLength();k++)
        {
            texto.append(fragmentos.item(k).getNodeValue());
        }

        return texto.toString();
    }

    private InputStream getInputStream()
    {
        try
        {
            return rssUrl.openConnection().getInputStream();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean isCreado() {
        return creado;
    }

    public void setCreado(boolean creado) {
        this.creado = creado;
    }
}

