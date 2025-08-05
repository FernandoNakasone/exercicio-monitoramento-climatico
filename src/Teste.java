import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        double temp = 100;

        try {
            validar(temp);
        }
        catch(LeituraInvalidaException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("X");
        }

        Sensor sensor = new Sensor("1");
        List<Double> lista = new ArrayList<>();

        for(int i=0; i<100; i++){
           lista.add((double) Math.round(Math.random() * 61));
        }

        sensor.registrarLeituras(lista);

    }

    private static void validar(double temp){
        if(temp < -50 || temp > 50){
            throw new LeituraInvalidaException(12, temp);
        }
    }
}
