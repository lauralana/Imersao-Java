import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class StickerGenerate {
    
    public void edited(InputStream input, String newArchive) throws Exception {
        // leitura de img do diretório e por URL
        //InputStream input = new FileInputStream(new File("images/TopMovies_.jpg"));
        // InputStream input = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg").openStream();
        BufferedImage poster = ImageIO.read(input);

        // cria nova imagem em memoria
        int width = poster.getWidth();
        int height = poster.getHeight();
        int newHeight = height + 200;
        var newPoster = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copia a img original para nova img(em memoria)
        Graphics2D graphics = (Graphics2D) newPoster.getGraphics();
        graphics.drawImage(poster, 0, 0, null);

        // escrever uma frase na nova img
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        graphics.drawString("TEXT", 0, newHeight - 100);

        // escrever a nova img em um arquivo
        // ImageIO.write(newPoster, "png", new File("return/editedImg.png"));
        ImageIO.write(newPoster, "png", new File(newArchive));
    }

    // esse pedaço de código na vdd fica na pasta App
    // public static void main(String[] args) throws Exception {
    //     var generate = new StickerGenerate();
    //     generate.edited();
    // }
}