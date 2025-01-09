package com.example.campionatopallavolo;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

public class CampionatoController {

    private Squadra[] squadre = new Squadra[10];
    private int indiceSquadre = 0;

    @FXML
    private TextArea textArea;

    @FXML
    private void aggiungiSquadra() {
        String nomeInput = mostraDialogo("Aggiungi Squadra", "Inserisci il nome della squadra:");
        if (nomeInput != null) {
            if (indiceSquadre < squadre.length) {
                squadre[indiceSquadre] = new Squadra(nomeInput);
                indiceSquadre++;
                textArea.appendText("Squadra " + nomeInput + " aggiunta al campionato.\n");
            } else {
                textArea.appendText("Impossibile aggiungere, numero massimo di squadre raggiunto.\n");
            }
        } else {
            textArea.appendText("Operazione annullata o input non valido.\n");
        }
    }

    @FXML
    private void mostraSquadre() {
        textArea.clear();
        if (indiceSquadre == 0) {
            textArea.appendText("Nessuna squadra registrata.\n");
        } else {
            for (int i = 0; i < indiceSquadre; i++) {
                Squadra squadra = squadre[i];
                textArea.appendText(squadra.getNome() + " - Punti: " + squadra.getPunti() +
                        ", Set Vinti: " + squadra.getSetVinti() +
                        ", Partite Vinte: " + squadra.getPartiteVinte() +
                        ", Partite Perse: " + squadra.getPartitePerse() + "\n");
            }
        }
    }

    @FXML
    private void aggiornaPuntiSquadra() {
        String nomeInput = mostraDialogo("Aggiorna Punti Squadra", "Inserisci il nome della squadra:");
        if (nomeInput != null) {
            Squadra squadra = trovaSquadra(nomeInput);
            if (squadra != null) {
                squadra.setPunti(3);
                textArea.appendText("Punti aggiornati per la squadra " + nomeInput + ".\n");
            } else {
                textArea.appendText("Squadra non trovata.\n");
            }
        } else {
            textArea.appendText("Operazione annullata o input non valido.\n");
        }
    }

    private Squadra trovaSquadra(String nome) {
        for (int i = 0; i < indiceSquadre; i++) {
            if (squadre[i].getNome().equalsIgnoreCase(nome)) {
                return squadre[i];
            }
        }
        return null;
    }

    private String mostraDialogo(String titolo, String messaggio) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titolo);
        dialog.setHeaderText(messaggio);
        dialog.initOwner(textArea.getScene().getWindow());
        dialog.show();
        return dialog.getEditor().getText();
    }
}

