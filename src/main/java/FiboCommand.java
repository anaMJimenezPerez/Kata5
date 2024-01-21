import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class FiboCommand implements Command{
    @Override
    public Output execute(Input input) {
        try{
            return outputOf(isFibonacciNumber(input.get("number")));
        } catch (Exception e){
            return outputException();
        }
    }

    private Output outputException(){
        return new Output() {
            @Override
            public String result() {
                return null;
            }

            @Override
            public int response() {
                return 403;
            }
        };
    }

    private Output outputOf(String result){
        return new Output() {
            @Override
            public String result() {
                return result;
            }

            @Override
            public int response() {
                return 200;
            }
        };
    }

    private static String isFibonacciNumber(String number){
        return valueOf(isFibonacciNumber(parseInt(number)));
    }

    private static String isFibonacciNumber(int number){
        if(number < 0){
            return "El numero " + number + " no pertenece a la sucesión de Fibonacci";
        }
        int fiboAnterior = 0, fiboActual = 1;
        while(fiboAnterior <= number){
            if(fiboAnterior == number){
                return "El numero " + number + " pertenece a la sucesión de Fibonacci";
            }
            int siguienteFib = fiboAnterior + fiboActual;
            fiboAnterior = fiboActual;
            fiboActual = siguienteFib;
        }

        return "El numero " + number + " no pertenece a la sucesión de Fibonacci";
    }
}
