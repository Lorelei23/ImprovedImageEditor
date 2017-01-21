package a9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BlurToolUI extends JPanel implements ChangeListener {

	private JSlider blur_slider;
	private int blur_value;
	private JSlider brush_size_slider;
	private int brush_size = 5;
	
	public BlurToolUI() {
		setLayout(new GridLayout(0,1));
		
		JPanel blur_panel = new JPanel();
		blur_panel.setLayout(new BorderLayout());
		
		JPanel slider_panel = new JPanel();
		slider_panel.setLayout(new GridLayout(0,1));
		
		JPanel blur_slider_panel = new JPanel();
		JLabel blur_label = new JLabel("Blur: ");
		blur_slider_panel.setLayout(new BorderLayout());
		blur_slider_panel.add(blur_label, BorderLayout.WEST);
		blur_slider = new JSlider(1, 5, 1);
		blur_slider.setMajorTickSpacing(1);
		blur_slider.setPaintTicks(true);
		blur_slider.setPaintLabels(true);
		blur_slider.setSnapToTicks(true);
		blur_slider.addChangeListener(this);
		blur_slider_panel.add(blur_slider, BorderLayout.CENTER);
		
		JPanel brush_size_slider_panel = new JPanel();
		JLabel brush_size_label = new JLabel("Brush Size: ");
		brush_size_slider_panel.setLayout(new BorderLayout());
		brush_size_slider_panel.add(brush_size_label, BorderLayout.WEST);
		brush_size_slider = new JSlider(1, 50, 5);
		brush_size_slider.addChangeListener(this);
		brush_size_slider_panel.add(brush_size_slider, BorderLayout.CENTER);
		
		Dimension d = brush_size_label.getPreferredSize();
		blur_label.setPreferredSize(d);
		
		slider_panel.add(blur_slider_panel);
		slider_panel.add(brush_size_slider_panel);
		
		blur_panel.add(slider_panel, BorderLayout.CENTER);
		
		add(blur_panel);
		
		stateChanged(null);
		
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		brush_size = brush_size_slider.getValue();
		blur_value = blur_slider.getValue();
		
	}
	
	public int getBlurValue() {
		
		return blur_value;
	}
	
	public int getBrushSize() {
		return brush_size;
	}
	

}
