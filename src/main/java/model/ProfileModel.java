package model;

import lombok.Data;

@Data
public class ProfileModel {

    String Gender;
    String Birthday;
    int Weight;
    String Country;
    String State;
    String City;
    String Zip;

    public ProfileModel() {
    }


}
