package com.josemanuel.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

/* CLASE MENÚ */
public class Menu {


    /* Declaración de variables */
    
    private Scanner sc;
    private String titulo;
    private String input;
    private Map<String, ItemMenu> mapItemMenu;
    

    /* Constructor de la clase */

    public Menu(String titulo, String input, Map<String, ItemMenu> mapItemMenu, Scanner sc) {

        this.sc = sc;
        this.mapItemMenu = mapItemMenu;
        this.titulo = titulo;
        this.input = input;

    }

    /*  MÉTODO RENDERIZA 

        Se encarga de mostrar el menú con las distintas opciones

    */
    public void renderiza() {

        System.out.println(titulo);
         
        this.mapItemMenu.forEach((k, v) -> {
            System.out.println(k + ".- " + v.getMensajeMenu());
        });

        System.out.println(this.input);

    }

    /* Bucle do-while que muestra el menú y comprueba la opción introducida */
    public void bucle() throws ExitMenuException {
        
        
        do{

            this.renderiza();            
            String next = sc.next();
            ItemMenu itemMenuSelect = this.mapItemMenu.get(next);
 
            /* Comprobamos que se ha elegido una opción */

            if (itemMenuSelect != null) {
                Menu subMenu;
                if ((subMenu = itemMenuSelect.getSubMenu())!= null) {                
                    try {
                        subMenu.bucle();
                    } catch(ExitMenuException eme) {                    
                    }
                } 

            /* Si la opción introducida por teclado no es un dato nulo, se recoge el dato */

                Function<Scanner, Void> itemMenuFuncion;
                if ((itemMenuFuncion = itemMenuSelect.getItemMenuFuncion()) != null) {
                    itemMenuFuncion.apply(sc);
                }
                  
            } 
            
            /* Si los datos no son correctos, se muestra el mensaje 'Opción no válida, inténtelo de nuevo' */
            else {
                System.out.println("Opción no válida, inténtelo de nuevo");
            }
            
        } while(true);

    }



    
    
}
