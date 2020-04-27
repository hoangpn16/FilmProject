package film.motphim;

import film.MoviesParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class MotPhimParser extends MoviesParser<MotPhimModel>{
    private static List<MotPhimModel>motPhimModels=new ArrayList<>();
    private static List<String> linkArray = new ArrayList<>();
    private static  MotPhimParser motPhimParser=new MotPhimParser();
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
        Document html = getHtmlContent(url);
        Elements elements = html.select("li.item");

        List<String> linkArray = new ArrayList<>();

        for(int i=0; i < elements.size(); i ++){
            Element element = elements.get(i);
            String linkFilm = element.selectFirst("a").attr("href");
            linkArray.add("http://www.motphim.net/" + linkFilm);
        }
        return linkArray;
    }
    public void parserAllMovies() throws ClassNotFoundException{
        String url = "https://motphim.net/phim-thuyet-minh.html";
        linkArray = motPhimParser.parserListLink(url);
        for(String link : linkArray){
            MotPhimModel motPhimModel = motPhimParser.parserDetail(link);

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                return;
            }

            java.sql.Connection connection = null;
            try {
                connection = DriverManager
                        .getConnection("jdbc:mysql://127.0.0.1:3306/javacore?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC", "root", "phanhoang1602");

                String sql = "insert into javacore.movies (Name,Avatar,Status,Director,Type,Total Episodes,Cast,Country,YearIssue,Link,Content) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(2,motPhimModel.getName());
                preparedStatement.setString(3,motPhimModel.getAvatar());
                preparedStatement.setString(4,motPhimModel.getStatus());
                preparedStatement.setString(5,motPhimModel.getDirector());
                preparedStatement.setString(6,motPhimModel.getType());
                preparedStatement.setString(7,motPhimModel.getTotalepisodes());
                preparedStatement.setString(8,motPhimModel.getCast());
                preparedStatement.setString(9,motPhimModel.getCountry());
                preparedStatement.setString(10,motPhimModel.getYearissue());
                preparedStatement.setString(11,motPhimModel.getLink());
                preparedStatement.setString(12,motPhimModel.getContent());

                preparedStatement.executeUpdate();



            } catch (
                    SQLException e) {
                System.out.println(e);
                return;
            } finally {
                try {
                    if (connection != null)
                        connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

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
}
