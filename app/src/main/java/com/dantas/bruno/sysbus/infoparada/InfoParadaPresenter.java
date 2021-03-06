package com.dantas.bruno.sysbus.infoparada;

import com.dantas.bruno.sysbus.Listener;
import com.dantas.bruno.sysbus.repositorio.Repositorio;
import com.dantas.bruno.sysbus.repositorio.RepositorioImpl;
import com.dantas.bruno.sysbus.model.Parada;
import com.dantas.bruno.sysbus.model.Trajeto;

import java.util.List;

/**
 * Created by bruno on 19/06/17.
 */

public class InfoParadaPresenter implements ParadaContrato.Presenter {

  private ParadaContrato.View view;
  private Repositorio repositorio;

  public InfoParadaPresenter(ParadaContrato.View view) {
    this.view = view;
    this.repositorio = RepositorioImpl.getInstance();
  }

  @Override
  public void buscarTrajetos(Parada parada) {
    repositorio.buscarTrajetosNoPonto(parada, new Listener.Trajetos() {
      @Override
      public void onReady(List<Trajeto> trajetos) {
        view.configurarLista(trajetos);
      }
    });
  }

  @Override
  public void escolher(Trajeto trajeto) {
    view.retornarResultado(trajeto);
  }

  @Override
  public void finish() {
    repositorio = null;
    view = null;
  }
}
