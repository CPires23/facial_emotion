package something;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.opencv.global.opencv_face;
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.opencv.core.CvType;

import java.util.ArrayList;
import java.util.List;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;

public class FaceRecognition {
    public static void main(String[] args) {

        List<Integer> labels = new ArrayList<>();

        // Criar o reconhecedor LBPH
        LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();

        // Carregar imagens de treino
        Mat trainingImage = imread("caminho/para/imagem_treino.jpg", 0); // Imagem em escala de cinza
        Mat matLabels = new Mat(labels.size(), 1, CvType.CV_32SC1); // Etiqueta da imagem

        // Treinar o modelo
        recognizer.train(new Mat[]{trainingImage}, matLabels);

        // Realizar previsão em uma nova imagem
        Mat testImage = imread("caminho/para/imagem_teste.jpg", 0);
        IntPointer label = new IntPointer(1);
        DoublePointer confidence = new DoublePointer(1);

        recognizer.predict(testImage, label, confidence);

        System.out.println("Rótulo previsto: " + label.get() + ", Confiança: " + confidence.get());
    }
}
