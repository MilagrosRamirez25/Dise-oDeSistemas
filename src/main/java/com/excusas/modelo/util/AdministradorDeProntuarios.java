package com.excusas.modelo.util;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeProntuarios {

    private static AdministradorDeProntuarios instancia;
    private List<Prontuario> prontuarios = new ArrayList<>();
    private List<ObservadorCEO> observadores = new ArrayList<>();

    private AdministradorDeProntuarios() {}

    public static AdministradorDeProntuarios getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorDeProntuarios();
        }
        return instancia;
    }

    public void agregarObservador(ObservadorCEO observador) {
        observadores.add(observador);
    }

    public void registrarProntuario(Prontuario prontuario) {
        prontuarios.add(prontuario);
        notificarCEOs(prontuario);
    }

    private void notificarCEOs(Prontuario prontuario) {
        for (ObservadorCEO observador : observadores) {
            observador.notificarNuevoProntuario(prontuario);
        }
    }
}