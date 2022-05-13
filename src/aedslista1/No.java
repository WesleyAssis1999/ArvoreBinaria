
package aedslista1;
/*
Wesley Assis
*/
public class No {
    private int value;
    private No esq;
    private No dir;

    No(int value) {
        this.value = value;
        this.esq = null;
        this.dir = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }
}
