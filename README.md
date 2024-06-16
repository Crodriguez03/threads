Trabajar con hilos nos ofrece mucha potencia a la hora de realizar grandes cargas de trabajo. Hay varias formas de trabajar con hilos. Una forma es creando un pool de hilos en un método específico. Se crea el pool, se le asignan tareas para que se realicen en paralelo, se espera o no a que terminen las tareas y salimos del método. Cada vez que se entra en el método se genera un pool de hilos nuevo.

Otra forma de trabjar es creando un pool de hilos general e ir asignando tareas a ese pool desde distintos métodos. En este caso el pool se mantiene con vida todo el tiempo que dure la aplicación.

Una tercera opción es usar el método parallelStream() de java. Con ello usamos el pool de hilos propio que nos ofrece java con el uso de los streams. Es la forma más versátil para trabajar en paralelo sin tener que estar controlando la vida del pool de hilos.

Ejemplos:
