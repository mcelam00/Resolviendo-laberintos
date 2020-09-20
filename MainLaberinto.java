import java.util.ArrayList;
import java.util.Scanner;

public class MainLaberinto {
	private static ArrayList<ArrayList<String>> listaCaminos = new ArrayList<ArrayList<String>>();
	private static int fila = -9;
	private static int columna = -9;

	public static void main(String[] args) {
		
		
				int orden;
				char laberinto[][];
				Scanner leerteclado; 
				
				
				leerteclado = new Scanner(System.in);
				
							
				laberinto = rellenaLaberinto(leerteclado);
				
				orden = laberinto.length;
				
			
				posicionAsterisco(laberinto);
				
				
				
				boolean testigo;
				
				testigo = erroneo(laberinto, orden);
				
					if(testigo == true) {
						
							System.out.println("NO.");
							salir();		
					}
				
				String inicial;
				inicial="(1,1)"; 
			
					if(fila == 0 && columna == 0) {
						inicial = inicial+"*";
					}
				
		
				ArrayList<String> camino;
				camino = new ArrayList<String>();
				camino.add(inicial);
				
				
				listaCaminos.add(camino);
				
				
				int contador;
				contador=0;
				
				
				
				
				recorrerLaberinto(contador, laberinto);			
			

				
				String ultimaPosicion;
				ultimaPosicion = "("+String.valueOf(orden)+","+String.valueOf(orden)+")";
				
				ArrayList<ArrayList<String>> solucionSinPremio;
				solucionSinPremio = hallarSolucion(orden, orden, ultimaPosicion); 
				if(solucionSinPremio == null) {
						System.out.println("NO.");
				}else{
					if(fila == -9) { 
						System.out.println("SI, SIN PREMIO.");
						pintoSolucion(solucionSinPremio);
						
					}else if(fila== orden-1 && columna == orden-1 || (fila == 0 && columna == 0)){
						System.out.println("SI, CON PREMIO.");
						pintoSolucion(solucionSinPremio);

					}else {
						
						String ultimaPosicion1;
						ultimaPosicion1 = "("+String.valueOf(fila+1)+","+String.valueOf(columna+1)+")";
						ArrayList<ArrayList<String>> caminoInicioAsterisco;
						caminoInicioAsterisco =hallarSolucion(fila+1, columna+1, ultimaPosicion1);
						if(caminoInicioAsterisco == null) {
							System.out.println("SI, SIN PREMIO.");
							pintoSolucion(solucionSinPremio);
						}else{
						
							String posicionAsterisco;
							posicionAsterisco= "("+String.valueOf(fila+1)+","+String.valueOf(columna+1)+")";
						
							ArrayList<String> posibleCaminoAsterisco;
							posibleCaminoAsterisco = new ArrayList<String>();
							posibleCaminoAsterisco.add(posicionAsterisco);
							//borro la lista entocens
							
							listaCaminos= new ArrayList<ArrayList<String>>();
							
							listaCaminos.add(posibleCaminoAsterisco);
							
							
							int contador1;
							contador1=0;
							
							recorrerLaberinto(contador1, laberinto);
							
							
							String ultimaPosicion3;
							ultimaPosicion3 = "("+String.valueOf(orden)+","+String.valueOf(orden)+")";
																											
							ArrayList<ArrayList<String>> caminoAsteriscoSalida;
							caminoAsteriscoSalida = hallarSolucion(orden, orden, ultimaPosicion3);

								if(caminoAsteriscoSalida==null) {
									System.out.println("NO.");
									pintoSolucion(solucionSinPremio);
								}else {
									ArrayList<String> solPremio; 
									solPremio = new ArrayList<String>();
									for(int i =0; i < caminoInicioAsterisco.get(0).size(); i++) {	
										solPremio.add(caminoInicioAsterisco.get(0).get(i));
									}
								
								
																									
									for(int i = 1; i< caminoAsteriscoSalida.get(0).size();i++) {
										solPremio.add(caminoAsteriscoSalida.get(0).get(i));
									}
									System.out.println("SI, CON PREMIO.");
									pintoSolucionAsterisco(solPremio);
								}
						}
					}
						
				}
				
				
				
				
			}

	private static void salir() {
		System.exit(0);		
	}
	

			private static boolean erroneo(char[][] laberinto, int orden) {
				boolean error;
				error = false;
				if(laberinto[0][0]=='1' || laberinto[orden-1][orden-1]=='1') {
					error = true;
				}
				return error;
				}



