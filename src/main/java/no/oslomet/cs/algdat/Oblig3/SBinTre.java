package no.oslomet.cs.algdat.Oblig3;


import java.util.*;

public class SBinTre<T> {

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
        Node<T> currentNode = rot;
        Node<T> nextNode = null;
        //comparator
        int compare = 0;
        //as long as currentnode is not null
        while (currentNode != null) {
            nextNode = currentNode;
            compare = comp.compare(verdi, currentNode.verdi);
            currentNode = compare < 0 ? currentNode.venstre : currentNode.høyre; //compare < 0 = currentNode = left child, else currentNode = rightchild

        }
        //currentNode is null, creates a new node
        currentNode = new Node<>(verdi, nextNode);
        if (nextNode == null) rot = currentNode; //if nextNode = null, root = currentNode
        else if (compare < 0) nextNode.venstre = currentNode; //if compare < 0 left child is the current node
        else nextNode.høyre = currentNode; //else right child is current

        antall++;
        return true;
    }

    public boolean fjern(T verdi) {
        if (verdi == null) return false;
        Node<T> p = rot, q = null;
        while (p != null) {
            int cmp = comp.compare(verdi, p.verdi);
            if (cmp < 0) {
                q = p;
                p = p.venstre;
            } else if (cmp > 0) {
                q = p;
                p = p.høyre;
            } else break;
        }
        if (p == null) return false;
        if (p.venstre == null || p.høyre == null) {
            Node<T> b = p.venstre != null ? p.venstre : p.høyre;
        }
    }

    public int fjernAlle(T verdi) {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    public int antall(T verdi) {
        Node<T> currentLeaf = rot;//Starts at root, runs trought the entire
        int numberOfreturns = 0;
        if (!inneholder(verdi)) return 0;
        while (currentLeaf != null) {
            int com = comp.compare(verdi, currentLeaf.verdi);

            if (com < 0) {
                currentLeaf = currentLeaf.venstre; //if the values does not match, continue the traverse
            } else {
                if (com == 0) {
                    numberOfreturns++; // if it is the same add to the counter
                }
                currentLeaf = currentLeaf.høyre; //checks the right

            }
        }
        return numberOfreturns; //return the number

    }

    public void nullstill() {
        throw new UnsupportedOperationException("Ikke kodet ennå!");
    }

    private static <T> Node<T> førstePostorden(Node<T> p) {
        //from the compendium, mostly (5.1.7 h)
        while (true) {
            // if the left child has a value, p equals to left child
            if (p.venstre != null) {
                p = p.venstre;
            } else if (p.høyre != null) {
                p = p.høyre; //same as with left, but with right
            } else {
                return p; //returns the first in post order
            }
        }
    }

    private static <T> Node<T> nestePostorden(Node<T> p) {
        //finds the next value in post order
        if (p.forelder == null) return null;
        //if p equals to the right child of the parent, returns the parent
        if (p == p.forelder.høyre) return p.forelder;
            // if the parent is not not null
        else if (p.forelder.venstre != null) {
            if (p.forelder.høyre == null) return p.forelder; //if there is only a left node, next is the parent
        }
        return førstePostorden(p.forelder.høyre);


    }

    public void postorden(Oppgave<? super T> oppgave) {
        Node<T> p = førstePostorden(rot); //finds the first post order


        while (p != null) {
            oppgave.utførOppgave(p.verdi); //calls the interface utføroppgave with the value of p
            p = nestePostorden(p);   //finds and set the next post order during the entire tree
        }
    }

    public void postordenRecursive(Oppgave<? super T> oppgave) {
        postordenRecursive(rot, oppgave);
    }

    private void postordenRecursive(Node<T> p, Oppgave<? super T> oppgave) {
        //recurse baby!
        if (p == null) return;
        //if it is a value at the left side
        if (p.venstre != null) {
            postordenRecursive(p.venstre, oppgave);//recursive call for the left side
        }
        if (p.høyre != null) {
            postordenRecursive(p.høyre, oppgave); //recursive call for the right side
        }
        oppgave.utførOppgave(p.verdi); // calls utførOppgave
    }

    public ArrayList<T> serialize() {
        Node<T> current = rot; //starts at root;
        ArrayDeque<Node<T>> deque = new ArrayDeque<>();
        ArrayList<T> list = new ArrayList<>();
        deque.addLast(current);
        while (!deque.isEmpty()) {
            Node<T> a = deque.pop();
            list.add(a.verdi);
            if (a.venstre != null) deque.add(a.venstre);
            if (a.høyre != null) deque.add(a.høyre);

        }

        return list;
    }

    static <K> SBinTre<K> deserialize(ArrayList<K> data, Comparator<? super K> c) {
        SBinTre<K> tre = new SBinTre<>(c);
        for (K i : data) {
            tre.leggInn(i);
        }
        return tre;
    }


} // ObligSBinTre
