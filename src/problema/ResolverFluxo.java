/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author arthurhoch
 */
public final class ResolverFluxo {

    private final List<Nodo> nodos;

    private final int nodoInicio;
    private final int nodoFim;

    public ResolverFluxo(List<Nodo> nodos, int nodoInicio, int nodoFim) {
        this.nodos = nodos;
        this.nodoInicio = nodoInicio;
        this.nodoFim = nodoFim;
        inicializar();
    }

    public void inicializar() {
        for (Nodo nodo : nodos) {

            List<Caminho> caminhos = nodo.getCaminhos();

            for (Caminho c : caminhos) {
                Nodo nodoPara = getNodoNumero(c.getPara());
                if (!nodoPara.temPara(nodo.getNumero())) {
                    nodoPara.addCaminho(c.getPara(), nodo.getNumero(), 0);
                }
            }
        }
    }

    public void resolver() {

        List<Caminho> caminhos;
        int vazao;

        for (Nodo nodo : nodos) {
            System.out.println(nodo.toString());
        }

        caminhos = getCaminhoMaiorPeso();

        vazao = menorDistanciaCaminhos(caminhos);
        System.out.println(vazao);
        do {

            aplicaVazao(caminhos, vazao);
            caminhos = getCaminhoMaiorPeso();
            vazao = menorDistanciaCaminhos(caminhos);
            System.out.println(vazao);

        } while (vazao != 0);

        for (Nodo nodo : nodos) {
            System.out.println(nodo.toString());
        }
    }

    public void aplicaVazao(List<Caminho> caminhos, int vazao) {

        for (Caminho caminho : caminhos) {
            Nodo de = getNodoNumero(caminho.getDe());
            Nodo para = getNodoNumero(caminho.getPara());

            de.subtrairDistancia(caminho.getDe(), caminho.getPara(), vazao);
            para.somarDistancia(caminho.getPara(), caminho.getDe(), vazao);

        }
    }

    public int menorDistanciaCaminhos(List<Caminho> caminho) {

        Caminho caminhoMenorDistancia = caminho.get(0);

        for (Caminho c : caminho) {
            if (c.getDistancia() < caminhoMenorDistancia.getDistancia()) {
                caminhoMenorDistancia = c;
            }
        }

        return caminhoMenorDistancia.getDistancia();
    }

    public Nodo getNodoNumero(int numero) {
        for (Nodo nodo : nodos) {
            if (nodo.getNumero() == numero) {
                return nodo;
            }
        }
        return null;
    }

    public List<Caminho> getCaminhoMaiorPeso() {
        List<Caminho> caminhos = new LinkedList<>();
        List<Integer> blackList = new LinkedList<>();

        Nodo nodoAtual = getNodoNumero(nodoInicio);
        blackList.add(nodoAtual.getNumero());

        do {

            caminhos.add(nodoAtual.getMaiorCaminho(blackList));
            nodoAtual = getNodoNumero(caminhos.get(caminhos.size() - 1).getPara());

            /*

            if (caminhos.get(0).getDistancia() != 0) {

                while (caminhos.get(caminhos.size() - 1).getDistancia() == 0) {
                    Integer irPara = caminhos.get(caminhos.size() - 2).getDe();
                    Integer rmPara = caminhos.get(caminhos.size() - 1).getPara();

                    System.out.println("Ir para: " + irPara + " Rm para: " + rmPara);
                    nodoAtual = getNodoNumero(irPara);

                    blackList.remove(rmPara);

                    System.out.println("Test i");
                    System.out.println(caminhos.get(caminhos.size() - 1).toString());
                    System.out.println("Test f");

                    caminhos.remove(caminhos.size() - 1);

                }

                if (nodoAtual.todosBlackList(blackList)) {
                    if (caminhos.get(caminhos.size() - 1).getDistancia() == 0) {
                        Integer irPara = caminhos.get(caminhos.size() - 2).getDe();
                        Integer rmPara = caminhos.get(caminhos.size() - 1).getPara();

                        System.out.println("Ir para: " + irPara + " Rm para: " + rmPara);
                        nodoAtual = getNodoNumero(irPara);

                        blackList.remove(rmPara);

                        System.out.println("Test i");
                        System.out.println(caminhos.get(caminhos.size() - 1).toString());
                        System.out.println("Test f");

                        caminhos.remove(caminhos.size() - 1);

                    }
                }
            }
            */
            if (!blackList.contains(nodoAtual.getNumero())) {
                blackList.add(nodoAtual.getNumero());
            }

            System.out.println(caminhos.get(caminhos.size() - 1).toString());

        } while (nodoAtual.getNumero() != nodoFim);

        System.out.println("*i*");
        for (Caminho caminho : caminhos) {
            System.out.println(caminho.toString());
        }
        System.out.println("*f*");

        return caminhos;
    }
}
