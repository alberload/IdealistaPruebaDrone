package pruebadrone;

/**
 * @author Alberto Gil
 */
public class PruebaDrone {
    // He supuesto que las ID son de tipo long ya que no se especifica en el enunciado
    public long[] obtenerUrbanizacionesVisitadas(double coorX, double coorY, int rango) {
        // Creo un array con tamaño igual al numero de urbanizaciones que va a haber
        int numeroUrbanizaciones = (int) Math.pow(2 * rango + 1, 2);
        long[] listaIds = new long[numeroUrbanizaciones];
        int n = 0;

        // Un long auxiliar para recorrer las IDs
        long auxId = obtenerIdentificadorUrbanizacion(coorX, coorY);

        // Primero me coloco en la urbanizacion que este mas arriba a la izquierda
        for (int x = 0; x < rango; x++) {
            auxId = obtenerAdyacente(auxId, "IZQUIERDA");
        }
        for (int y = 0; y < rango; y++) {
            auxId = obtenerAdyacente(auxId, "ARRIBA");
        }

        // Despues comienzo a recorrer las urbanizaciones dado el rango
        listaIds[n] = auxId;
        n++;
        String direccion = "";
        while (n < numeroUrbanizaciones) {
            if (direccion == "DERECHA") {
                direccion = "IZQUIERDA";
            } else {
                direccion = "DERECHA";
            }
            // Se recorre la fila
            for (int i = 0; i < 2 * rango + 1; i++) {
                auxId = obtenerAdyacente(auxId, direccion);
                listaIds[n] = auxId;
                n++;
            }
            // Terminada la fila, baja a la siguiente si no se ha terminado
            if (n < numeroUrbanizaciones){
                auxId = obtenerAdyacente(auxId, "ABAJO");
                listaIds[n] = auxId;
                n++;
            }
        }
        return listaIds;
    }
}
