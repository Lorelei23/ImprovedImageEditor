package a9;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class SmudgeTool implements Tool{

	private SmudgeToolUI ui;
	private ImageEditorModel model;
	
	public SmudgeTool(ImageEditorModel model) {
		this.model = model;
		ui = new SmudgeToolUI();
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
		model.smudgeAt(e.getX(), e.getY(), ui.getSmudgeValue(), ui.getBrushSize());
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		model.smudgeAt(e.getX(), e.getY(), ui.getSmudgeValue(), ui.getBrushSize());
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Smudge Tool";
	}

	@Override
	public JPanel getUI() {
		return ui;
	}

}
