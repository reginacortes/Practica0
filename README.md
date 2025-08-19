# Practica 0: Revisión de Algoritmos y Estructuras de Datos

## **Problema**

En el servicio de urgencias de un hospital público llegan, con alta frequencia, pacientes con
distintos tipos de padecimientos. El administrador del hospital te pide desarrollar un sistema de
Triage que decida quién es el siguiente paciente a atender basado en la prioridad asignada después
de una revisión inicial. La prioridad se establece de manera numérica con 1 siendo el más urgente y 10 el menos
urgente. 

El sitema lo implementaremos con las siguientes estructuras de datos:
  - Lista ligada ordenada
  - Árbol binario 

Buscamos comparar el desempeño de tus implementaciones en las siguientes acciones simulando llegadas
en tiempo real de 1000 pacientes con un tiempo entre arribos de 1 minuto (aleatorio con
distribución uniforme).
  - Insert
  - Search
  - Delete

## **Ejecución**

### ***Lista Enlazada***
Al utilizar una lista enlazada podemos usar como método de ordenamiento una pila o una cola. En este caso haremos uso de una cola de tal forma que los pacientes queden ordenados en cuanto a nivel de prioridad siendo el primer paciente aquel con mayor urgencia y el que se atienda primero, es decir, 10 siendo la máxima urgencia y 1 siendo la menor. 

Como inicio definimos la clase Nodo en la cual se va a almacenar la información del paciente. Definimos dicha clase como genérica y le agregamos un atributo de formato "int" en el cual se define el nivel de urgencia en el que se encuentra el paciente actualmente, mismo que se puede modificar en cualquier momento y que se utilizará para comparar el nivel de urgencia de los pacientes posteriormente. 

Una vez que se incertan los pacientes dentro de la lista enlazada, recorremos la lista obteniendo el nivel de urgencia de cada uno de los pacientes para compararlos entre ellos y tomar el máximo nivel de urgencia y moverlo a la primera posición. Se vuelve a recorrer la lista para obtener las posiciones siguientes restringiendo la longitud de la lista para no volver a comparar aquellos ya anteriormente ordenados. En caso de que existan más de un caso con la misma urgencia, no veremos cambios significativos, ya que se mantendrá el mismo procedimiento. 

Al inicio habia pensado hacer una búsqueda del paciente por nivel de urgencia, sin embargo, me percate de que era erroneo debido a que pueden haber más pacientes con el mismo nivel de gravedad y no podríamos encontrar a aquel paciente específico, por lo que fue necesario agregar un id para poder buscar a cada paciente y de ser el caso hacer una eliminación, reordenamiento, etc.

En la clase main, creamos la cola que estaremos utilizando y agregamos pacientes con diferente niveles de urgencia, los cuales son determinados de forma aleatoria hasta tener agregados 100 pacientes diferentes. 

### ***Árbol Binario***
Un árbol binario se compone de una raíz y nodos hijos. Es una estructura de datos donde la clave de cada nodo interno es mayor a las claves de su subárbol izquiero, pero menor a las claves del subárbol derecho. Cada nodo tiene como máximo dos hijos: uno izquierdo y otro derecho. 
