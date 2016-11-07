/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import problema.Nodo;

/**
 *
 * @author arthurhoch
 */
public class LerArquivo {
    
    private String caminhoArquivo;
    private List<Nodo> nodos;
    
    public LerArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.nodos = new LinkedList<>();
    }
    
    public List<Nodo> ler() throws FileNotFoundException, IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
        
        String line = br.readLine();
        
        while( (line = br.readLine()) != null ) {
            String valores[] = line.split(" ");
            int nodoDe = Integer.parseInt(valores[1]);
            int nodoPara = Integer.parseInt(valores[2]);
            int distancia = Integer.parseInt(valores[3]);
            
            if(possuiNodo(nodos, nodoDe)) {
                getNodeNumero(nodoDe).addCaminho(nodoDe, nodoPara, distancia);
            }
            else        
                nodos.add(new Nodo( nodoDe, nodoPara, distancia));
        }
           
        return nodos;
    }
    
    public Nodo getNodeNumero(int numero) {
        for (Nodo nodo : nodos) {
            if(nodo.getNumero() == numero)
                return nodo;
        }
        
        return null;
    }
    
    public boolean possuiNodo(List<Nodo> nodos, int numero) {
        
        for (Nodo nodo : nodos) {
            if(nodo.getNumero() == numero)
                return true;
        }
        
        return false;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }
}
