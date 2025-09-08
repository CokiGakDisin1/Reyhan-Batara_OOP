package Model;
import java.util.UUID;
import java.time.LocalDateTime;

public class player implements ShowDetail {
    private UUID playerId;
    private String username;
    private int highScore;
    private int totalCoins;
    private int totalDistance;
    private int LocalDateTime
    createdAt;

public Player(String username) {
    this.playerId = UUID.randomUUID();
    this.username = username;
    this.highScore = 0;
    this.totalCoins = 0;
    this.totalDistance = 0;
    this.createdAt = LocalDateTime.now();
}

public UUID getPlayerId() {
    return playerId;
}

public void updateHighScore(int newScore) {
    if(newScore > this.highScore ) {
        this.highScore = newScore;
    }
}

public void addCoins(int coins) {
    this.totalCoins += coins;

}

public void showDetail() {
    System.out.println("Player ID: " + playerId);
    System.out.println("Username: " + username);
    System.out.println("HighScore: " + highScore);
    System.out.println("Total Coins: " + totalCoins);
    System.out.println("Total Distance: " + totalDistance);
    System.out.println("Created At: " + createdAt);
}
}
