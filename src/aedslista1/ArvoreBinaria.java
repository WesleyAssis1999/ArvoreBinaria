
package aedslista1;

/*
Wesley Assis
*/
import java.util.Scanner;

public class ArvoreBinaria {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com valores inteiros (ex: 1 2 3 4...): ");

        Arvore a = Arvore.leitura(entrada.nextLine());

        System.out.println("numberNodes = " + a.numeroNos());

        System.out.println("contains (2) = " + a.contem(2));
        System.out.println("contains (3) = " + a.contem(3));
        System.out.println("contains (7) = " + a.contem(7));
        System.out.println("Altura da arvore = " + a.altura());
        a.printPreOrder();
        a.printInOrder();
        a.printPostOrder();
        a.printBreadthFirstSearch();
    }

}

/*
EX de entrada: 
1 2 3 4 5 6 7 8
*/
