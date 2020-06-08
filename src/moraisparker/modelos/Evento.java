package moraisparker.modelos;

import java.util.ArrayList;


public class Evento {
    
    private int id;
    private String nomeDoEvento;
    private String inicioDoEvento;
    private String finalDoEvento;
    private ArrayList<Estacionamento> areasUsadas;

    public Evento() {
        this.areasUsadas = new ArrayList<>();
    }

    public Evento(int id) {
        this.id = id;
        this.areasUsadas = new ArrayList<>();
    }    

    public Evento(int id, String nomeDoEvento, String inicioDoEvento, String finalDoEvento) {
        this.id = id;
        this.nomeDoEvento = nomeDoEvento;
        this.inicioDoEvento = inicioDoEvento;
        this.finalDoEvento = finalDoEvento;
        this.areasUsadas = new ArrayList<>();
    }

    public Evento(String nomeDoEvento, String inicioDoEvento, String finalDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
        this.inicioDoEvento = inicioDoEvento;
        this.finalDoEvento = finalDoEvento;
        this.areasUsadas = new ArrayList<>();
    }

    public Evento(int id, String nomeDoEvento, String inicioDoEvento, String finalDoEvento, ArrayList<Estacionamento> areasUsadas) {
        this.id = id;
        this.nomeDoEvento = nomeDoEvento;
        this.inicioDoEvento = inicioDoEvento;
        this.finalDoEvento = finalDoEvento;
        this.areasUsadas = areasUsadas;
        
    }
    
    public Evento(String nomeDoEvento, String inicioDoEvento, String finalDoEvento, ArrayList<Estacionamento> areasUsadas) {
        this.nomeDoEvento = nomeDoEvento;
        this.inicioDoEvento = inicioDoEvento;
        this.finalDoEvento = finalDoEvento;
        this.areasUsadas = areasUsadas;
        
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getInicioDoEvento() {
        return inicioDoEvento;
    }

    public void setInicioDoEvento(String inicioDoEvento) {
        this.inicioDoEvento = inicioDoEvento;
    }

    public String getFinalDoEvento() {
        return finalDoEvento;
    }

    public void setFinalDoEvento(String finalDoEvento) {
        this.finalDoEvento = finalDoEvento;
    }

    public ArrayList<Estacionamento> getAreasUsadas() {
        return areasUsadas;
    }

    public void setAreasUsadas(ArrayList<Estacionamento> areasUsadas) {
        this.areasUsadas = areasUsadas;
    }
    
}
