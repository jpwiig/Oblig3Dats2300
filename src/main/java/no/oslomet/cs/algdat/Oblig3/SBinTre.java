package no.oslomet.cs.algdat.Oblig3;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringJoiner;

public class SBinTre<T> {
    public static void main(String[] args) {
        //test for the tree
    //  Integer[] a1 = {4,7,2,9,5,10,8,1,3,6};
      // SBinTre<Integer> tre = new SBinTre<>(Comparator.naturalOrder());
      // for (int verdi : a1) {
        //   tre.leggInn(verdi);
        // }
        //System.out.println(tre.antall()); // Utskrift: 10

        Integer[] a = {4,7,2,9,4,10,8,7,4,6};
        SBinTre<Integer> tree = new SBinTre<>(Comparator.naturalOrder());
            for (int verdi : a) { tree.leggInn(verdi); }
        System.out.println(tree.antall()); // Utskrift: 10
        System.out.println(tree.antall(5)); // Utskrift: 0
        System.out.println(tree.antall(4)); // Utskrift: 3
        System.out.println(tree.antall(7)); // Utskrift: 2
        System.out.println(tree.antall(10)); // Utskrift: 1

    }
    private static final class Node<T>   // en indre nodeklasse
    {
        private T verdi;                   // nodens verdi
        private Node<T> venstre, høyre;    // venstre og høyre barn
        private Node<T> forelder;          // forelder

        // konstruktør
        private Node(T verdi, Node<T> v, Node<T> h, Node<T> forelder) {
            this.verdi = verdi;
            venstre = v;
            høyre = h;
            this.forelder = forelder;
        }

        private Node(T verdi, Node<T> forelder)  // konstruktør
        {
            this(verdi, null, null, forelder);
        }

        @Override
        public String toString() {
            return "" + verdi;
        }

    } // class Node

    private Node<T> rot;                            // peker til rotnoden
    private int antall;                             // antall noder
    private int endringer;                          // antall endringer

    private final Comparator<? super T> comp;       // komparator

    public SBinTre(Comparator<? super T> c)    // konstruktør
    {
        rot = null;
        antall = 0;
        comp = c;
    }

    public boolean inneholder(T verdi) {
        if (verdi == null) return false;

        Node<T> p = rot;

        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) p = p.venstre;
            else if (cmp > 0) p = p.høyre;
            else return true;
        }

        return false;
    }

    public int antall() {
        return antall;
    }

    public String toStringPostOrder() {
        if (tom()) return "[]";

        StringJoiner s = new StringJoiner(", ", "[", "]");

        Node<T> p = førstePostorden(rot); // går til den første i postorden
        while (p != null) {
            s.add(p.verdi.toString());
            p = nestePostorden(p);
        }

        return s.toString();
    }

    public boolean tom() {
        return antall == 0;
    }

    public boolean leggInn(T verdi) {
        //rewritten from kompendie programkode 5.2.3
        Objects.requireNonNull(verdi, "Null verdier er ikke lov!!");
        Node<T>currentNode =  rot;
        Node<T>prevNode = null;
        int compare = 0;
        while (currentNode != null){
            prevNode = currentNode;
            compare = comp.compare(verdi, currentNode.verdi);
            currentNode =  compare < 0 ? currentNode.venstre : currentNode.høyre;
            //The node is a root

        }
        currentNode = new Node<>(verdi,prevNode);
        if (prevNode == null) rot = currentNode;
        else if (compare < 0) currentNode.venstre =  prevNode;
        else currentNode.høyre = prevNode;

        antall++;
        return true;
    }

    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        int numberOfreturns = 0;
        int length = antall();
        System.out.println("antall: " + length);
        Node<T> currentLeaf = rot;//Starts at root, runs trought the entire
        if (inneholder(verdi)) {
            //traverse the binary tree
            // checks the parent
            //since were not checking which node has the same value you traverse with only the value
            // if (currentLeaf.verdi == verdi) numberOfreturns++; //checks value of root
            while(currentLeaf != null){
              //  System.out.println(currentLeaf.verdi);
                currentLeaf = currentLeaf.høyre;
                int com = comp.compare(verdi, currentLeaf.verdi);
                if (com < 0) numberOfreturns++;
                System.out.println(numberOfreturns);
                currentLeaf = currentLeaf.venstre;
            }
    }  else {
          return 0;
      }
       return numberOfreturns;
    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postorden(Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public ArrayList<T> serialize() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }


} // ObligSBinTre
