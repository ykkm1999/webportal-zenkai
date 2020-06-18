package jp.ac.hcs.S3A142.zipcode;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ZipCodeData {

	/** 郵便番号 */
	private String zipcode;

	/** 都道府県コード */
	private String prefcode;

	/** 都道府県名 */
	private String address1;

	/** 市区町村名 */
	private String address2;

	/** 町域名 */
	private String address3;

	/** 都道府県名カナ */
	private String kana1;

	/** 市区町村名カナ */
	private String kana2;

	/** 町域名カナ */
	private String kana3;
}
