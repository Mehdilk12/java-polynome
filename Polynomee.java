/*
travail fait par mohamed mehdi lakhdhar
 */
package polynome1;

public class Polynome {
    
    private class Node{
         double coef;
         int puissance;
         Node prochain;

        public Node(double coef, int puissance) {
            this.coef = coef;
            this.puissance = puissance;
            this.prochain = null;
        }
         
         
    }
   
    Node n;

    public Polynome() {
        this.n = null;
    }   
 
    
    public Polynome(double coef,int puissance)
    {
        Node node = new Node(coef, puissance);
        this.n = node;
    }
    

    /**
     * Additionne un terme cx^e au polynome.
     *
     * @param coeff coefficient c du terme à ajouter
     * @param exposant exposant e du terme à ajouter
     */
    public void ajouter(double coeff, int exposant) 
        {
        Node newNode = new Node(coeff,exposant);
        Node ptr = this.n;
 
        if (n == null) 
            n = newNode;
        else {
            while(ptr != null){
                 if (ptr.puissance == exposant){
               ptr.coef += coeff;
               break;
            }
            if (ptr.prochain == null){
            Node p = new Node(coeff, exposant);  
            ptr.prochain = p;
            break;
            }
                ptr = ptr.prochain;
            }
            ptr = newNode;
        }
    
        sort();
        
    
    }
    

    /**
     * Addition d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à additionner
     * @return un nouveau polynome contenant le résultat de
     * l'addition
     */
    public Polynome additionner(Polynome autre) {
        Polynome resultat = new Polynome();
        Node ptr = this.n;
        Node ptr2 = autre.n;
        while (ptr != null)
        {
            resultat.ajouter(ptr.coef, ptr.puissance);
            ptr = ptr.prochain;
        }
        while (ptr2 != null)
        {
            resultat.ajouter(ptr2.coef, ptr2.puissance);
            ptr2 = ptr2.prochain;
        }

        return resultat;
    }
	
    /**
     * Multiplication par une constante. Cette fonction ne modifie pas
     * le polynome actuel.
     *
     * @param c constante multiplicative
     * @return un nouveau polynome correspondant au polynome actuel
     * (this) multiplié par une constante
     */
    public Polynome multiplier(double c) {
        Polynome resultat = new Polynome();
        Node ptr = this.n;
        while (ptr != null)
        {
            resultat.ajouter(ptr.coef * c, ptr.puissance);
            ptr = ptr.prochain;
        }

        return resultat;
    }

    /**
     * Multiplication d'un polynome par un autre. Cette fonction ne
     * modifie pas le polynome actuel.
     *
     * @param autre le polynome à multiplier
     * @return un nouveau polynome contenant le résultat de la
     * multiplication
     */
    public Polynome multiplier(Polynome autre) {
        Polynome resultat = new Polynome();
        Node ptr = this.n;
        while (ptr != null)
        {
            
            Node ptr2 = autre.n;
            while (ptr2 != null)
            {
            resultat.ajouter(ptr.coef * ptr2.coef, ptr.puissance+ptr2.puissance);
            ptr2 = ptr.prochain;
            }
            
            ptr = ptr.prochain;
        }

        return resultat;

    }

    /**
     * Retourne la dérivée sous la forme d'un nouveau polynome. Cette
     * fonction ne modifie pas le polynome actuel.
     *
     * @return la dérivée du polynome actuel sous la forme d'un
     * nouveau polynome
     */
    public Polynome derivee() {
        Polynome derivee = new Polynome();
        Node ptr = this.n;
        
        while (ptr != null)
        {
            if(ptr.puissance >= 1)
            derivee.ajouter(ptr.coef * ptr.puissance, ptr.puissance - 1);
            else 
            derivee.ajouter(0,0);
        
            ptr = ptr.prochain;
        }
        
        return derivee;
    }

    /**
     * Fonction utilitaire pour tester la classe.
     *
     * @param test résultat du test unitaire
     * @param message description du test
     */
    public static void assertTest(boolean test, String message) {
        if(test) {
            System.out.println("OK: " + message);
        } else {
            System.out.println("ERREUR: " + message);
        }
    }

    @Override
    public String toString() {
        Node ptr = this.n;
        String s = "";
        boolean test = false;
        int i=0 ;
        
        if (ptr.coef == 0 && ptr.prochain == null)
            return "0";
                
        while (ptr != null)
        {
            if ((ptr.coef == Math.floor(ptr.coef)) && !Double.isInfinite(ptr.coef)) {
                i = (int) ptr.coef;
                test = true;
               
            }
            if (ptr.coef != 0){
                switch (ptr.puissance) {
                    case 0:
                        if (test){
                            s+= i ;
                        }
                        else
                        s += ptr.coef;
                        break;
                    case 1:
                         if (test)
                            s+= i ;
                        
                        else
                             s += ptr.coef;
                        s+="x";
                        break;
                    default:
                         if (test)
                            s+= i ;
                        
                        else
                             s += ptr.coef;
                         s+= "x^"+ptr.puissance;
                        break;
                }
                 if(ptr.prochain != null ){
                     if (ptr.prochain.coef != 0)
                     s+=" + ";
                 }
            }
           
            test = false;
            ptr = ptr.prochain;
        }
        return s ;
    }
    
    public void sort(){
        Node current = this.n,
            index = null;
 
        int tempPuissance;
        double tempcoef;
 
        if (current == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.prochain;
 
                while (index != null) {
                    if (current.puissance < index.puissance) {
                        tempPuissance = current.puissance;
                        tempcoef = current.coef;
                        
                        current.coef = index.coef;
                        current.puissance = index.puissance;
                        
                        index.coef = tempcoef;
                        index.puissance = tempPuissance;
                    }
 
                    index = index.prochain;
                }
                current = current.prochain;
            }
        }
    }
 

    /**
     * À compléter : quelques tests pour vous aider
     */
    public static void main(String[] args) {

        Polynome p = new Polynome();
        p.ajouter(10, 0);
        assertTest(p.toString().equals("10"), "Un seul terme (constante)");

        p = new Polynome();
        p.ajouter(10, 1);
        assertTest(p.toString().equals("10x"), "Un seul terme (exposant=1)");

        p = new Polynome();
        p.ajouter(10, 2);
        assertTest(p.toString().equals("10x^2"), "Un seul terme (exposant=2)");

        p.ajouter(5, 4);
        assertTest(p.toString().equals("5x^4 + 10x^2"), "Deux termes");
//
      p.ajouter(3, 2);

      assertTest(p.toString().equals("5x^4 + 13x^2"), "Ajouter à un terme déjà présent");

       p.ajouter(7, 0);

       assertTest(p.toString().equals("5x^4 + 13x^2 + 7"), "Ajouter une constante");

      p.ajouter(-22, 3);

      assertTest(p.toString().equals("5x^4 + -22x^3 + 13x^2 + 7"), "Ajouter un coefficient négatif");

      Polynome derivee = p.derivee();

        assertTest(derivee.toString().equals("20x^3 + -66x^2 + 26x"), "Dérivée");

        derivee = p.derivee().derivee().derivee().derivee();

       assertTest(derivee.toString().equals("120"), "Dérivée 4 fois");

        derivee = p.derivee().derivee().derivee().derivee().derivee()
                   .derivee().derivee().derivee().derivee().derivee();

       assertTest(derivee.toString().equals("0"), "Dérivée 10 fois");

    }
    
    
    
}