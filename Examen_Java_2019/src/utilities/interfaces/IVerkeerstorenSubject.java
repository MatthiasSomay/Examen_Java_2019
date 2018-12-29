/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Observer pattern - Subject interface
 */



package utilities.interfaces;

import model.Schip;

public interface IVerkeerstorenSubject {

    void addSchipObserver(Schip schip);
    void removeSchipObserver(Schip schip);
    void noodsituatieBroadcastBericht();
}
