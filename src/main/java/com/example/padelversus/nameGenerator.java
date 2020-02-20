package com.example.padelversus;

public class nameGenerator {
        /**
         * este metodo genera nombres con apellidos. El proceso es aleatorio. Cada vez
         * que se corra el programa mostrara nombres diferentes.
         *
         * @param cantidad
         *            Cantidad de nombres que se quieren generar.
         * @return un arreglo de String con los nombres y apellidos generados. El
         *         formato de salida es: Nombre Apellido
         */
        public static String[] generarNombresAleatorios(int cantidad) {
            String[] nombresAleatorios = new String[cantidad];

            String[] nombres = { "Andrea", "David", "Bart", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
                    "Bartolomé", "Cesar", "Baruj", "Candelaria", "Cándida", "Canela", "Lucas", "Carina", "Carisa",
                    "Caritina", "Carlota", "Pepe"};
            String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
                    "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
                    "Grigalva" };

            for (int i = 0; i < cantidad; i++) {
                nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                        + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
            }
            return nombresAleatorios;
        }

        /**
         * Imprime un arreglo de String
         *
         * @param nombresGenerados
         *            arreglo con los nombres generados
         */
        public static void imprimir(String[] nombresGenerados) {
            for (int i = 0; i < nombresGenerados.length; i++) {
                System.out.println(nombresGenerados[i]);
            }
        }

        public static void main(String[] args) {
            imprimir(generarNombresAleatorios(200));
        }
}

