package vn.iotstar.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Shares")
public class Shares_23110341 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShareId")
    private Integer shareId;

    @Column(name = "Emails", length = 50)
    private String emails;

    @Column(name = "SharedDate")
    private LocalDate sharedDate;

    @ManyToOne @JoinColumn(name = "Username")
    private Users_23110341 user;

    @ManyToOne @JoinColumn(name = "VideoId")
    private Videos_23110341 video;

    // getters/setters
    public Integer getShareId() { return shareId; }
    public void setShareId(Integer shareId) { this.shareId = shareId; }
    public String getEmails() { return emails; }
    public void setEmails(String emails) { this.emails = emails; }
    public LocalDate getSharedDate() { return sharedDate; }
    public void setSharedDate(LocalDate sharedDate) { this.sharedDate = sharedDate; }
    public Users_23110341 getUser() { return user; }
    public void setUser(Users_23110341 user) { this.user = user; }
    public Videos_23110341 getVideo() { return video; }
    public void setVideo(Videos_23110341 video) { this.video = video; }
}
