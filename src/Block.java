import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.List;


public class Block {

	private Date timeStamp;
	private String data;
	private String hash;
	private String previousHash;
	

	public Block(Date timeStamp,String data) {
		
		this.timeStamp = timeStamp;
		this.data = data;
		this.hash = generateHash();

	}

	public String generateHash() {
		
		String dataToHash = "" + this.data+this.timeStamp+this.previousHash;
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("MD5");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.hash = encoded;
		return encoded;
		
	}



	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}


}




