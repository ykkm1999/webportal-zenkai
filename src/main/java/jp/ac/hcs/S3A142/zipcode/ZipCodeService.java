package jp.ac.hcs.S3A142.zipcode;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@Transactional
@Service

public class ZipCodeService {

	@Autowired
	RestTemplate restTemplate;

	/** 郵便番号検索API リクエストURL */
	private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";

	public ZipCodeEntity getZip(String zipcode) {

		// 外部APIアクセス
		String json = restTemplate.getForObject(URL, String.class, zipcode);

		ZipCodeEntity zipCodeEntity = new ZipCodeEntity();

		// Mapping

		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(json);

			zipCodeEntity.setStatus(node.get("status").asText());
			zipCodeEntity.setMessage(node.get("message").asText());

			for (JsonNode result : node.get("results")) {
				ZipCodeData zipCodeData = new ZipCodeData();
				zipCodeData.setZipcode(result.get("zipcode").asText());
				zipCodeData.setPrefcode(result.get("prefcode").asText());
				zipCodeData.setAddress1(result.get("address1").asText());
				zipCodeData.setAddress2(result.get("address2").asText());
				zipCodeData.setAddress3(result.get("address3").asText());
				zipCodeData.setKana1(result.get("kana1").asText());
				zipCodeData.setKana2(result.get("kana2").asText());
				zipCodeData.setKana3(result.get("kana3").asText());

				zipCodeEntity.getResults().add(zipCodeData);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return zipCodeEntity;
	}


}