# Área Bajo la Curva

Este proyecto es un prototipo de una calculadora de área bajo la curva que calcula el área para funciones simples (como polinomios de grado dos y funciones lineales) y también muestra una gráfica de la función con el área sombreada entre los límites establecidos.

## Características

- Calcula el área bajo la curva utilizando el método de trapecios.
- Permite ingresar funciones en términos de \( x \), como `x^2 + 3x - 5`.
- Gráfica la función junto con el área bajo la curva entre los límites establecidos.
- Basado en Java y las bibliotecas `exp4j` para el análisis de funciones y `XChart` para la visualización.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación.
- **exp4j**: Biblioteca para análisis y evaluación de expresiones matemáticas.
- **XChart**: Biblioteca para generar gráficos XY en Java.

## Estructura del Código

- `calcularArea`: Método para calcular el área bajo la curva usando el método de trapecios.
- `evaluarFuncion`: Método para evaluar la función en un valor específico de \( x \).
- `graficarFuncion`: Método para graficar la función y sombrear el área bajo la curva entre los límites \( a \) y \( b \).
- `main`: Punto de entrada donde el usuario ingresa la función y los límites, se calcula el área y se grafica la función.

## Instrucciones de Uso

1. Clona el repositorio y asegúrate de tener las bibliotecas `exp4j` y `XChart` incluidas en tu proyecto.
2. Ejecuta el programa.
3. Ingresa la función en términos de \( x \) (por ejemplo: `x^2 + 3x - 5`).
4. Especifica el límite inferior y superior para calcular el área entre estos puntos.
5. El programa imprimirá el área y abrirá una ventana con la gráfica de la función y el área sombreada.

## Ejemplo de Uso

Ingresa la función en términos de x (por ejemplo, x^2 + 3x - 5): x^2 Ingresa el límite inferior (a): 0 Ingresa el límite superior (b): 3

Salida: El área bajo la curva es: 7.50


## Notas

- Actualmente, este prototipo solo admite funciones sencillas (polinomios de grado 2 o inferiores).
- El valor de `n`, el número de divisiones para el cálculo del área, está establecido en `1000` por defecto.



