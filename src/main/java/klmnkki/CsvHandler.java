package klmnkki;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.function.UnaryOperator;

public class CsvHandler
{
    public static void toCSV(double x, double value, File file) throws IOException
    {
        OutputStreamWriter wr = new OutputStreamWriter(new FileOutputStream(file, true));
        String output = x + "," + value + "\n";
        wr.write(output);
        wr.flush();
    }

    public static void functionToCSV(UnaryOperator<Double> func, String name, double lower, double upper, double step) throws IOException
    {
        File file = new File("C:\\Users\\kklimenko\\Desktop\\Studies\\debts\\ТПО\\tpo2\\src\\test\\resources\\" + name + ".csv");
        if (file.exists())
        {
            if (!file.delete())
            {
                System.out.printf("Unable to delete file %s%n", file.getName());
            }
            else
            {
                System.out.printf("Deleted file %s%n", file.getName());
            }
        }
        else
        {
            if (!file.createNewFile())
            {
                System.out.printf("Unable to create file %s%n", file.getName());
            }
            else
            {
                System.out.printf("Created file %s%n", file.getName());
            }
        }
        double x;
        for (int i = 0; i < (upper - lower) / step; ++i)
        {
            x = lower + i * step;
            toCSV(x, func.apply(x), file);
        }
    }

    public static void functionToCSV(UnaryOperator<Double> func, String name) throws IOException
    {
        functionToCSV(func, name, -6, 6, 0.05);
    }

    public static void main(String[] args) throws IOException
    {
        TaskMath math = new TaskMath();
        MathSystem system = new MathSystem(math);
        functionToCSV(math::cos, "cos");
        functionToCSV(math::sin, "sin");
        functionToCSV(math::tan, "tan");
        functionToCSV(math::cotan, "cotan");
        functionToCSV(math::sec, "sec");
        functionToCSV(math::cosec, "cosec");
        functionToCSV(math::ln, "ln");
        functionToCSV(system::calculateFunction, "system");
        functionToCSV(system::trigonometricFunction, "trigonometry");
        functionToCSV(system::logarithmicFunction, "logarithm");
    }
}
