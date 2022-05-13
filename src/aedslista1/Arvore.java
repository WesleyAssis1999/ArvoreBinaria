
package aedslista1;

import java.util.LinkedList;
/*
Wesley Assis
*/
public class Arvore {
    // raiz da árvore
    private static No raiz;

    
// Construtor
    Arvore() {
        raiz = null;
    }

    public static Arvore leitura(String entrada) {
        Arvore a = new Arvore();
        escritaArvore(entrada);
        return a;
    }

    private static void escritaArvore(String entrada) {
        String[] strEntrada = entrada.split(" ");
        LinkedList<String> ent = new LinkedList<>();
        LinkedList<No> list = new LinkedList<>();

        for (String value : strEntrada) {
            ent.addLast(value);
        }

        setRaiz(new No(Integer.parseInt(ent.removeFirst())));

        list.addLast(raiz);

        while (!list.isEmpty()) {
            No current = list.removeFirst();

            if (!ent.isEmpty()) {
                if (current.getEsq() == null) {
                    current.setEsq(new No(Integer.parseInt(ent.removeFirst())));
                    list.addLast(current.getEsq());
                }
            }

            if (!ent.isEmpty()) {
                if (current.getDir() == null) {
                    current.setDir(new No(Integer.parseInt(ent.removeFirst())));
                    list.addLast(current.getDir());
                }
            }
        }
    }

    public int numeroNos() {
        return numeroNos(raiz);
    }
//Metodo auxiliar (privado)
//Se n for vazio então retornara 1.
    public int numeroNos(No n) {
        if (n == null) return 0;
        return 1 + numeroNos(n.getEsq()) + numeroNos(n.getDir());
    }

    public int altura() {
        return altura(raiz);
    }
//Se n for vazio então retornara -1.
    private int altura(No n) {
        if (n == null) return -1;
//Retornando o maior numero da Esquerda e Direita.
        return 1 + Math.max(altura(n.getEsq()), altura(n.getDir()));
    }

    public boolean contem(int valor) {
        return contem(raiz, valor);
    }

    private boolean contem(No n, int valor) {
        if (n == null) return false;
        if (n.getValue() == valor) return true;

        return contem(n.getEsq(), valor) || contem(n.getDir(), valor);
    }
/////////////////////////////////////////////
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(raiz);
        System.out.println();
    }
//Colocando os numeros em Pre Ordem (começa a partir da raiz.)
    private void printPreOrder(No n) {
        if (n == null) return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getEsq());
        printPreOrder(n.getDir());
    }
////////////////////////////////////////////
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(raiz);
        System.out.println();
    }
//Colocando os numeros Em Ordem 
//(Partindo da folha para raiz do lado esquerdo, depois a raiz, depois o lado direito.)
    private void printInOrder(No n) {
        if (n == null) return;
        printInOrder(n.getEsq());
        System.out.print(" " + n.getValue());
        printInOrder(n.getDir());
    }
////////////////////////////////////////////
    public void printPostOrder() {
        System.out.print("PostOrder :");
        printPostOrder(raiz);
        System.out.println();
    }
//Colocando os numeros em Pos Ordem (Comeca a partir das folhas e o ultimo é a raiz.)
    private void printPostOrder(No n) {
        if (n == null) return;
        printPostOrder(n.getEsq());
        printPostOrder(n.getDir());
        System.out.print(" " + n.getValue());
    }
//////////////////////////////////////////////
    public void printBreadthFirstSearch() {
        System.out.print("BFS:");
        printBreadthFirstSearch(raiz);
        System.out.println();
    }

//Pesquisa em Largura/ Breadth-First Search (BFS)   
//conta com a travessia de nódulos pela adição do vizinho de cada nó que parte
//do nó raiz à fila de travessia.
    private void printBreadthFirstSearch(No n) {
        LinkedList<No> list = new LinkedList<>();

        list.addLast(n);

        while (!list.isEmpty()) {
            No current = list.removeFirst();

            System.out.print(" " + current.getValue());

            if (current.getEsq() != null) list.addLast(current.getEsq());
            if (current.getDir() != null) list.addLast(current.getDir());
        }
    }

    public boolean contem2(int value) {
        return contem2(raiz, value);
    }

    private boolean contem2(No n, int value) {
        if (n == null) return false;

        if (value < n.getValue()) {
            return contem2(n.getEsq(), value);
        }

        if (value > n.getValue()) {
            return contem2(n.getDir(), value);
        }
        return true;
    }
//Verifica se o valor inserido contém na Árvore
    public boolean insert(int value) {
        if (contem2(value)) return false;
        raiz = insert(raiz, value);
        return true;
    }
//Inserindo os valores para esquerda e depois para direita.
    private No insert(No n, int value) {
        if (n == null) return new No(value);
        if (value < n.getValue()) n.setEsq(insert(n.getEsq(), value));
        if (value > n.getValue()) n.setDir(insert(n.getDir(), value));
        return n;
    }

    public No getRaiz() {
        return raiz;
    }

    public static void setRaiz(No raiz) {
        Arvore.raiz = raiz;
    }
}
