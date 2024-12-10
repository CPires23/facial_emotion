public class DataPreparation {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        String folderPath = "caminho/para/imagens";
        File folder = new File(folderPath);

        // Verifica e carrega imagens da pasta
        if (folder.isDirectory()) {
            List<Mat> images = new ArrayList<>();
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jpg")) {
                    Mat image = Imgcodecs.imread(file.getAbsolutePath());
                    if (!image.empty()) {
                        images.add(image);
                        System.out.println("Imagem carregada: " + file.getName());
                    }
                }
            }
            System.out.println("Total de imagens carregadas: " + images.size());
        } else {
            System.out.println("Pasta não encontrada!");
        }
    }
}
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataPreparation {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        String folderPath = "caminho/para/imagens";
        File folder = new File(folderPath);

        // Verifica e carrega imagens da pasta
        if (folder.isDirectory()) {
            List<Mat> images = new ArrayList<>();
            for (File file : folder.listFiles()) {
                if (file.isFile() && file.getName().endsWith(".jpg")) {
                    Mat image = Imgcodecs.imread(file.getAbsolutePath());
                    if (!image.empty()) {
                        images.add(image);
                        System.out.println("Imagem carregada: " + file.getName());
                    }
                }
            }
            System.out.println("Total de imagens carregadas: " + images.size());
        } else {
            System.out.println("Pasta não encontrada!");
        }
    }
}
