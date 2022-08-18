package ua.en.kosse.oksana.tommy;

public class Animal {
    private String nickname;
    private Integer age;
    private String gender;

    public void setAnimal(String nickname, Integer age, String gender){
        this.nickname=nickname;
        this.age=age;
        this.gender=gender;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public String getMeow() {
        String s=nickname+' '+ age.toString()+' '+gender;
        return s;
    }

}
