package com.josemanuel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.josemanuel.funcion.FuncionArea;
import com.josemanuel.funcion.FuncionExitMenu;
import com.josemanuel.funcion.FuncionResta;
import com.josemanuel.funcion.FuncionSuma;
import com.josemanuel.menu.ExitMenuException;
import com.josemanuel.menu.ItemMenu;
import com.josemanuel.menu.Menu;

public class SuperCalculadora {

    public SuperCalculadora() {
        sc = new Scanner(System.in);
        this.inicializaMenus();
    }

    private Scanner sc;
    private Menu menuPrincipal;

    /*
     * -- MÉTODO MAIN --
     * 
     * Crea una instancia del objeto 'SuperCalculadora' con el nombre
     * superCalculadora;
     * 
     */
    public static void main(String[] args) {
        SuperCalculadora superCalculadora = new SuperCalculadora();

        try {
            superCalculadora.getMenuPrincipal().bucle();
        } catch (ExitMenuException eme) {
            System.out.println("FIN SUPERCALCULADORA");
            superCalculadora.getSc().close();
        }

    }

    /*
     * -- INICIALIZA MENÚS --
     * 
     * Método privado que se encarga de mostrar el menú con las diferentes opciones
     * y recibir por teclado la opción
     * 
     */
    private void inicializaMenus() {

        /* Declaración de variables */
        String introOpc = "Introduzca opción:";
        ItemMenu itemMenuExit = new ItemMenu("Salir", new FuncionExitMenu());


        /* MENÚ ARITMÉTICA */
        Map<String, ItemMenu> mapItemMenuAritmetica = new HashMap<String, ItemMenu>();


        /* OPCIÓN '1' realizar suma mediante la función 'FuncionSuma() */
        mapItemMenuAritmetica.put("1", new ItemMenu("Operación suma", new FuncionSuma()));


        /* OPCIÓN '2' realizar suma mediante la función 'FuncionResta() */
        mapItemMenuAritmetica.put("2", new ItemMenu("Operación resta", new FuncionResta()));


        /* OPCIÓN 'X' salir del menú */
        mapItemMenuAritmetica.put("X", itemMenuExit);

        /*
         * ARITMÉTICA
         * -- Se muestra el mensaje y se recoge el dato introducido por teclado con la
         * variable this.sc
         */
        Menu menuAritmetica = new Menu("Menú de Aritmética", introOpc, mapItemMenuAritmetica, this.sc);

      
        /* ÁREA POLÍGONO REGULAR */
        Map<String, ItemMenu> mapItemMenuAreaPi = new HashMap<String, ItemMenu>();
        mapItemMenuAreaPi.put("1", new ItemMenu("Área polígono regular", new FuncionArea()));
        mapItemMenuAreaPi.put("X", itemMenuExit);

        // mapItemMenuAreaPi.put("2", new ItemMenu("Tm. de Pitágoras", new
        // FuncionResta()));

        /*
         * ÁREA Y TEOREMA DE PITÁGORAS
         * -- Se muestra el mensaje y se recoge el dato introducido por teclado con la
         * variable this.sc
         */
        Menu menuAreaPi = new Menu("Menú de área y Tm. de Pitágoras", introOpc, mapItemMenuAreaPi, this.sc);

        /* Se muestra el menú principal */
        Map<String, ItemMenu> mapItemMenuPrincipal = new HashMap<String, ItemMenu>();

        
        /* OPCIÓN 'A' carga el menú de aritmética*/
        mapItemMenuPrincipal.put("A", new ItemMenu("Aritmética", menuAritmetica));

        
        /* OPCIÓN 'B' carga el menú AreaPi */
        mapItemMenuPrincipal.put("B", new ItemMenu("Área polígono regular y Tm. de Pitágoras", menuAreaPi));

        
        /* OPCIÓN 'X' salir del menú */
        mapItemMenuPrincipal.put("X", itemMenuExit);

        /* Se crea una nueva instancia del menú principal 'this.menuPrincipal' */
        this.menuPrincipal = new Menu("Menú principal de Supercalculadora", introOpc, mapItemMenuPrincipal, this.sc);

    }

    /* Método que devuelve el menú principal */
    public Menu getMenuPrincipal() {
        return menuPrincipal;
    }

    /* Obtención del Scanner (Datos introducidos por teclado) */
    public Scanner getSc() {
        return sc;
    }

}
