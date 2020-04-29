package film.motphim;

import film.MoviesParser;
import film.MoviesService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class MotPhimParser extends MoviesParser<MotPhimModel>{
    private static List<MotPhimModel>motPhimModels=new ArrayList<>();
    private static List<String> linkArray = new ArrayList<>();
    private static  MotPhimParser motPhimParser=new MotPhimParser();
    private static MoviesService moviesService=new MoviesService();
    @Override
    public MotPhimModel parserDetail(String url) {
        Document html = getHtmlContent(url);
        MotPhimModel result=new MotPhimModel();

        String avatar=html.selectFirst("div.poster").selectFirst("img").attr("src");
        String name=html.selectFirst("span.title").ownText();
        String link="motphim.net"+html.selectFirst("div.poster").selectFirst("a.adspruce-streamlink").attr("href");
        String status = "";
        String director="";
        String type="";
        String cast="";
        String country="";
        String yearissue="";
        String totalepisodes="";
        String content;

        //Lay cac thong tin cua phim
        Element pros =html.selectFirst("dl.col");
        //Lay het cac phan tu con cua the dl.col
        Elements child = pros.children();
        for (int i = 0; i < child.size(); i++) {
            if(child.get(i).ownText().equals("Trạng thái:")){
                status = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Thể loại:")){
                type = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Đạo diễn:")){
                director = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Số tập:")){
                 totalepisodes= child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Quốc gia:")){
                country = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Năm sản xuất:")){
                yearissue = child.get(i+1).text();
            }
            if(child.get(i).ownText().equals("Diễn viên:")){
                cast = child.get(i+1).text();
            }
            content=html.selectFirst("div.tabs-content").selectFirst("div.tab").selectFirst("div").text();

            result.setName(name);
            result.setAvatar(avatar);
            result.setStatus(status);
            result.setDirector(director);
            result.setCast(cast);
            result.setCountry(country);
            result.setYearissue(yearissue);
            result.setType(type);
            result.setTotalepisodes(totalepisodes);
            result.setContent(content);
            result.setLink(link);
        }
        return result;
    }
    @Override
    public List<String> parserListLink(String url) {
        //Parser link chua danh sach cac phim de lay duoc link chi tiet moi phim
        Document html =getHtmlContent(url);
        Elements elements = html.select("li.item");

        List<String> linkArray = new ArrayList<>();

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkFilm = element.selectFirst("a").attr("href");
            linkArray.add("http://www.motphim.net/" + linkFilm);
        }
        return linkArray;
    }
    private Document getHtmlContent(String url) {
        Document pageHtml;
        try {
            Connection.Response response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .followRedirects(true)
                    .timeout(30000)
                    .execute();
            pageHtml = response.parse();
            return pageHtml;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void parserAllMovies() throws ClassNotFoundException {
        String url = "https://motphim.net/phim-thuyet-minh.html";
        linkArray = motPhimParser.parserListLink(url);
        for (String link : linkArray) {
            MotPhimModel motPhimModel = motPhimParser.parserDetail(link);
            moviesService.writeToDB(motPhimModel);

        }
    }

}
