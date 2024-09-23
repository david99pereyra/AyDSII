package com.tp.tp3;

import static spark.Spark.*;

import com.tp.tp3.controller.CelsiusFahrenheitController;
import com.tp.tp3.controller.ChisteController;
import com.tp.tp3.controller.ClimaController;
import com.tp.tp3.controller.ConvertidorController;
import com.tp.tp3.controller.EsParController;
import com.tp.tp3.controller.EsPrimoController;
import com.tp.tp3.controller.HoraController;
import com.tp.tp3.controller.InvertirController;
import com.tp.tp3.controller.LibroController;
import com.tp.tp3.controller.UsuarioController;

public class Main {
    public static void main(String[] args) {

        port(1234);

        // EJ1
        CelsiusFahrenheitController cf = new CelsiusFahrenheitController();
        get("/celsiusAfahrenheit/:celsius", cf.convetir);

        // EJ2
        EsPrimoController primo = new EsPrimoController();
        get("/esPrimo/:numero", primo.primo);

        // EJ3
        EsParController par = new EsParController();
        get("/esPar/:numero", par.esPar);

        // EJ4
        InvertirController invertir = new InvertirController();
        get("/invertir/:cadena", invertir.invertir);

        // EJ5
        HoraController hora = new HoraController();
        get("/hora/:segundo", hora.segundoAHora);

        // Ej6
        UsuarioController usuario = new UsuarioController();
        post("/usuarios", usuario.crearUsuario);
        get("/usuarios/:id", usuario.obtenerUsuario);
        get("/usuarios", usuario.obtenerUsuarios);
        put("/usuarios", usuario.actualizarUsuario);
        delete("/usuarios", usuario.eliminarUsuario);

        // EJ7 Implementar un servicio RESTful con la ruta /libros para obtener la lista
        // de libros y /libros/:id para obtener un libro espec ́ıfico almacenado en una
        // lista en memoria.

        LibroController libro = new LibroController();
        post("/libros", libro.agregarLibro);

        get("/libros/:id", libro.obtenerLibro);

        // EJ8 Implementar servicio RESTful que reciba un monto en pesos o dolares a
        // traves de la ruta /convertir/:monto y calcule su valor en pesos o dolares a
        // partir de consultar la API https://dolarapi.com/docs/argentina/

        ConvertidorController convertidor = new ConvertidorController();
        get("/convertir/:monto/tipo/:tipo", convertidor.getCotizacion);

        // EJ9 Implementar un servicio RESTful que consuma el servicio de alguna API
        // disponible

        ClimaController clima = new ClimaController();
        get("/clima/:ciudad", clima.getClima);

        // EJ10 Implementar un servicio RESTful que consuma algun servicio disponible
        // en:
        // https://www.postman.com/cs-demo/public-rest-apis/collection/tfzpqfc/public-rest-apis

        ChisteController chiste = new ChisteController();
        get("/chiste", chiste.getChiste);
    }
}