			private static void pintoSolucionAsterisco(ArrayList<String> solPremio) {
				 for (int i = 0; i < solPremio.size()-1; i++) {
	                   
	                    System.out.print(solPremio.get(i)+" ");
	                }
	                System.out.println(solPremio.get(solPremio.size()-1));			
				
				
			}



			private static void pintoSolucion(ArrayList<ArrayList<String>> solucionSinPremio) {
				 for (int i = 0; i < solucionSinPremio.get(0).size()-1; i++) {
	                   
	                    System.out.print(solucionSinPremio.get(0).get(i)+" ");
	                }
	                System.out.println(solucionSinPremio.get(0).get(solucionSinPremio.get(0).size()-1));
	            
			}

			
			
			private static ArrayList<ArrayList<String>> hallarSolucion(int FilaAEncontrar, int ColumnaAEncontrar, String ultimaPosicion) {

				ArrayList<ArrayList<String>> solucionSinPremio;
				solucionSinPremio = new ArrayList<ArrayList<String>>();
			
				
				
				if(fila+1==FilaAEncontrar && columna+1==ColumnaAEncontrar ) {	
					ultimaPosicion = ultimaPosicion+"*";
				}
				
				for(int k = 0; k < listaCaminos.size(); k++) {
					
					String verPosicion = listaCaminos.get(k).get(listaCaminos.get(k).size()-1);
					if(verPosicion.equals(ultimaPosicion)) {
						solucionSinPremio.add(listaCaminos.get(k));
					}
				}
					if(solucionSinPremio.size()>0) {
						return solucionSinPremio;
					}
					else
					{
						return null;
					}
				
				
				
				
				
			}




			private static void posicionAsterisco(char[][] laberinto) {
				for(int i=0; i<laberinto.length; i++) {
					for(int j=0; j<laberinto.length; j++) {
						if(laberinto[i][j] == '*') {	
							fila = i;
							columna = j;
						
						}
					}
				}
			}





			
			
			
			
			
			private static void recorrerLaberinto(int contador, char[][] laberinto) {
				if(contador<listaCaminos.size()) { 
					
					buscoPosiblesCaminos(listaCaminos.get(contador), laberinto);
					recorrerLaberinto(contador+1, laberinto);
				
					
					
				}
			}
			

			
			private static void buscoPosiblesCaminos(ArrayList<String> caminoQueEstoyHaciendo, char[][] laberinto) { 

		
			

	
				String ultimaPosicionDelCamino;
				ultimaPosicionDelCamino = caminoQueEstoyHaciendo.get(caminoQueEstoyHaciendo.size()-1);
				
				int coma;
				
				int parentesis; 
				coma = ultimaPosicionDelCamino.indexOf(",");
				parentesis = ultimaPosicionDelCamino.indexOf(")");
				String componentex;
				String componentey;
				componentex = ultimaPosicionDelCamino.substring(1,coma);
				componentey = ultimaPosicionDelCamino.substring(coma+1, parentesis);
				int fila;
				fila = Integer.parseInt(componentex)-1;
				int columna;
				columna = Integer.parseInt(componentey)-1;
				
				
				
				
				comprueboMovimientos(fila,columna, laberinto, caminoQueEstoyHaciendo); 
			
				
			}



