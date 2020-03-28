package Film;
import java.util.List;

public  abstract class MoviesParser<T> {
    public abstract T parserDetail(String url);
    public abstract List<String> parserListLink(String url);
}
