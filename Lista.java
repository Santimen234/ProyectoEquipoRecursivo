import java.util.ArrayList;
import java.util.List;

public class Lista {

    List<Jugador> equipo;

    public Lista(){
        equipo=new ArrayList<Jugador>();
    }

    public void agregar(Jugador dato){
        equipo.add(dato);
    }

    public boolean actualizar (Jugador dato){

        for(Jugador j:equipo){
            if(j.getIdentificador()==dato.getIdentificador()){
                j.setNombre(dato.getNombre());
                j.setEdad(dato.getEdad());
                j.setRendimiento(dato.getRendimiento());
                j.setPosicion(dato.getPosicion());
                return true;
            }
        }
        return false;
    }

    public List<Jugador> getEquipo() {
        return equipo;
    }

    private float sumatoria(int indice, String posicion){
        if(indice<equipo.size()){
            //caso general
            if(equipo.get(indice).getPosicion().compareTo(posicion)==0)
               return equipo.get(indice).getRendimiento()+sumatoria(indice+1,posicion);
            else
                return sumatoria(indice+1,posicion);
        }else{
            //caso base
            return 0;
        }
    }
    public float sumatoria(String posicion){
       return sumatoria(0,posicion);
    }

    public void ordenar(){
        int n = equipo.size();
        for (int i = 0; i < n - 1; i++) {
            Jugador auxiliar;
            for (int j = 0; j < n - i - 1; j++) {
                if (equipo.get(j).getRendimiento() > equipo.get(j + 1).getRendimiento()) {
                    auxiliar = equipo.get(j);
                    equipo.set(j, equipo.get(j + 1));
                    equipo.set(j + 1, auxiliar);
                }
            }
        }
    }

    public void insercion(){
        Jugador aux= null;
        int j;
        for (int i=0; i < equipo.size(); i++ ){
            j= i-1;
            aux=equipo.get(i);
            while (j>=0 && aux.getRendimiento()<equipo.get(j).getRendimiento()){
                equipo.set(j+1,equipo.get(j));
                j--;
            }
            equipo.set(j+1, aux);


        }

    }

    public void eliminarJugadorConMenorRendimiento() {
        if (equipo.isEmpty()) {
            System.out.println("El equipo está vacío, no se puede eliminar a ningún jugador.");
            return;
        }
        float menorRendimiento = equipo.get(0).getRendimiento();
        for (Jugador j : equipo) {
            if (j.getRendimiento() < menorRendimiento) {
                menorRendimiento = j.getRendimiento();
            }
        }
        int contador = 0;
        for (Jugador j : equipo) {
            if (j.getRendimiento() == menorRendimiento) {
                contador++;
            }
        }
        if (contador == 1) {
            for (int i = 0; i < equipo.size(); i++) {
                if (equipo.get(i).getRendimiento() == menorRendimiento) {
                    System.out.println("Eliminando a " + equipo.get(i).getNombre() + " con el menor rendimiento.");
                    equipo.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("Hay " + contador + " jugadores con el mismo rendimiento mínimo. No se eliminará a nadie.");
        }
    }






}
