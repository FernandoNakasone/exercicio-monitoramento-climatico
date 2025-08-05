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

        List<Sensor> listaSensores = new ArrayList<>();
        List<List<Double>> dados = new ArrayList<>();

        for(int i= 1; i<= 5; i++){
            listaSensores.add(new Sensor(String.valueOf(i)));
            dados.add(gerarLista());
        }

        listaSensores.add(new Sensor("6"));
        dados.add(gerarListaValida());

        SistemaMonitoramento sistema = new SistemaMonitoramento();
        sistema.processarSensores(listaSensores, dados);
        sistema.exibirRelatorio();

    }

    private static List<Double> gerarLista(){
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < Math.round(Math.random() * 100); i++) {
            lista.add((double) Math.round(Math.random()) * 10);
        }
        return lista;
    }

    private static List<Double> gerarListaValida(){
        List<Double> lista = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lista.add((double) Math.random() * 10 );
        }
        return lista;
    }

    private static void validar(double temp){
        if(temp < -50 || temp > 50){
            throw new LeituraInvalidaException(12, temp);
        }
    }
}
