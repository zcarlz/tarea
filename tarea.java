import javax.swing.JOptionPane;
public class tarea {
    public static void main(String[] args) {
        int cantidad = 0;
        while (cantidad < 5 || cantidad > 15) {
            String input = JOptionPane.showInputDialog("Ingrese la cantidad de puntajes (5 a 15):");
            if (input == null) return;
            try {
                cantidad = Integer.parseInt(input);
            } catch (Exception e) {
                cantidad = 0;
            }
        }
        int[] puntajes = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            int p = -1;
            while (p < 0 || p > 100) {
                String input = JOptionPane.showInputDialog("Ingrese el puntaje " + (i + 1) + " (0 a 100):");
                if (input == null) return;
                try {
                    p = Integer.parseInt(input);
                } catch (Exception e) {
                    p = -1;
                }
            }
            puntajes[i] = p;
        }
        int max = puntajes[0];
        int min = puntajes[0];
        int suma = 0;
        int mayores90 = 0;

        for (int i = 0; i < cantidad; i++) {
            int p = puntajes[i];
            suma += p;
            if (p > max) max = p;
            if (p < min) min = p;
            if (p >= 90) mayores90++;
        }
        double promedio = (double) suma / cantidad;

        JOptionPane.showMessageDialog(null,
                "Puntaje mas alto: " + max +
                        "\nPuntaje mas bajo: " + min +
                        "\nPromedio general: " + promedio +
                        "\nCantidad de puntajes >= 90: " + mayores90);
        int opcion = 0;

        while (opcion != 4) {
            String menu = JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Ver todos los puntajes\n" +
                            "2. Ver puntajes aprobados (>= 60)\n" +
                            "3. Ver puntajes reprobados (< 60)\n" +
                            "4. Salir\n" +
                            "Elija una opcion:"
            );

            if (menu == null) return;

            try {
                opcion = Integer.parseInt(menu);
            } catch (Exception e) {
                opcion = 0;
            }

            if (opcion == 1) {
                String lista = "";
                for (int i = 0; i < cantidad; i++) lista += puntajes[i] + " ";
                JOptionPane.showMessageDialog(null, "Todos los puntajes:\n" + lista);

            } else if (opcion == 2) {
                String lista = "";
                for (int i = 0; i < cantidad; i++) if (puntajes[i] >= 60) lista += puntajes[i] + " ";
                JOptionPane.showMessageDialog(null, "Puntajes aprobados:\n" + lista);

            } else if (opcion == 3) {
                String lista = "";
                for (int i = 0; i < cantidad; i++) if (puntajes[i] < 60) lista += puntajes[i] + " ";
                JOptionPane.showMessageDialog(null, "Puntajes reprobados:\n" + lista);
            }
        }
        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }
}