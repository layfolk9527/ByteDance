package vo;

import java.util.Date;

public class User {
    String userName;
    String chrName;
    String password;
    String gender;
    Date birth;
    String tel;

    public User(String userName, String password, String gender, String tel) {
        this.userName=userName;
        this.password=password;
        this.gender=gender;
        this.tel=tel;
    }

    public User() {

    }

    public String getChrName() {
        return chrName;
    }

    public void setChrName(String chrName) {
        this.chrName = chrName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birthday) {
        this.birth = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
