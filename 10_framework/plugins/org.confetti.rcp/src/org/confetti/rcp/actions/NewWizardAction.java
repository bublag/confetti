package org.confetti.rcp.actions;

import static org.confetti.rcp.wizards.WizardUtil.watchWizardDialog;

import java.util.List;

import org.confetti.rcp.extensions.NewWizardDescr;
import org.confetti.rcp.extensions.NewWizardFactory;
import org.confetti.rcp.extensions.NewWizardRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListDialog;

public class NewWizardAction extends Action {

	public NewWizardAction() {
		super();
		setId("newWizard");
		setText("New...");
	}

	@Override
	public void run() {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ListDialog dlg = new ListDialog(shell);
		dlg.setContentProvider(new ArrayContentProvider());
		dlg.setLabelProvider(new LabelProvider());
		dlg.setTitle("New");
		dlg.setMessage("Choose an input");
		List<NewWizardDescr> extensions = NewWizardRegistry.INSTANCE.getExtensions();
		dlg.setInput(extensions); 
		if (Window.OK != dlg.open()) {
			return;
		}
		Object[] selected = dlg.getResult();
		if (selected == null || selected.length == 0) {
			return;
		}
		NewWizardDescr selectedDescr = (NewWizardDescr) selected[0];
		NewWizardFactory wizardFactory = selectedDescr.getWizardFactory();
		WizardDialog dialog = new WizardDialog(shell, wizardFactory.createWizard("Test school", "kommentar :D", null, null));
		watchWizardDialog(dialog);
		//TODO: title doesn't showing
		dialog.setTitle("New...");
		dialog.open();
	}

}
