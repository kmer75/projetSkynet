/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetskynet;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 *
 * @author kevin
 */
public class ProjetSkynet {

     public static String[] split(String chaine, String car) {
        String[] parts = chaine.split(car);
        return parts;
     }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        List<String> listeLinks = new ArrayList();//Liste des liens : 
        List<String> listeGatewayLinks = new ArrayList(); //Liste des liens ayant un noeud gateway
        List<Integer> listIndexGateway = new ArrayList(); //Liste des emplacements des noeuds gateway
        Integer index = -1; // valeur retourné par indexOf, par defaut initialisé à -1
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            listeLinks.add("-"+N1+"-"+N2+"-"); //liste de tout les liens
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            listIndexGateway.add(EI); //liste des positions des gateway
        }

        /* 1/ on isole les liens ayant comme noeud le gateway */
        
        for(Integer y : listIndexGateway) {        
        for(String ls : listeLinks) {
            if(ls.contains("-"+y+"-"))
                listeGatewayLinks.add(ls);
            }
        }
        
        
        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            /* 2/ on traite cette nvl liste gateway pour enfermer l'agent sktynet */
        
                /*2/a. on regarde en premier si l'agent est sur un noeud ayant un lien direct avec le gateway*/
        
            
        for(Integer y : listIndexGateway) {
            
       if(listeGatewayLinks.indexOf("-"+y + "-" + SI+"-") >= 0) {
          index = listeGatewayLinks.indexOf("-"+y + "-" + SI+"-");
           String[] parts = split(listeGatewayLinks.get(index), "-");
           System.err.println("a supprime le lien au 1er cas: "+parts[1]+ " " + parts[2]);
           System.out.println(parts[1]+ " " + parts[2]);
       } else if(listeGatewayLinks.indexOf("-"+SI + "-" + y+"-") >= 0) {
           index = listeGatewayLinks.indexOf("-"+SI + "-" + y+"-");
           String[] parts = split(listeGatewayLinks.get(index), "-");
           System.err.println("a supprime le lien au 2e cas: "+parts[1]+ " " + parts[2]);
           System.out.println(parts[1]+ " " + parts[2]);
       }
       
       
   
} // fin for tableau EI

/* 2/b. si le lien n'est pas direct, on elimine un lien au hasard */

if(index == -1) {
    
    for(String s : listeLinks)
    {
               String[] parts = split(s , "-");
               System.err.println("a supprime le lien au 3e cas: "+parts[1]+ " " + parts[2]);
                System.out.println(parts[1]+ " " + parts[2]);
                 break;
              
           } //fin for
    
    } //fin if
        } //fin while
        
    }
    
}
