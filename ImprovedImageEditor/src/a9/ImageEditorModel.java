package a9;


public class ImageEditorModel {

	private Picture original;
	private ObservablePicture current;
	
	public ImageEditorModel(Picture f) {
		original = f;
		current = original.copy().createObservable();
	}

	public ObservablePicture getCurrent() {
		return current;
	}
	
	public Picture getOriginal() {
		return original;
	}

	public Pixel getPixel(int x, int y) {
		return current.getPixel(x, y);
	}

	public void paintAt(int x, int y, Pixel brushColor, int brush_size, double opacity) {
		current.suspendObservable();;
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					Pixel blended_p = current.getPixel(xpos, ypos).blend(brushColor, opacity);
					current.setPixel(xpos, ypos, blended_p);
				}
			}
		}
		current.resumeObservable();
	}
	
	public void blurAt(int x, int y, int blur_value, int brush_size) {
		current.suspendObservable();;
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size-1; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size-1; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					double red = 0.0;
					double green = 0.0;
					double blue = 0.0;
					int count = 0;

					for(int x2 = xpos - blur_value; x2 <= xpos + blur_value; x2++){
						for(int y2 = ypos - blur_value; y2 <= ypos + blur_value; y2++){
							try{
								Pixel p = current.getPixel(x2, y2);
								red += p.getRed();
								green += p.getGreen();
								blue += p.getBlue();
								count++;
							
							}catch(RuntimeException e){}
						}//end y2
					}//end x2
					
					double avgRed = red / (double)count;
					double avgGreen = green / (double)count;
					double avgBlue = blue / (double)count;

					Pixel blurredPixel = new ColorPixel(avgRed, avgGreen, avgBlue);
					current.setPixel(xpos, ypos, blurredPixel);
				}
			}
		}
		current.resumeObservable();
	}
	
	public void smudgeAt(int x, int y, int smudge_value, int brush_size) {
		current.suspendObservable();;
		
		for (int xpos=x-brush_size+1; xpos <=x+brush_size; xpos++) {
			for (int ypos=y-brush_size+1; ypos <=y+brush_size; ypos++) {
				if (xpos >= 0 &&
					xpos < current.getWidth() &&
					ypos >= 0 &&
					ypos < current.getHeight()) {
					double red = 0.0;
					double green = 0.0;
					double blue = 0.0;
					int count = 0;

					for(int x2 = x - smudge_value; x2 <= x + smudge_value; x2++){
						for(int y2 = y - smudge_value; y2 <= y + smudge_value; y2++){
							try{
								Pixel p = current.getPixel(x2, y2);
								red += p.getRed();
								green += p.getGreen();
								blue += p.getBlue();
								count++;
							
							}catch(RuntimeException e){}
						}//end y2
					}//end x2
					
					double avgRed = red / (double)count;
					double avgGreen = green / (double)count;
					double avgBlue = blue / (double)count;

					Pixel smudgedPixel = new ColorPixel(avgRed, avgGreen, avgBlue);
					current.setPixel(xpos, ypos, smudgedPixel);
				}
			}
		}
		current.resumeObservable();
	}
}
