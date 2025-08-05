import java.util.ArrayList;
import java.util.List;

public class Sensor {
    private List<Double> leituras;
    private String id;

    public Sensor(String id) {
        this.id = id;
        this.leituras = new ArrayList<>();
    }

    public List<Double> getLeituras() {
        return leituras;
    }

    public String getId() {
        return id;
    }

    public void registrarLeituras(List<Double> leituras) throws LeituraInvalidaException{
        if(leituras.size() != 100) {
            throw new IllegalArgumentException("O total de leituras deve ser 100.");
        }

        for(Double temp : leituras){

            if(temp < -60 || temp > 60){
                throw  new LeituraInvalidaException(leituras.indexOf(temp), temp);
            }
        }

        this.leituras = leituras;
    }

    @Override
    public String toString() {
        return "id do sensor:" + id;
    }
}


