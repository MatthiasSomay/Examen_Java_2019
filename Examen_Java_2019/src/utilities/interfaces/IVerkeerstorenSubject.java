/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Observer pattern - Subject interface
 */



package utilities.interfaces;

public interface IVerkeerstorenSubject {

    void addSchipObserver();
    void removeSchipObserver();
    void noodsituatieBroadcastBericht();
}
