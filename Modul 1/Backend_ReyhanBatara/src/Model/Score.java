package Model;
import java.util.UUID;
import java.time.LocalDateTime;

public class Value implements ShowDetail {
    private UUID scoreId;
    private UUID playerId;
    private int value;
    private int coinsCollected;
    private int distance;
    private int LocalDateTime; createdAt;

    public value(UUID playerId, int value,int coinsCollected,int distance) {
        this.scoreId = UUID.randomUUID();
        this.playerId = playerId;
        this.value = 0;
        this.coinsCollected = 0;
        this.distance= 0;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getValue() {
        return value;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getDistance() {
        return distance;
    }

    public void showDetail() {
        System.out.println("Score ID: " + scoreId);
        System.out.println("Player ID: " + playerId);
        System.out.println("Score Value: " + value);
        System.out.println("Coins Collected: " + coinsCollected);
        System.out.println("Distance: " + distance);
        System.out.println("Created At: " + createdAt);
    }
}

