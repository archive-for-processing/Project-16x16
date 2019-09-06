package objects;

import processing.core.PImage;
import processing.core.PVector;
import sidescroller.SideScroller;
import sidescroller.SideScroller.debugType;
import sidescroller.Tileset;

public class BackgroundObject extends EditableObject {

	public PImage image;

	public BackgroundObject(SideScroller a) {
		super(a);

		type = type.BACKGROUND;
	}

	public BackgroundObject(SideScroller a, String id) {
		this(a);

		setGraphic(id);
	}

	public BackgroundObject(SideScroller a, String id, int x, int y) {
		this(a);

		pos = new PVector(x, y);
		setGraphic(id);
	}

	public void display() {
		float pixelOffsetX = 0;
		float pixelOffsetY = 0;

		if (height / 4 % 2 != 0) {
			pixelOffsetY = 2;
		}
		if (width / 4 % 2 != 0) {
			pixelOffsetX = 2;
		}

		applet.image(image, pos.x + pixelOffsetX, pos.y + pixelOffsetY);
	}

	public void update() {

	}

	public void setGraphic(String name) {
		image = Tileset.getTile(name);
		id = name;
		width = image.width;
		height = image.height;
	}
}
