/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema;

/**
 *
 * @author arthurhoch
 */
public class Caminho {
    
    private Integer de;
    private Integer para;
    private Integer distancia;
    
    public Caminho(int de, int para, int distancia) {
        this.de = de;
        this.para = para;
        this.distancia = distancia;
    }

    public int getDe() {
        return de;
    }

    public void setDe(int de) {
        this.de = de;
    }
    
    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Caminho{" + "de=" + de + ", para=" + para + ", distancia=" + distancia + '}';
    }
    
    
    
}
