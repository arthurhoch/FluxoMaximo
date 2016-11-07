/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fluxomaximo2;

import auxiliar.LerArquivo;
import java.io.IOException;
import java.util.List;
import problema.Nodo;
import problema.ResolverFluxo;

/**
 *
 * @author arthurhoch
 */
public class FluxoMaximo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        LerArquivo la = new LerArquivo("pmed1.txt");
        List<Nodo> nodos = la.ler();
        
        ResolverFluxo rf = new ResolverFluxo(nodos, 1, maiorNodo(nodos));
        rf.resolver();
    }
    
    
    public static int maiorNodo(List<Nodo> nodos) {
        int numero = 0;
        
        for (Nodo nodo : nodos) {
            if(nodo.getNumero() > numero)
                numero = nodo.getNumero();
        }
        return numero;
    }
    
}
