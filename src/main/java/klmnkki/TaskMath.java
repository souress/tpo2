package klmnkki;

public class TaskMath
{

    public double sin(double x)
    {
        return BasicFunctions.sin(x);
    }

    public double cos(double x)
    {
        return 1 - 2 * sin(x / 2) * sin(x / 2);
    }

    public double tan(double x)
    {
        return sin(x) / cos(x);
    }

    public double cotan(double x)
    {
        return 1 / tan(x);
    }

    public double sec(double x)
    {
        return 1 / cos(x);
    }

    public double cosec(double x)
    {
        return 1 / sin(x);
    }

    public double ln(double x)
    {
        return BasicFunctions.ln(x);
    }

    public double log(double x, int base)
    {
        return ln(x) / ln(base);
    }
}
