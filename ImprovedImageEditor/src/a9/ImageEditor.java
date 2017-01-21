package a9;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageEditor {
	public static void main(String[] args) throws IOException {
		Picture f = PictureImpl.readFromURL("https://68.media.tumblr.com/308dda68a4c00f6a019c838ea81d2988/tumblr_ok3rg7cuqc1r1gicao1_r1_400.jpg");

		JFrame main_frame = new JFrame();
		main_frame.setTitle("Assignment 9 Image Editor");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageEditorModel model = new ImageEditorModel(f);
		ImageEditorView view = new ImageEditorView(main_frame, model);
 		ImageEditorController controller = new ImageEditorController(view, model);
		
 		ButtonPanel buttons = new ButtonPanel(view, controller);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		top_panel.add(view, BorderLayout.CENTER);
		main_frame.setContentPane(top_panel);

		main_frame.pack();
		main_frame.setVisible(true);
	}
}