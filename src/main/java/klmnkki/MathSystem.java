package klmnkki;

public class MathSystem
{

    private final TaskMath myMath;

    public MathSystem(TaskMath math)
    {
        this.myMath = math;
    }

    public double logarithmicFunction(double x)
    {
        return Math.pow(Math.pow(myMath.log(x, 10) * myMath.log(x, 2), 2) * myMath.log(x, 5), 3) + Math.pow(myMath.log(x, 10) * myMath.ln(x), 3);
    }

    public double trigonometricFunction(double x)
    {
        return Math.pow(Math.pow((Math.pow(myMath.cosec(x), 3) / myMath.sin(x)) + myMath.sin(x), 3), 2);
    }

    public double calculateFunction(double x)
    {
        if (x <= 0)
        {
            return trigonometricFunction(x);
        }
        else
        {
            return logarithmicFunction(x);
        }
    }

}
