package com.josemanuel.menu;

import java.util.Scanner;
import java.util.function.Function;

/* CLASE ItemMenu

    Se encarga de declarar las variables para mostrar los mensajes del menú y el sub menú mediante get(),
    así como de obtener los datos introducidos por teclado getItemFunctionMenu()

*/
public class ItemMenu {

    private String mensajeMenu;
    private Menu subMenu;
    private Function<Scanner, Void> itemMenuFuncion;

    /* Declaración de variables 'mensajeMenu' y 'subMenu' */
    public ItemMenu(String mensajeMenu, Menu subMenu) {
        this.subMenu = subMenu;
        this.mensajeMenu = mensajeMenu;        
    }


    public ItemMenu(String mensajeMenu, Function<Scanner, Void> itemMenuFuncion) {
        this.mensajeMenu = mensajeMenu;
        this.itemMenuFuncion = itemMenuFuncion;
    }

    /* GETTERS Y SETTERS */
    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu subMenu) {
        this.subMenu = subMenu;
    }

    public String getMensajeMenu() {
        return mensajeMenu;
    }

    public void setMensajeMenu(String mensajeMenu) {
        this.mensajeMenu = mensajeMenu;
    }

    public Function<Scanner, Void> getItemMenuFuncion() {
        return itemMenuFuncion;
    }

}
