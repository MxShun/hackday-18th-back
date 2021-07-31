package com.kitteless.kittelessback.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kitteless.kittelessback.model.Image;
import com.kitteless.kittelessback.model.OcrRequest;
import com.kitteless.kittelessback.model.ZakoshiRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Repository
public class OcrRepository {

    public String read(String base64EncodedImage) {
        String request = generateRequestJson(base64EncodedImage);
        String result = doPost(request, base64EncodedImage);

        return result;
    }

    /**
     * JSON形式のリクエストを生成
     *
     * @param base64EncodedImage base64エンコードされた画像データ
     * @return json
     */
    private String generateRequestJson(String base64EncodedImage) {
        final String IMAGE_FORMAT = "jpeg";
        final String CLOVA_OCR_CUSTOM_API_VERSION = "V2";
        final String JAPANESE_LANGUAGE_CODE = "ja";

        Image image = new Image();
        image.setFormat(IMAGE_FORMAT);
        image.setName("hoge");
        // 341 - 479 - 125
        base64EncodedImage = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAkACQAAD/4QCeRXhpZgAATU0AKgAAAAgABQESAAMAAAABAAEAAAEaAAUAAAABAAAASgEbAAUAAAABAAAAUgEoAAMAAAABAAIAAIdpAAQAAAABAAAAWgAAAAAAAACQAAAAAQAAAJAAAAABAAOShgAHAAAAEgAAAISgAgAEAAAAAQAAAMqgAwAEAAAAAQAAANQAAAAAQVNDSUkAAABTY3JlZW5zaG90/+EJIWh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8APD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iWE1QIENvcmUgNS40LjAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIi8+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPD94cGFja2V0IGVuZD0idyI/PgD/7QA4UGhvdG9zaG9wIDMuMAA4QklNBAQAAAAAAAA4QklNBCUAAAAAABDUHYzZjwCyBOmACZjs+EJ+/+IP8ElDQ19QUk9GSUxFAAEBAAAP4GFwcGwCEAAAbW50clJHQiBYWVogB+UAAwAJABYAKwAjYWNzcEFQUEwAAAAAQVBQTAAAAAAAAAAAAAAAAAAAAAAAAPbWAAEAAAAA0y1hcHBsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASZGVzYwAAAVwAAABiZHNjbQAAAcAAAASCY3BydAAABkQAAAAjd3RwdAAABmgAAAAUclhZWgAABnwAAAAUZ1hZWgAABpAAAAAUYlhZWgAABqQAAAAUclRSQwAABrgAAAgMYWFyZwAADsQAAAAgdmNndAAADuQAAAAwbmRpbgAADxQAAAA+Y2hhZAAAD1QAAAAsbW1vZAAAD4AAAAAodmNncAAAD6gAAAA4YlRSQwAABrgAAAgMZ1RSQwAABrgAAAgMYWFiZwAADsQAAAAgYWFnZwAADsQAAAAgZGVzYwAAAAAAAAAIRGlzcGxheQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAG1sdWMAAAAAAAAAJgAAAAxockhSAAAAFAAAAdhrb0tSAAAADAAAAexuYk5PAAAAEgAAAfhpZAAAAAAAEgAAAgpodUhVAAAAFAAAAhxjc0NaAAAAFgAAAjBkYURLAAAAHAAAAkZubE5MAAAAFgAAAmJmaUZJAAAAEAAAAnhpdElUAAAAFAAAAohlc0VTAAAAEgAAApxyb1JPAAAAEgAAApxmckNBAAAAFgAAAq5hcgAAAAAAFAAAAsR1a1VBAAAAHAAAAthoZUlMAAAAFgAAAvR6aFRXAAAACgAAAwp2aVZOAAAADgAAAxRza1NLAAAAFgAAAyJ6aENOAAAACgAAAwpydVJVAAAAJAAAAzhlbkdCAAAAFAAAA1xmckZSAAAAFgAAA3BtcwAAAAAAEgAAA4ZoaUlOAAAAEgAAA5h0aFRIAAAADAAAA6pjYUVTAAAAGAAAA7ZlbkFVAAAAFAAAA1xlc1hMAAAAEgAAApxkZURFAAAAEAAAA85lblVTAAAAEgAAA95wdEJSAAAAGAAAA/BwbFBMAAAAEgAABAhlbEdSAAAAIgAABBpzdlNFAAAAEAAABDx0clRSAAAAFAAABExwdFBUAAAAFgAABGBqYUpQAAAADAAABHYATABDAEQAIAB1ACAAYgBvAGoAac7st+wAIABMAEMARABGAGEAcgBnAGUALQBMAEMARABMAEMARAAgAFcAYQByAG4AYQBTAHoA7QBuAGUAcwAgAEwAQwBEAEIAYQByAGUAdgBuAP0AIABMAEMARABMAEMARAAtAGYAYQByAHYAZQBzAGsA5gByAG0ASwBsAGUAdQByAGUAbgAtAEwAQwBEAFYA5AByAGkALQBMAEMARABMAEMARAAgAGMAbwBsAG8AcgBpAEwAQwBEACAAYwBvAGwAbwByAEEAQwBMACAAYwBvAHUAbABlAHUAciAPAEwAQwBEACAGRQZEBkgGRgYpBBoEPgQ7BEwEPgRABD4EMgQ4BDkAIABMAEMARCAPAEwAQwBEACAF5gXRBeIF1QXgBdlfaYJyAEwAQwBEAEwAQwBEACAATQDgAHUARgBhAHIAZQBiAG4A/QAgAEwAQwBEBCYEMgQ1BEIEPQQ+BDkAIAQWBBoALQQ0BDgEQQQ/BDsENQQ5AEMAbwBsAG8AdQByACAATABDAEQATABDAEQAIABjAG8AdQBsAGUAdQByAFcAYQByAG4AYQAgAEwAQwBECTAJAgkXCUAJKAAgAEwAQwBEAEwAQwBEACAOKg41AEwAQwBEACAAZQBuACAAYwBvAGwAbwByAEYAYQByAGIALQBMAEMARABDAG8AbABvAHIAIABMAEMARABMAEMARAAgAEMAbwBsAG8AcgBpAGQAbwBLAG8AbABvAHIAIABMAEMARAOIA7MDxwPBA8kDvAO3ACADvwO4A8wDvQO3ACAATABDAEQARgDkAHIAZwAtAEwAQwBEAFIAZQBuAGsAbABpACAATABDAEQATABDAEQAIABhACAAQwBvAHIAZQBzMKsw6TD8AEwAQwBEAAB0ZXh0AAAAAENvcHlyaWdodCBBcHBsZSBJbmMuLCAyMDIxAABYWVogAAAAAAAA8xYAAQAAAAEWylhZWiAAAAAAAACCxwAAPU////+8WFlaIAAAAAAAAEx4AAC1TAAACvJYWVogAAAAAAAAJ5cAAA1lAADIf2N1cnYAAAAAAAAEAAAAAAUACgAPABQAGQAeACMAKAAtADIANgA7AEAARQBKAE8AVABZAF4AYwBoAG0AcgB3AHwAgQCGAIsAkACVAJoAnwCjAKgArQCyALcAvADBAMYAywDQANUA2wDgAOUA6wDwAPYA+wEBAQcBDQETARkBHwElASsBMgE4AT4BRQFMAVIBWQFgAWcBbgF1AXwBgwGLAZIBmgGhAakBsQG5AcEByQHRAdkB4QHpAfIB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";
        //image.setData(base64EncodedImage);

        OcrRequest request = new OcrRequest();
        request.setVersion(CLOVA_OCR_CUSTOM_API_VERSION);
        request.setRequestId(UUID.randomUUID().toString());
        request.setTimestamp(System.currentTimeMillis());
        request.setLang(JAPANESE_LANGUAGE_CODE);
        request.setImages(List.of(image));

        // ためしにmultipart用のリクエストに組み立て直してみる
        ZakoshiRequest zakoshiRequest = new ZakoshiRequest();
        zakoshiRequest.setMessage(request);
        zakoshiRequest.setFile(base64EncodedImage);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
//            json = mapper.writeValueAsString(request);
            json = mapper.writeValueAsString(zakoshiRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    private String doPost(String requestJson, String base64) {
        String apiURL = "https://bef2c44061654479868834a873039292.apigw.ntruss.com/custom/v1/464/2580fcb43bc90fe421f10c7206a0f8ae6fd43667eaeda7c4d679e21910b0b1e9/general";
        String secretKey = "Q05vcnJzTUd0eE1mYVFVWkpDVHhNclFzcWR5T1p3VnM=";

        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(apiURL);
//            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
//            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.put(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
//            File file = new File(imageFile);
            writeMultiPart(wr, postParams, base64, boundary);
//            writeMultiPart(wr, requestJson, null, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            System.out.println(requestJson);
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e);
        }

        return response.toString();
    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, String base64, String boundary) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (base64 != null) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + "file.getName()" + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

//            try (FileInputStream fis = new FileInputStream(file)) {
//                byte[] buffer = new byte[8192];
//                int count;
//                while ((count = fis.read(buffer)) != -1) {
//                    out.write(buffer, 0, count);
//                }
//                out.write("\r\n".getBytes());
//            }

            byte[] bytes = Base64.getDecoder().decode(base64);
            out.write(bytes);
            out.write("\r\n".getBytes());

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }
}
