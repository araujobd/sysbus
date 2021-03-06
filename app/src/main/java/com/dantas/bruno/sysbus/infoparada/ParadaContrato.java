package com.dantas.bruno.sysbus.infoparada;

import com.dantas.bruno.sysbus.model.Parada;
import com.dantas.bruno.sysbus.model.Trajeto;

import java.util.List;

/**
 * Created by bruno on 19/06/17.
 */

public interface ParadaContrato {

  interface View {
    void configurarLista(List<Trajeto> trajetos);
    void retornarResultado(Trajeto trajeto);
  }

  interface Presenter {
    void buscarTrajetos(Parada parada);
    void escolher(Trajeto trajeto);
    void finish();
  }

}
