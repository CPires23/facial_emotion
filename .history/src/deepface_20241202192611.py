from deepface import DeepFace
from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/analyze', methods=['POST'])
def analyze_image():
    file = request.files['image']
    file.save("uploaded_image.jpg")
    try:
        result = DeepFace.analyze(img_path="uploaded_image.jpg", actions=['emotion'])
        return jsonify({
            "dominant_emotion": result['dominant_emotion'],
            "confidence": result['emotion'][result['dominant_emotion']]
        })
    except Exception as e:
        return jsonify({"error": str(e)})

if __name__ == '__main__':
    app.run(port=5000)
