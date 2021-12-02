import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class adder {

	protected Shell shell;
	private Text text_1;
	private Text text_2;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			adder window = new adder();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setFont(SWTResourceManager.getFont("Comic Sans MS", 32, SWT.BOLD));
		lblTitle.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		lblTitle.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblTitle.setText("Calculator");
		new Label(shell, SWT.NONE);
		
		Label lblInput_1 = new Label(shell, SWT.NONE);
		lblInput_1.setText("Input 1:");
		lblInput_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		lblInput_1.setFont(SWTResourceManager.getFont("Comic Sans MS", 16, SWT.NORMAL));
		lblInput_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblInput_2 = new Label(shell, SWT.NONE);
		lblInput_2.setText("Input 2:");
		lblInput_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblInput_2.setFont(SWTResourceManager.getFont("Comic Sans MS", 16, SWT.NORMAL));
		lblInput_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		lblInput_2.setBounds(0, 0, 57, 19);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnSubtract = new Button(shell, SWT.NONE);
		btnSubtract.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		
		btnSubtract.setText("Subtract");
		btnSubtract.setFont(SWTResourceManager.getFont("Comic Sans MS", 11, SWT.BOLD));
		formToolkit.adapt(btnSubtract, true, true);
		
		Button btnAdd = new Button(shell, SWT.NONE);
		
		btnAdd.setFont(SWTResourceManager.getFont("Comic Sans MS", 11, SWT.BOLD));
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAdd.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnAdd.setText("Add");
		
		Button btnMultiply = new Button(shell, SWT.NONE);
		btnMultiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnMultiply.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		btnMultiply.setText("Multiply");
		btnMultiply.setFont(SWTResourceManager.getFont("Comic Sans MS", 11, SWT.BOLD));
		formToolkit.adapt(btnMultiply, true, true);
		
		Button btnDivide = new Button(shell, SWT.NONE);
		
		GridData gd_btnDivide = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gd_btnDivide.heightHint = 39;
		btnDivide.setLayoutData(gd_btnDivide);
		btnDivide.setText("Divide");
		btnDivide.setFont(SWTResourceManager.getFont("Comic Sans MS", 11, SWT.BOLD));
		formToolkit.adapt(btnDivide, true, true);
		new Label(shell, SWT.NONE);
		
		Label lblAnswer = new Label(shell, SWT.NONE);
		lblAnswer.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		lblAnswer.setText("Answer:");
		lblAnswer.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		lblAnswer.setFont(SWTResourceManager.getFont("Comic Sans MS", 16, SWT.NORMAL));
		lblAnswer.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		formToolkit.adapt(lblAnswer, true, true);
		
		btnSubtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int given1 = Integer.parseInt(text_1.getText());
				int given2 = Integer.parseInt(text_2.getText());
				
				int result = given1 - given2;
				
				lblAnswer.setText(Integer.toString(result));
				
			}
		});
		
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int given1 = Integer.parseInt(text_1.getText());
				int given2 = Integer.parseInt(text_2.getText());
				
				int result = given1 + given2;
				
				lblAnswer.setText(Integer.toString(result));
			}
		});
		
		btnDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int given1 = Integer.parseInt(text_1.getText());
				int given2 = Integer.parseInt(text_2.getText());
				
				int result = given1 / given2;
				
				lblAnswer.setText(Integer.toString(result));
			}
		});
		
		btnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int given1 = Integer.parseInt(text_1.getText());
				int given2 = Integer.parseInt(text_2.getText());
				
				int result = given1 * given2;
				
				lblAnswer.setText(Integer.toString(result));
			}
		});

	}
}
