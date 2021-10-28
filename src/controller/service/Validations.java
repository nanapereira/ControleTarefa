package controller.service;

import java.time.LocalDateTime;

public class Validations {

    public boolean compareDataInicioHoje(LocalDateTime dataInicio) {

        if (dataInicio.isBefore(LocalDateTime.now())) {
            return false;
        }else{
            return true;
        }
    }

    public boolean compareDataFimHoje(LocalDateTime dataFim) {

        if (dataFim.isBefore(LocalDateTime.now())) {
            return false;
        }else{
            return true;
        }
    }

    public boolean compareDataInicioDataFim(LocalDateTime dataInicio, LocalDateTime dataFim) {

        if (dataFim.isBefore(dataInicio)) {
            return false;
        }
        return true;
    }

}