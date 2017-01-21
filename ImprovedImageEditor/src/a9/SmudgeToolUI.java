package a9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SmudgeToolUI extends JPanel implements ChangeListener {

	private JSlider smudge_slider;
	private int smudge_value;
	private JSlider brush_size_slider;
	private int brush_size = 5;
	
	public SmudgeToolUI() {
		setLayout(new GridLayout(0,1));
		
		JPanel smudge_panel = new JPanel();
		smudge_panel.setLayout(new BorderLayout());
		
		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));
		
		JPanel smudge_slider_panel = new JPanel();
		JLabel smudge_label = new JLabel("Sensitivity: ");
		smudge_slider_panel.setLayout(new BorderLayout());
		smudge_slider_panel.add(smudge_label, BorderLayout.WEST);
		smudge_slider = new JSlider(1, 3, 1);
		smudge_slider.setMajorTickSpacing(1);
		smudge_slider.setPaintTicks(true);
		smudge_slider.setPaintLabels(true);
		smudge_slider.setSnapToTicks(true);
		smudge_slider.addChangeListener(this);
		smudge_slider_panel.add(smudge_slider, BorderLayout.CENTER);
		
		
		Dimension d = smudge_label.getPreferredSize();
		
		slider_panel.add(smudge_slider_panel);
		
		smudge_panel.add(slider_panel, BorderLayout.CENTER);
		
		add(smudge_panel);
		
		stateChanged(null);
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		smudge_value = smudge_slider.getValue();
		
	}
	
	public int getSmudgeValue() {
		
		return smudge_value;
	}
	
	public int getBrushSize() {
		return brush_size;
	}
	

}
