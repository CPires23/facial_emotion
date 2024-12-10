import org.bytedeco.opencv.global.opencv_face;
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;

public class FaceRecognition {
    public static void main(String[] args) {
        // Criar o reconhecedor LBPH
        LBPHFaceRecognizer recognizer = opencv_face.LBPHFaceRecognizer.create();

        // Carregar imagens de treino
        Mat trainingImage = imread("caminho/para/imagem_treino.jpg", 0); // Imagem em escala de cinza
        Mat labels = new Mat(new int[]{1}, new int[]{1}); // Etiqueta da imagem

        // Treinar o modelo
        recognizer.train(new Mat[]{trainingImage}, labels);

        // Realizar previsão em uma nova imagem
        Mat testImage = imread("caminho/para/imagem_teste.jpg", 0);
        IntPointer label = new IntPointer(1);
        DoublePointer confidence = new DoublePointer(1);

        recognizer.predict(testImage, label, confidence);

        System.out.println("Rótulo previsto: " + label.get() + ", Confiança: " + confidence.get());
    }
}
