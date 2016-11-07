package problema;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arthurhoch
 */
public class Nodo {

    private int numero;

    private List<Caminho> caminhos;

    public Nodo(int numero, int para, int distancia) {
        this.numero = numero;
        this.caminhos = new LinkedList<>();
        addCaminho(numero, para, distancia);
    }

    public void addCaminho(int de, int para, int distancia) {
        caminhos.add(new Caminho(de, para, distancia));
    }

    public void subtrairDistancia(int de, int para, int distancia) {
        for (Caminho caminho : caminhos) {
            if (caminho.getDe() == de && caminho.getPara() == para) {
                caminho.setDistancia(caminho.getDistancia() - distancia);
            }
        }
    }
    
    public boolean todosBlackList(List<Integer> blackList) {
        for(Caminho c : caminhos) {
            if(!blackList.contains(c.getPara()))
                return false;
        }
        return true;
    }

    public void somarDistancia(int de, int para, int distancia) {
        for (Caminho caminho : caminhos) {
            if (caminho.getDe() == de && caminho.getPara() == para) {
                caminho.setDistancia(caminho.getDistancia() + distancia);
            }
        }
    }

    public Caminho getMaiorCaminho() {
        Caminho maiorCaminho = caminhos.get(0);

        for (Caminho caminho : caminhos) {
            if (caminho.getDistancia() > maiorCaminho.getDistancia()) {
                maiorCaminho = caminho;
            }
        }

        return maiorCaminho;
    }

    public Caminho getMaiorCaminho(List<Integer> blackList) {
        Caminho maiorCaminho = caminhos.get(0);

        for (Caminho caminho : caminhos) {
            if (blackList.contains(maiorCaminho.getPara())) {
                maiorCaminho = caminho;
            }
            if (!blackList.contains(caminho.getPara())) {
                if (caminho.getDistancia() > maiorCaminho.getDistancia()) {
                    maiorCaminho = caminho;
                }
            }
        }

        return maiorCaminho;
    }

    public boolean temPara(int numeroNodo) {
        for (Caminho caminho : caminhos) {
            if (caminho.getPara() == numeroNodo) {
                return true;
            }
        }

        return false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nodo{" + "numero=" + numero + ", caminhos=" + caminhos.toString() + '}';
    }

    public List<Caminho> getCaminhos() {
        return caminhos;
    }

}
