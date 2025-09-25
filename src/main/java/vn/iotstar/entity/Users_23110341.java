package vn.iotstar.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users_23110341 {
    @Id
    @Column(name = "Username", length = 50)
    private String username;

    @Column(name = "Password", length = 50)
    private String password;

    @Column(name = "Phone", columnDefinition = "NVARCHAR(15)")
    private String phone;

    @Column(name = "Fullname", columnDefinition = "NVARCHAR(50)")
    private String fullname;

    @Column(name = "Email", columnDefinition = "NVARCHAR(150)")
    private String email;

    @Column(name = "Admin")
    private Boolean admin;

    @Column(name = "Active")
    private Boolean active;

    @Column(name = "Images", columnDefinition = "NVARCHAR(500)")
    private String images;

    @OneToMany(mappedBy = "user")
    private List<Favorites_23110341> favorites;

    @OneToMany(mappedBy = "user")
    private List<Shares_23110341> shares;

    // getters/setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getAdmin() { return admin; }
    public void setAdmin(Boolean admin) { this.admin = admin; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }
}
