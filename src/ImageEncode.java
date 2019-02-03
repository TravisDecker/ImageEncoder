import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

/**
 * The ImageEncode Class.
 */
public class ImageEncode {

  /**
   * The encoded Image represented as a string.
   */
  static String encodedImageString;
  /**
   * The Buffered Image.
   */
  static BufferedImage pic;

  /**
   * The main method is here for demonstration purposes.
   * The imageToString method is called passing the file path to the encodedImageString.
   * The stringToImage method is called passing the encoded string.
   *
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {

    try {
      encodedImageString =  imageToString("src/octocat.png");
    } catch (IOException e) {
      e.printStackTrace();
    }

    try {
      pic = stringtoImage(encodedImageString);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  /**
   * Converts an Image file into an encoded String.
   *
   * @param path the file path to the encodedImageString;
   * @return the Base64 encoded encodedImageString represented as a String.
   * @throws IOException the io exception
   */
  public static String imageToString(String path) throws IOException {
    BufferedImage image = ImageIO.read(new File(path));
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ImageIO.write(image, "png", outputStream);
    String encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());
    return encodedImage;
  }

  /**
   * Converts encoded image string into a buffered image.
   *
   * @param encodedImage the Base64 encoded encodedImageString represented as a String.
   * @return the buffered encodedImageString
   * @throws IOException the io exception
   */
  public static BufferedImage stringtoImage(String encodedImage) throws IOException {
    byte[] imageArray = Base64.getDecoder().decode(encodedImage);
    ByteArrayInputStream inputStream = new ByteArrayInputStream(imageArray);
    BufferedImage image = ImageIO.read(inputStream);
    return image;
  }

}
