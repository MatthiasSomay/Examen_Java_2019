/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 19/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: Observer pattern - Subject interface
 */



package model;

public interface IVerkeerstorenSubject {

    public void addSchipObserver();
    public void removeSchipObserver();
    public void noodsituatieBroadcastBericht();
}