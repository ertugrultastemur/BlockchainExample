import java.util.Arrays;

import javax.sound.midi.Track;

public class TRYCoin {

	public static void main(String[] args) {
		
		Chain TRYCoin = new Chain();
		
		Block a1 = new Block( new java.util.Date(), "<transactions>");
		Block a2 = new Block( new java.util.Date(), "<transactions>");
		
		TRYCoin.addBlock(a1);
		TRYCoin.addBlock(a2);

		
		TRYCoin.minedChain();
		TRYCoin.valid();
		TRYCoin.outputChain();
	}
	
}
