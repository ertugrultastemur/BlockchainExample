import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Chain {

	List<Block> chainQueue;
	public Chain() {
		chainQueue = new ArrayList<Block>();
		chainQueue.add(addFirstBlock());
	}
	private Block addFirstBlock() {
		Block firstBlock = new Block(new java.util.Date(), "islemler");
		firstBlock.setPreviousHash(null);
		firstBlock.generateHash();
		return firstBlock;
	}
	
	public void addBlock(Block block) {
		Block newBlock = block;
		newBlock.setPreviousHash(chainQueue.get(chainQueue.size()-1).getHash());
		newBlock.generateHash();
		this.chainQueue.add(newBlock);
	}
	public void minedChain() {
		
		for(int i=0; i<chainQueue.size(); i++) {
			System.out.println(i+"-"+"transaction"+i+"-"+ chainQueue.get(i).getHash()+"\n" + chainQueue.get(i).getPreviousHash());
		}
		
	}
	
	public void valid() {
		System.out.println();
		for(int i=chainQueue.size()-1; i>0; i--) {
			if(   !(chainQueue.get(i).getHash().equals(chainQueue.get(i).generateHash()))   ) {
				System.out.println("Blockchain is Valid: false");
				return;
			}
			
			if(  !(chainQueue.get(i).getPreviousHash().equals(chainQueue.get(i-1).generateHash()))  ) {
				System.out.println("Blockchain is Valid: false");
				return;
			}
		}
		
		System.out.println("Blockchain is Valid: true");
		
	}
	
	public void outputChain() {		
		
		for(int i=0; i<chainQueue.size(); i++) {
			System.out.println();
			System.out.println("BlockId: " + i);
			System.out.println("Timestamp: " + chainQueue.get(i).getTimeStamp());
			System.out.println("PreviousHash: " + chainQueue.get(i).getPreviousHash());
			System.out.println("Hash: " + chainQueue.get(i).getHash());
			
		}
		
	}
	
}
