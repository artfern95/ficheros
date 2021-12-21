package ej1;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ficheros_func {

    private List<usuario> ListaUsuarios;

    public ficheros_func() {

        ListaUsuarios = new ArrayList<usuario>();
    }

    public void LeerFicheroCsv (String fichero){

        int c = 0, cont = 0;
        char letra = 0;
        String cadena = "", correo = "", nombrecompleto = "", usuario = "";
        usuario usuario1;

        try {

            FileReader entrada = new FileReader(fichero);

            while(c != -1){

                c = entrada.read();
                letra = (char)c;

                if(c == 59 || c == 13){

                    if(cont == 0){

                        correo = cadena;
                        cont ++;
                        cadena = "";
                    }

                    else if(cont == 1){

                        nombrecompleto = cadena;
                        cont ++;
                        cadena= "";
                    }

                    else if(cont == 2 || c == 10){

                        usuario = cadena;
                        cont = 0;
                        cadena = "";
                        usuario1 = new usuario(nombrecompleto,correo,usuario);
                        ListaUsuarios.add(usuario1);


                        nombrecompleto = "";
                        correo = "";
                        usuario = "";
                    }
                }

                else {

                    cadena = cadena + letra;
                }

            }

            entrada.close();
            System.out.println("Fichero leido");
            mostrarArray();
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }

    private boolean validarCorreo (String correo) {

        for(usuario usuario : ListaUsuarios){

            if(usuario.getEmail().equals(correo)){

                return false;
            }
        }

        return true;
    }

    private void mostrarArray (){

        for(usuario usuario : ListaUsuarios){

            System.out.println(usuario.toString());
        }
    }
}
