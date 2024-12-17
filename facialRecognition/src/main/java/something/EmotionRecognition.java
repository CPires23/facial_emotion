package something;

import java.io.File;
import java.io.IOException;
import okhttp3.*;

public class EmotionRecognition {
    public static void main(String[] args) throws IOException {
        String imagePath = "caminho/para/imagem.jpg";
        String apiUrl = "http://localhost:5000/analyze";

        OkHttpClient client = new OkHttpClient();
        File imageFile = new File(imagePath);

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", imageFile.getName(),
                        RequestBody.create(imageFile, MediaType.parse("image/jpeg")))
                .build();

        Request request = new Request.Builder()
                .url(apiUrl)
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Resposta do servidor: " + response.body().string());
            } else {
                System.out.println("Erro na requisição: " + response.code());
            }
        }
    }
}
