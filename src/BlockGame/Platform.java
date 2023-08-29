package BlockGame;

public class Platform {
  private String name;
  private int x;
  private int y;

  private boolean hitTheWallX=false;
  private boolean hitTheWallY=false;

   private  boolean ballHit=false;
   static final int RECTANGLE_HEIGHT=20;
   static final int RECTANGLE_WIDTH=100;

  private String playerDirection="";
    public Platform(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isHitTheWallX() {
        return hitTheWallX;
    }
    public boolean isHitTheWallY() {
        return hitTheWallY;
    }

    public void setHitTheWallX(boolean hitTheWallX) {
        this.hitTheWallX = hitTheWallX;
    }
    public void setHitTheWallY(boolean hitTheWallY) {
        this.hitTheWallY= hitTheWallY;
    }

    public String getPlayerDirection() {
        return playerDirection;
    }

    public void setPlayerDirection(String playerDirection) {
        this.playerDirection = playerDirection;
    }

    public int getRECTANGLE_HEIGHT() {
        return RECTANGLE_HEIGHT;
    }

    public int getRECTANGLE_WIDTH() {
        return RECTANGLE_WIDTH;
    }

    public boolean isBallHit() {
        return ballHit;
    }

    public void setBallHit(boolean ballHit) {
        this.ballHit = ballHit;
    }

    public static void movePlayer(Platform player){
        switch (player.playerDirection) {


            case "L":
                if(!player.hitTheWallY)
                    player.x-=5;
                break;
            case "R":
                if(!player.hitTheWallX)
                    player.x+=5;
                break;

        }


    }
}
