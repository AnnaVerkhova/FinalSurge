package builders;


import model.ProfileModel;

public class ProfileBuilder {

    public ProfileBuilder(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

    ProfileModel profileModel = new ProfileModel();

    public static ProfileBuilder newValues() {
        return new ProfileBuilder();
    }

    public ProfileBuilder() {}


    public ProfileBuilder setName(String name){
        this.profileModel.setName(name);
        return this;
    }
    public ProfileBuilder setEmail(String email){
        this.profileModel.setEmail(email);
        return this;
    }
    public ProfileBuilder setGender(String gender){
        this.profileModel.setGender(gender);
        return this;
    }
    public ProfileBuilder setBirthday(String birthday){
        this.profileModel.setBirthday(birthday);
        return this;
    }
    public ProfileBuilder setWeight(String weight){
        this.profileModel.setWeight(weight);
        return this;
    }
    public ProfileBuilder setCountry(String country){
        this.profileModel.setCountry(country);
        return this;
    }
    public ProfileBuilder setState(String state){
        this.profileModel.setState(state);
        return this;
    }
    public ProfileBuilder setCity(String city){
        this.profileModel.setCity(city);
        return this;
    }
    public ProfileBuilder setZip(String zip){
        this.profileModel.setZip(zip);
        return this;
    }
    public ProfileModel build() {
        return profileModel;
    }
}
