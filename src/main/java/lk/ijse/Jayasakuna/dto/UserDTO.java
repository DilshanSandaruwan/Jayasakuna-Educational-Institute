package lk.ijse.Jayasakuna.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class UserDTO {

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String Username;
    private String password;


    public UserDTO(String string, String string1) {
        Username = string;
        password = string1;
    }
}
