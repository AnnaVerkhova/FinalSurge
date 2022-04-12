package model;

import lombok.Data;

@Data
public class ProfileModel {

//    String Name;
//    String Email;
    String Gender;
    String Birthday;
    String Weight;
    String WeightType;
    String Country;
    String State;
    String City;
    String Zip;

    public ProfileModel() {
    }
}
