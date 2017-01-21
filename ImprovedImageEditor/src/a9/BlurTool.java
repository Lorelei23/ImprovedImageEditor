package a9;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class BlurTool implements Tool{

	private BlurToolUI ui;
	private ImageEditorModel model;
	
	public BlurTool(ImageEditorModel model) {
		this.model = model;
		ui = new BlurToolUI();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		model.blurAt(e.getX(), e.getY(), ui.getBlurValue(), ui.getBrushSize());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.blurAt(e.getX(), e.getY(), ui.getBlurValue(), ui.getBrushSize());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Blur Tool";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
