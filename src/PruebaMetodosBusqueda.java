import java.util.Arrays;
import java.util.Scanner;

class MetodosDeBusqueda{
    public static int binario(int[]matriz, int valorBuscado) {
        if(matriz.length==0) {
            return -1;
        }
        int mitad,inferior =0;
        int superior = matriz.length-1;
        do {
            mitad = (int)(inferior + superior) / 2;
            if (valorBuscado > matriz[mitad]) {
            inferior = mitad + 1;
            } else {
            superior = mitad-1;
            }
            } while (matriz[mitad] != valorBuscado && inferior <= superior);

            if (matriz[mitad] == valorBuscado) {
                System.out.println("Encontrado");
                return mitad;

            } else {
                System.out.println("No se encontro");
            return -1;
            }


    }
    
    
}//metodos busqueda


class FuncionHash{
	String [] arreglo;
	int tama�o;
	int cont;

	public FuncionHash(int tam) {
		tama�o = tam;
		arreglo=new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	
	
	public void funcionHash (String[] cadArreglo, String[] arreglo) {
		int i;
		// Ciclo para asiganar a la varible elemento el valor de la cadena
		for (i = 0; i < cadArreglo.length; i++) {
			String elemento = cadArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento) % 7;
			System.out.println("Indice: " + indiceArreglo + " para " + elemento);
			// Mpetodo para solucionar una colision
			while (arreglo[indiceArreglo] != "-1") {
				indiceArreglo++;
				System.out.println("Colisi�n en el indice: " + (indiceArreglo - 1) + " cambiando por " + indiceArreglo);
				// Cambiar al indice siguiente y asi evitar la colision
				indiceArreglo %= tama�o; // Para volver a sacar el valor
			}
			arreglo[indiceArreglo] = elemento;
		}
	
	}
	
	
	public void mostrar() {
		int incremento = 0;
		int j;

		for (int i = 0; i < 1; i++) {
			incremento += 8;
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------");
			for (j = incremento - 8; j < incremento; j++) {
				System.out.format(" | %3s " + " ", j);
			}
			System.out.println(" | ");
			for (int k = 0; k < 100; k++) {
			}
			System.out.println();
			for (j = incremento - 8; j < incremento; j++) {
				if (arreglo[j].equals("-1")) {
					System.out.println(" | ");
				} else {
					System.out.print(String.format(" | %3s" + " ", arreglo[j]));
				}
			}

			System.out.println("|");
			System.out.println("------------------------------------------------------------------");
			for (j = 0; j < 100; j++) {
			}
			System.out.println("");
		}
	}
	
	
	public String buscarClave(String elemento) {
		
		int indiceArrglo = Integer.parseInt(elemento) % 7;
		int contador = 0;
		
		while (arreglo[indiceArrglo] != "-1") {
			if (arreglo[indiceArrglo] == elemento) {
				System.out.println("Elemento " + elemento + " se encontro en el indice" + indiceArrglo);
				return arreglo[indiceArrglo];
			}
			indiceArrglo++;
			indiceArrglo %= tama�o;
			contador++;
			if (contador > 7) {
				System.out.print("Error");
				break;
			}
		}
		return null;
	}
	

	
}//funciones hash


public class PruebaMetodosBusqueda {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
	    int[] matriz= {1,4,6,8,19,23,56,78,98,100,102};
	    System.out.println("Ingrese el valor a buscar: ");
	    int buscado = entrada.nextInt();
	    System.out.println("Vector: " + Arrays.toString(matriz));
	    MetodosDeBusqueda.binario(matriz, buscado);
	    System.out.println();
	    
	    FuncionHash funcion = new FuncionHash(8);
		String[] elementos = { "25", "14", "96", "300", "1", "12", "8", "15" };
		funcion.funcionHash(elementos, funcion.arreglo);
		funcion.mostrar();
		
		//Buscar
		String buscarElemento= funcion.buscarClave("1");
		if(buscarElemento == null) {
			System.out.print("\n Elemento no encontrado");
		}
			
	}

}
