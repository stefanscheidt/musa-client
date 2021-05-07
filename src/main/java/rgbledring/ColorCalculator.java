package rgbledring;

import musa.stock.StockContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static rgbledring.Color.BLACK;
import static rgbledring.Color.WHITE;

public class ColorCalculator {
    private final StockContext context;

    public ColorCalculator(StockContext context) {
        this.context = context;
    }

    public List<Color> calculateColor(int profitibilityAmount, int availabilityAmount) {
        List<Color> colorsFirstRing = getColors(profitibilityAmount, 1);
        List<Color> colorsSecondRing = getColors(availabilityAmount, 2);

        colorsFirstRing.addAll(colorsSecondRing);
        return colorsFirstRing;
    }

    private List<Color> getColors(int amount, int ring) {
        var ledCount = context.getRingLedCount(ring);
        var limit = Math.round(amount / 100.0 * ledCount);
        return IntStream.range(0, ledCount)
                .mapToObj(idx -> idx < limit ? WHITE : BLACK)
                .collect(Collectors.toList());
    }
}
