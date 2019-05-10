package com.example.gaspimiamva.models;



import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
public class UsersListModel implements Parcelable {

    private  static ArrayList<UserModel>listOfProfiles;

    public UsersListModel() {
        //listOfProfiles = FXCollections.observableList(new ArrayList<>());
        listOfProfiles= new ArrayList<>() ;
        listOfProfiles.add(new UserModel("Durand", "Jeanne", "Antibes", "jeanne.durand@orange.fr", "ass", "0636456767", "M"));
    }

    protected UsersListModel(Parcel in) {
        listOfProfiles = in.createTypedArrayList(UserModel.CREATOR);
    }

    public static final Creator<UsersListModel> CREATOR = new Creator<UsersListModel>() {
        @Override
        public UsersListModel createFromParcel(Parcel in) {
            return new UsersListModel(in);
        }

        @Override
        public UsersListModel[] newArray(int size) {
            return new UsersListModel[size];
        }
    };

    public void add(UserModel profile) {
        listOfProfiles.add(profile);
    }

    public  ArrayList<UserModel> getListOfProfiles() {
        return listOfProfiles;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(listOfProfiles);
    }
}

