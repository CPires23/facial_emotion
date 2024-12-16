import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;

public class FaceEmotionApp extends Application {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); } // Carrega a biblioteca OpenCV

    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reconhecimento Facial e de Emoções");

        FileChooser fileChooser = new FileChooser();
        Button uploadButton = new Button("Upload Imagem");
        imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);

        uploadButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                processImage(file.getAbsolutePath());
            }
        });

        VBox layout = new VBox(10, uploadButton, imageView);
        Scene scene = new Scene(layout, 500, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processImage(String imagePath) {
        // Carregar o classificador para detecção facial
        CascadeClassifier faceDetector = new CascadeClassifier("haarcascade_frontalface_alt.xml");

        // Carregar a imagem
        Mat image = Imgcodecs.imread(imagePath);
        MatOfRect faceDetections = new MatOfRect();

        // Detectar faces
        faceDetector.detectMultiScale(image, faceDetections);

        // Desenhar retângulos nas faces detectadas
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, 
                new Point(rect.x, rect.y), 
                new Point(rect.x + rect.width, rect.y + rect.height),
                new Scalar(0, 255, 0), 3);
        }

        // Salvar a imagem processada temporariamente
        String outputPath = "output.png";
        Imgcodecs.imwrite(outputPath, image);

        // Exibir a imagem processada no ImageView
        Image processedImage = new Image(new File(outputPath).toURI().toString());
        imageView.setImage(processedImage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
