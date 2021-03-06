package a9;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class ImageEditorController implements ToolChoiceListener, MouseListener, MouseMotionListener {

	private ImageEditorView view;
	private ImageEditorModel model;
	private Tool current_tool;
	private PixelInspectorTool inspector_tool;
	private PaintBrushTool paint_brush_tool;
	private BlurTool blur_tool;
	private SmudgeTool smudge_tool;
	private List<ImageEditorModel> model_list = new ArrayList<ImageEditorModel>();
	
	public ImageEditorController(ImageEditorView view, ImageEditorModel model) {
		this.view = view;
		this.model = model;

		inspector_tool = new PixelInspectorTool(model);
		paint_brush_tool = new PaintBrushTool(model);
		blur_tool = new BlurTool(model);
		smudge_tool = new SmudgeTool(model);
		
		view.addToolChoiceListener(this);
		view.addMouseListener(this);
		view.addMouseMotionListener(this);
		
		this.toolChosen(view.getCurrentToolName());
	}
	
	public void updateView(ImageEditorView view){
		this.view = view;
		view.setToPrevious(model_list.get(model_list.size()-1));
		model_list.remove(model_list.size()-1);
		model = new ImageEditorModel(view.getModel().getCurrent());
		
	}
	
	@Override
	public void toolChosen(String tool_name) {
		
		if (tool_name.equals("Pixel Inspector")) {
			view.installToolUI(inspector_tool.getUI());
			current_tool = inspector_tool;
		} else if (tool_name.equals("Paint Brush")) {
			view.installToolUI(paint_brush_tool.getUI());
			current_tool = paint_brush_tool;
			model_list.add(new ImageEditorModel(model.getCurrent().copy()));
		} else if (tool_name.equals("Blur Tool")) {
			view.installToolUI(blur_tool.getUI());
			current_tool = blur_tool;
			model_list.add(new ImageEditorModel(model.getCurrent().copy()));
		}else if (tool_name.equals("Smudge Tool")) {
			view.installToolUI(smudge_tool.getUI());
			current_tool = smudge_tool;
			model_list.add(new ImageEditorModel(model.getCurrent().copy()));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		current_tool.mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		current_tool.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		current_tool.mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		current_tool.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		current_tool.mouseExited(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		current_tool.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		current_tool.mouseMoved(e);
	}

}
