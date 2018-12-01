package musa.stock;

import musa.fwk.ClientContext;

public class StockContext implements ClientContext {

	/**
	 * Returns the amount of leds of the ring.
	 * 
	 * @param ring number of ring
	 * @return amount of leds
	 */
	public int getRingLedCount(int ring) {
		return 16;
	}

	/**
	 * When value on ring should be shown clockwise <code>true</code> is returned,
	 * otherwise <code>false</code>.
	 * 
	 * @param ring number of ring
	 * @return <code>true</code> for clockwise
	 */
	public boolean getDirectionForRing(int ring) {
		return true;
	}

}
