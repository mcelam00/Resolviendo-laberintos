# Resolviendo-laberintos

Un laberinto viene dado por una matriz cuadrada de tamaño nxn en la que cada posición puede ser un 0, un 1 o un asterisco. Un 1 significa que el camino está bloqueado, un 0 significa que el camino está abierto y un asterisco significa que el camino está abierto y además ganamos premio. En un laberinto puede haber como máximo un asterisco pero no es obligatorio que lo haya. En el laberinto se puede avanzar en cualquier dirección (horizontal, vertical y diagonal), siempre que el camino no esté bloqueado, a una posición vecina. Se pide un programa que comenzando en la posición (1,1) de la matriz (esquina superior izquierda), las filas y columnas comienzan a numerarse en 1, intente encontrar un camino a la posición (n,n), (esquina inferior derecha) .

El programa tomará como entrada un entero n en una línea y a continuación la matriz del laberinto dada en n líneas cada una con n valores binarios seguidos, sin blancos. Se podrá suponer que la entrada siempre es correcta. Una de esas posiciones puede ser un asterisco; n será un entero positivo mayor que 0 almacenable en un int.

La salida devolverá la cadena "SI, CON PREMIO." en una línea y en la siguiente línea el camino más corto encontrado dando las casillas que forman el camino separadas por un blanco, entre paréntesis y separados los valores fila y columna con una coma, y con un asterisco a la derecha de la casilla que contenía el premio, si hay un camino posible en el laberinto de salida que pasa por una posición con premio. 

La salida será "SI, SIN PREMIO." si hay algún camino en el laberinto de salida pero ninguno de los existentes pasa por una casilla con premio, dando de nuevo el camino más corto posible. 

La salida será  "NO." sino hay camino posible de salida del laberinto. 

Cada línea de salida terminará con un final de línea y hay prioridad a los caminos con premio que los sin premio. Significa que si hay un camino con premio se debe siempre dar el camino más corto con premio posible.
 Ejemplo
 
 Entrada

 3
 010
 0*0
 010


 Salida

SI, CON PREMIO.
(1,1) (2,2)* (3,3)
