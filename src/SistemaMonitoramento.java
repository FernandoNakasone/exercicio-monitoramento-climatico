import java.util.ArrayList;
import java.util.List;

public class SistemaMonitoramento {
    private List<Sensor> sensoresValidos;
    private List<ErroSensor> sensoresComErro;

    public SistemaMonitoramento(){
        this.sensoresValidos = new ArrayList<>();
        this.sensoresComErro = new ArrayList<>();
    }

    public void exibirRelatorio(){
        System.out.println("==== Sensores Válidos ====");
        for(Sensor s : sensoresValidos){
            System.out.println("Sensor:" + s.getId());
        }

        System.out.println("---------------------------------------------------------------------");

        System.out.println("=== Sensores com erro ====");

        for(ErroSensor e : sensoresComErro){
            System.out.println("Sensores com erro:" + e.getIdSensor() + " Erro:" + e.getMensagemErro());
        }
    }

    public void processarSensores(List<Sensor> sensor, List<List<Double>> dados){
        for(Sensor s : sensor){
            List<Double> leitura = dados.get(sensor.indexOf(s));

            try {
                s.registrarLeituras(leitura);
                sensoresValidos.add(s);
            }
            catch (LeituraInvalidaException | IllegalArgumentException e){
                sensoresComErro.add(new ErroSensor(s.getId(), e.getMessage()));
            }
        }
    }
}
