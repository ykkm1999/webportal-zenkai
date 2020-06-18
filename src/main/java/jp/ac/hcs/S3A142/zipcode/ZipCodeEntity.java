package jp.ac.hcs.S3A142.zipcode;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ZipCodeEntity {

	/** ステータス */
	private String status;

	/** メッセージ */
	private String message;

	/** 郵便番号情報のリスト */
	private List<ZipCodeData> results = new ArrayList<ZipCodeData>();
}
