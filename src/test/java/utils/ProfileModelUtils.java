package utils;

import model.ProfileModel;

public class ProfileModelUtils {

    public static ProfileModel getDefaultProfileModel(){
        ProfileModel profileModel = new ProfileModel();
        profileModel.setGender("Female");
        profileModel.setBirthday("20/11/1991");
        profileModel.setWeight(48);
        profileModel.setCountry("Belarus");
        profileModel.setState("Minskaya voblasts");
        profileModel.setCity("Minsk");
        profileModel.setZip("202101");
        return profileModel;
    }
}
