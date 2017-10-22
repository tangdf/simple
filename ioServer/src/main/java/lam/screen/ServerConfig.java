package lam.screen;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class ServerConfig {
	public int getLocationX() {
		return locationX;
	}
	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}
	public int getLocationY() {
		return locationY;
	}
	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Value("${jframe.locationX}")
	private int locationX;
	@Value("${jframe.locationY}")
	private int locationY;
	@Value("${jframe.width}")
	private int width;
	@Value("${jframe.height}")
	private int height;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return locationX+" "+locationY;
	}

}
