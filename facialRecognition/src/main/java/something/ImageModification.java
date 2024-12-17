package something;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;

public class ImageModification {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void pixelizeImage(String inputPath, String outputPath, int pixelSize) {
        Mat image = Imgcodecs.imread(inputPath);
        Mat resized = new Mat();
        Size newSize = new Size(image.width() / pixelSize, image.height() / pixelSize);

        Imgproc.resize(image, resized, newSize, 0, 0, Imgproc.INTER_NEAREST);
        Imgproc.resize(resized, image, image.size(), 0, 0, Imgproc.INTER_NEAREST);

        Imgcodecs.imwrite(outputPath, image);
        System.out.println("Imagem pixelizada salva em: " + outputPath);
    }

    public static void main(String[] args) {
        pixelizeImage("caminho/para/imagem_original.jpg", "caminho/para/imagem_pixelizada.jpg", 10);
    }
}
