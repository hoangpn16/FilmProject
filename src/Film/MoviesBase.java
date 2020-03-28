package Film;

public class MoviesBase {
    private String name;
    private String avatar;
    private String releaseday;
    private String status;
    private String director;
    private String cast;
    private String totalepisodes;
    private String type;
    private String country;
    private String views;
    private String content;
    private String tags;

    public MoviesBase() {
    }

    public MoviesBase(String name, String avatar, String releaseday, String status,
                      String director, String cast, String totalepisodes, String type,
                      String country, String views, String content, String tags) {
        this.name = name;
        this.avatar = avatar;
        this.releaseday = releaseday;
        this.status = status;
        this.director = director;
        this.cast = cast;
        this.totalepisodes = totalepisodes;
        this.type = type;
        this.country = country;
        this.views = views;
        this.content = content;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getReleaseday() {
        return releaseday;
    }

    public void setReleaseday(String releaseday) {
        this.releaseday = releaseday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getTotalepisodes() {
        return totalepisodes;
    }

    public void setTotalepisodes(String totalepisodes) {
        this.totalepisodes = totalepisodes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
