package utils;

import builders.ProfileBuilder;
import model.ProfileModel;

public class ProfileModelUtils {

    public static ProfileModel getDefaultProfileModel() {
        ProfileModel profileModel = new ProfileModel();
        profileModel.setGender("Female");
        profileModel.setBirthday("11/20/1991");
        profileModel.setWeight("48");
        profileModel.setWeightType("kg");
        profileModel.setCountry("Belarus");
        profileModel.setState("Minskaya voblasts");
        profileModel.setCity("Borisov");
        profileModel.setZip("202101");
        return profileModel;
    }

    public static ProfileModel checkResults() {
        ProfileBuilder.newValues()
//                .setName("Anna Verkhova")
//                .setEmail("werxowaanna1991@gmail.com")
                .setGender("Female")
                .setBirthday("11/20/1991")
                .setWeight("48")
                .setCountry("Belarus")
                .setState("Minskaya voblasts")
                .setCity("Borisov")
                .setZip("202101")
                .build();
        return new ProfileModel();
    }
}