			private static void comprueboMovimientos(int fila, int col, char[][] laberinto, ArrayList<String> caminoSeguir) {
				
				
				hayCaminoArriba(fila, col, laberinto, caminoSeguir);
				hayCaminoAbajo(fila, col, laberinto, caminoSeguir);
				hayCaminoDrcha(fila, col, laberinto, caminoSeguir);
				hayCaminoIzda(fila, col, laberinto, caminoSeguir);
				hayCaminoDiagArribaDrcha(fila, col, laberinto, caminoSeguir);
				hayCaminoDiagArribaIzda(fila, col, laberinto, caminoSeguir);
				hayCaminoDiagAbajoDrcha(fila, col, laberinto, caminoSeguir);
				hayCaminoDiagAbajoIzda(fila, col, laberinto, caminoSeguir);
				
			
		
				
			}
			
			
			
			
			private static void hayCaminoArriba(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if(((fila-1) < 0) || ((fila-1) >= orden)) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila-1][columna]=='0')||(laberinto[fila-1][columna]=='*'))) {
					mover(fila-1,columna,caminoSeguir,laberinto);

				}
			}
			
			private static void hayCaminoAbajo(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if(((fila+1) < 0) || ((fila+1) >= orden)) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila+1][columna]=='0') || (laberinto[fila+1][columna]=='*'))) {
					
					mover(fila+1,columna,caminoSeguir,laberinto);

				}
			}
			private static void hayCaminoDrcha(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if((((columna+1) < 0)) || (((columna+1) >= orden))) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila][columna+1]=='0')||(laberinto[fila][columna+1]=='*'))) {
					mover(fila,columna+1,caminoSeguir,laberinto);

				}
			}
			private static void hayCaminoIzda(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if(((columna-1) < 0) || ((columna-1) >= orden)) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila][columna-1]=='0') || (laberinto[fila][columna-1]=='*'))) {
					mover(fila,columna-1,caminoSeguir,laberinto);

				}
			}
			private static void hayCaminoDiagArribaDrcha(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if((((fila-1) < 0) || ((fila-1) >= orden)) || (((columna+1) < 0) || ((columna+1) >= orden))) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila-1][columna+1]=='0')||(laberinto[fila-1][columna+1]=='*'))) {
					mover(fila-1,columna+1,caminoSeguir,laberinto);

				}
			}
			private static void hayCaminoDiagArribaIzda(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if((((fila-1) < 0) || ((fila-1) >= orden)) || (((columna-1) < 0) || ((columna-1) >= orden))) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila-1][columna-1]=='0') || (laberinto[fila-1][columna-1]=='*'))) {
					mover(fila-1,columna-1,caminoSeguir,laberinto);
					
				}
				
			}
			private static void hayCaminoDiagAbajoDrcha(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if((((fila+1) < 0) || ((fila+1) >= orden)) || (((columna+1) < 0) || ((columna+1) >= orden))) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila+1][columna+1]=='0') || (laberinto[fila+1][columna+1]=='*'))) {
					mover(fila+1,columna+1,caminoSeguir,laberinto);

				}
			}
			private static void hayCaminoDiagAbajoIzda(int fila, int columna,  char[][] laberinto, ArrayList<String> caminoSeguir) {
				boolean existe, mover;
				int orden;
				existe = true; //por defecto si existe camino
				mover = false;
				orden = laberinto.length;
				//Miro si existe la casilla
				if((((fila+1) < 0) || ((fila+1) >= orden)) || (((columna-1) < 0) || ((columna-1) >= orden))) {
					existe = false;
				}
				//Miro si no está bloqueado el camino
				if(existe == true && ((laberinto[fila+1][columna-1]=='0') || (laberinto[fila+1][columna-1]=='*'))) {
					mover(fila+1,columna-1,caminoSeguir,laberinto);
				}
				
			}


		

			

		private static void mover(int fila, int col, ArrayList<String> caminoSeguir, char[][] laberinto) {
			
			
			String posicionString="("+String.valueOf(fila+1)+","+String.valueOf(col+1)+")"; 
			if(laberinto[fila][col] == '*') {
				posicionString = posicionString+'*';
			
			}
		
			
			for(int i= 0; i<caminoSeguir.size();i++) {
				boolean hePasadoPosicion = false;
				for(int k=0; k<listaCaminos.size(); k++) {
					if(listaCaminos.get(k).contains(posicionString)) {
						hePasadoPosicion=true; 
					}
				}
				if(hePasadoPosicion==false) {
					ArrayList<String> caminoSeguirAux=new ArrayList<String>();
					for(int j = 0; j < caminoSeguir.size(); j++) {
						caminoSeguirAux.add(caminoSeguir.get(j));
					}
					caminoSeguirAux.add(posicionString);
					listaCaminos.add(caminoSeguirAux);
					
				}
			}
		}



			
		private static char[][] rellenaLaberinto(Scanner leerTeclado) {
			String dimension1;
			int orden;
			dimension1 = "";
			orden = 0;
			
			dimension1 = leerTeclado.nextLine(); 
			
			try {
			orden = Integer.parseInt(dimension1);
			}catch(Exception errorTeclado) {
				System.out.println("Entrada Inválida.");
				salir();
			}
			
			
			
			char matrizLaberinto[][];
			matrizLaberinto= new char[orden][orden];
			
			matrizLaberinto = rellenarMatriz(leerTeclado, matrizLaberinto);
			

			return matrizLaberinto;

		}

		private static char[][] rellenarMatriz(Scanner leerTeclado, char[][] matrizLaberinto) {

			String linea;
			int orden;
			char caracter;
			linea = "";
			orden = matrizLaberinto.length;
			
			for(int fila = 0; fila < orden; fila++) {
			
				linea = leerTeclado.nextLine();
				
					for(int columna = 0; columna < orden; columna++) {
						
					caracter = linea.charAt(columna);
						if(caracter != '0' && caracter != '1' && caracter != '*') {
						System.out.println("Entrada Inválida.");
						salir();	
						}
					matrizLaberinto[fila][columna] = linea.charAt(columna);
				}
				
			}
			return matrizLaberinto;
		}

		}
