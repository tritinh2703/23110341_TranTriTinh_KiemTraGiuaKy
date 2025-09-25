package vn.iotstar.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Videos")
public class Videos_23110341 {
    @Id
    @Column(name = "VideoId", length = 50)
    private String videoId;

    @Column(name = "Title", columnDefinition = "NVARCHAR(200)")
    private String title;

    @Column(name = "Poster", length = 50)
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description", columnDefinition = "NVARCHAR(500)")
    private String description;

    @Column(name = "Active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category_23110341 category;

    @OneToMany(mappedBy = "video")
    private List<Favorites_23110341> favorites;

    @OneToMany(mappedBy = "video")
    private List<Shares_23110341> shares;

    // getters/setters
    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPoster() { return poster; }
    public void setPoster(String poster) { this.poster = poster; }
    public Integer getViews() { return views; }
    public void setViews(Integer views) { this.views = views; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public Category_23110341 getCategory() { return category; }
    public void setCategory(Category_23110341 category) { this.category = category; }
}
