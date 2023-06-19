/*
 * Author Name: Shivansh Bohra
 * Date: 04-11-2022
 * Created With: IntelliJ IDEA Community Edition
 */

package model_class;

public class User {
    private String user_name;
    private String password;
    private String mobile_no;

    public User() {
    }

    public User(String user_name, String password, String mobile_no) {
        this.user_name = user_name;
        this.password = password;
        this.mobile_no = mobile_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @Override
    public String toString() {
        return "User{" + "user_name='" + user_name + '\'' + ", password='" + password + '\'' + ", mobile_no='" + mobile_no + '\'' + '}';
    }
}
