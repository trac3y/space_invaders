import javalib.worldimages.*;

public class Player extends Actor {

	int lives;

	Player(int x, int y) {
		super();
		this.x = x;
		this.y = y; 
		this.dx = Utils.PLAYER_SPD;
		this.dy = Utils.PLAYER_SPD;
		this.img = new FromFileImage(new Posn(x,y), Utils.PLAYER_IMG);
		this.lives = Utils.LIVES;
	}
	
	Player(int x, int y, int spd, int lives) {
		super();
		this.x = x;
		this.y = y; 
		this.dx = spd;
		this.dy = spd;
		this.img = new FromFileImage(new Posn(x,y), Utils.PLAYER_IMG);
		this.lives = lives;
	}
	
	void moveLeft() {
		this.x-=this.dx;
		this.img.pinhole = new Posn(this.x, this.y);
	}
	
	void moveRight() {
		this.x+=this.dx;
		this.img.pinhole = new Posn(this.x, this.y);
	}
	
	void moveUp() {
		this.y-=this.dy;
		this.img.pinhole = new Posn(this.x, this.y);
	}
	
	void moveDown() {
		this.y+=this.dy;
		this.img.pinhole = new Posn(this.x, this.y);
	}
	
	// Creates a new Missile leaving from the player's position
	Missile fire() {
		int halfHeight = (Integer)(this.img.getHeight() / 2);
		return new Missile(this.x, (this.y - (halfHeight + 1)), (-1 * Utils.MISSILE_SPD)); //make sure the player doesn't kill themself with their own missile....
	}

	int getLives() {
		return this.lives;
	}

	// updates this Actor when they are hit; returns null when Actor is destroyed
	Actor onHit() {
		this.lives--;
		return null;
	}
}
