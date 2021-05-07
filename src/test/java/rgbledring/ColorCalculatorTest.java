package rgbledring;

import musa.stock.StockContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static rgbledring.Color.BLACK;
import static rgbledring.Color.WHITE;

public class ColorCalculatorTest {

    @Test
    @DisplayName("1 led on first ring turned on")
    public void calculateColors() {
        StockContext context = mockStockContext(2);

        List<Color> ledStates = new ColorCalculator(context).calculateColor(50, 0);

        assertThat(ledStates).containsExactly(WHITE, BLACK, BLACK, BLACK);
    }

    @Test
    @DisplayName("1 led on both rings turned on")
    public void calculateMoreColors() {
        StockContext context = mockStockContext(2);

        List<Color> ledStates = new ColorCalculator(context).calculateColor(50, 50);

        assertThat(ledStates).containsExactly(WHITE, BLACK, WHITE, BLACK);
    }

    @Test
    @DisplayName("1 led on first ring, 2 leds on second ring turned on")
    public void test3() {
        StockContext context = mockStockContext(2);
        List<Color> ledStates = new ColorCalculator(context).calculateColor(50, 100);

        assertThat(ledStates).containsExactly(WHITE, BLACK, WHITE, WHITE);
    }

    private StockContext mockStockContext(int ledsPerRing) {
        final StockContext stockContext = new StockContext() {
            @Override
            public int getRingLedCount(int ring) {
                return ledsPerRing;
            }

            @Override
            public boolean getDirectionForRing(int ring) {
                return false;
            }

            @Override
            public String getMqttHost() {
                return null;
            }

            @Override
            public int getMqttPort() {
                return 0;
            }
        };
        return stockContext;
    }
}
