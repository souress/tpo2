package klmnkki;

public class BasicFunctions
{

    public static final double accuracy = 0.000001;

    private static double sinTaylorMember(double x, int n) {
        int sign = n % 2 == 0 ? 1 : -1;
        double res = sign * Math.pow(x, 2 * n + 1);
        return divideByFactorial(res, 2 * n + 1);
    }

    private static double divideByFactorial(double res, int n) {
        for (int i = 1; i <= n; ++i) {
            res /= i;
        }
        return res;
    }

    private static double lnToTaylorSeries(double x, int n)
    {
        if (n % 2 == 0)
        {
            return 0;
        }
        else
        {
            return 2 * Math.pow(x, n) / n;
        }
    }

    interface FunctionToExecute
    {
        double execute(double x, int n);
    }

    private static double findSum(double x, FunctionToExecute fun)
    {
        double result = 0;
        double prev = 0;
        double current = Double.MAX_VALUE;
        int n = 0;
        while (Math.abs(current - prev) >= accuracy)
        {
            prev = current;
            current = fun.execute(x, n);
            result += current;
            n += 1;
        }
        return result;
    }

    public static boolean isBorder(double x)
    {
        return Double.isNaN(x) || Double.isInfinite(x);
    }

    public static double sin(double x)
    {
        if (isBorder(x))
        {
            return Double.NaN;
        }
        return findSum(x, BasicFunctions::sinTaylorMember);
    }

    public static double ln(double x)
    {
        if (isBorder(x) || x <= 0)
        {
            return Double.NaN;
        }
        double val = (x - 1) / (x + 1);
        return findSum(val, BasicFunctions::lnToTaylorSeries);
    }

}
