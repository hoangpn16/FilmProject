package Film.MotPhim;

import Film.MoviesBase;

public class MotPhimModel extends MoviesBase {
    private String yearissue;

    public String getYearissue() {
        return yearissue;
    }

    public void setYearissue(String yearissue) {
        this.yearissue = yearissue;
    }
    @Override
    public String toString(){
        String phim = "Name:"+this.getName()+";"
                    +"Avatar:"+this.getAvatar()+";"
                    +"Status:"+this.getStatus()+";"
                    +"Director:"+this.getDirector()+";"
                    +"Type:"+this.getType()+";"
                    +"Total Episodes:"+this.getTotalepisodes()+";"
                    +"Cast:"+this.getCast()+";"
                    +"Country:"+this.getCountry()+";"
                    +"YearIssue:"+this.getYearissue()+";"
                    +"Content:"+this.getContent()+"";
        return phim;
    }
}
