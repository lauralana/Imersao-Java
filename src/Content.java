public class Content {

    private final String title;
    private final String urlImg;
    private final String star;

    public Content(String title, String urlImg, String star) {
        this.title = title;
        this.urlImg = urlImg;
        this.star = star;
    }

    public String getTitle() {
        return title;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public String getStar() {
        return star;
    }
}
