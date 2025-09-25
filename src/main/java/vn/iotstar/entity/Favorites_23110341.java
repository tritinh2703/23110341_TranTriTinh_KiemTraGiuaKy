package vn.iotstar.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Favorites")
public class Favorites_23110341 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FavoriteId")
    private Integer favoriteId;

    @Column(name = "LikedDate")
    private LocalDate likedDate;

    @ManyToOne @JoinColumn(name = "VideoId")
    private Videos_23110341 video;

    @ManyToOne @JoinColumn(name = "Username")
    private Users_23110341 user;

    // getters/setters
    public Integer getFavoriteId() { return favoriteId; }
    public void setFavoriteId(Integer favoriteId) { this.favoriteId = favoriteId; }
    public LocalDate getLikedDate() { return likedDate; }
    public void setLikedDate(LocalDate likedDate) { this.likedDate = likedDate; }
    public Videos_23110341 getVideo() { return video; }
    public void setVideo(Videos_23110341 video) { this.video = video; }
    public Users_23110341 getUser() { return user; }
    public void setUser(Users_23110341 user) { this.user = user; }
}
