package Area_Curva;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.SwingWrapper;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AreaBajoLaCurvaXChart {

    public static double calcularArea(Expression funcion, double a, double b, int n) {
        double h = (b - a) / n;
        double area = 0.5 * (evaluarFuncion(funcion, a) + evaluarFuncion(funcion, b));

        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            area += evaluarFuncion(funcion, x);
        }

        area *= h;
        return area;
    }

    public static double evaluarFuncion(Expression funcion, double x) {
        return funcion.setVariable("x", x).evaluate();
    }

    public static void graficarFuncion(Expression funcion, double a, double b) {
        List<Double> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();

        // Datos para la curva completa
        for (double x = a - 1; x <= b + 1; x += 0.1) {
            xData.add(x);
            yData.add(evaluarFuncion(funcion, x));
        }

        // Datos para el área sombreada
        List<Double> xArea = new ArrayList<>();
        List<Double> yArea = new ArrayList<>();

        for (double x = a; x <= b; x += 0.1) {
            xArea.add(x);
            yArea.add(evaluarFuncion(funcion, x));
        }

        xArea.add(b);
        yArea.add(0.0);
        xArea.add(a);
        yArea.add(0.0);

        XYChart chart = new XYChartBuilder().width(800).height(600).title("Area Bajo la Curva").xAxisTitle("X").yAxisTitle("Y").build();

        XYSeries seriesFuncion = chart.addSeries("f(x)", xData, yData);
        seriesFuncion.setLineColor(java.awt.Color.BLUE);

        XYSeries seriesArea = chart.addSeries("Area bajo la curva", xArea, yArea);
        seriesArea.setLineColor(java.awt.Color.CYAN);
        seriesArea.setFillColor(new java.awt.Color(0, 128, 255, 100)); // Color semitransparente para el área

        new SwingWrapper<>(chart).displayChart();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la funcion en terminos de x (por ejemplo, x^2 + 3*x - 5): ");
        String funcionUsuario = scanner.nextLine();

        Expression funcion = new ExpressionBuilder(funcionUsuario)
                .variable("x")
                .build();

        System.out.print("Ingresa el limite inferior (a): ");
        double a = scanner.nextDouble();

        System.out.print("Ingresa el limite superior (b): ");
        double b = scanner.nextDouble();

        int n = 1000; 
        double area = calcularArea(funcion, a, b, n);

        System.out.println("El area bajo la curva es: " + area);

        graficarFuncion(funcion, a, b);
    }
}

