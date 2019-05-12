package com.example.gaspimiamva.activites;

public class Contact {
    private String name;
    private String cellNum;
    private boolean favourites;

    //CONSTRUCTOR:
    public Contact(String n, String num) {
        this.name = n;
        this.cellNum = num;
        this.favourites = false;
    }

    public void changeFavouriteState() {
        this.favourites = !this.favourites;
    }


    //GETTERS:
    public String getName() {
        return this.name;
    }

    public String getCellNum() {
        return this.cellNum;
    }


    @Override
    public String toString() {
        return this.name+" ("+this.cellNum+")";
    }
}
