package a9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements ActionListener{

	private JPanel button_panel;
	private JButton open;
	private JButton reset;
	private JButton undo;
	private ImageEditorView view;
	private ImageEditorController controller;
	private Picture resetTo;
	
	public ButtonPanel(ImageEditorView view, ImageEditorController controller) {
		this.view = view;
		this.controller = controller;
		
		resetTo = view.getModel().getOriginal();
		
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(1, 0));
		open = new JButton("open");
		reset = new JButton("reset");
		undo = new JButton("undo last action");
		open.addActionListener(this);
		reset.addActionListener(this);
		undo.addActionListener(this);
		button_panel.add(open);
		button_panel.add(reset);
		button_panel.add(undo);
		
		add(button_panel);
		
		view.add(button_panel, BorderLayout.NORTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == open){
			try {
				view.updateModel();
				resetTo = view.getModel().getOriginal();
				view.add(button_panel, BorderLayout.NORTH);
			} catch (IOException e1) {}
			
			controller = new ImageEditorController(view, view.getModel());
		}
		
		if(e.getSource() == reset){
			view.resetModel(resetTo);
			view.add(button_panel, BorderLayout.NORTH);
			controller = new ImageEditorController(view, view.getModel());
		}
		
		//undoes all actions since last tool change
		//only undoes once (-_-)
		if(e.getSource() == undo){
			controller.updateView(view);
			view.add(button_panel, BorderLayout.NORTH);
			controller = new ImageEditorController(view, view.getModel());
			
		}
	}
	
}
