/******************************************************************************
* Copyright (C) 2012-2013  Hussain Bohra and others
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Hussain Bohra <hussain.bohra@tavant.com> - initial API and implementation
*     Fabio Zadrozny <fabiofz@gmail.com>       - ongoing maintenance
******************************************************************************/
package org.python.pydev.debug.newconsole.actions;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.python.pydev.shared_interactive_console.console.ui.ScriptConsole;
import org.python.pydev.shared_interactive_console.console.ui.ScriptConsoleManager;
import org.python.pydev.shared_interactive_console.console.ui.ScriptConsoleUIConstants;
import org.python.pydev.shared_ui.ImageCache;
import org.python.pydev.shared_ui.SharedUiPlugin;

public class LinkWithDebugSelectionAction extends Action {

    private ScriptConsole console;

    public LinkWithDebugSelectionAction(ScriptConsole console, String text, String tooltip) {
        super(text, IAction.AS_CHECK_BOX);
        this.console = console;
        setToolTipText(tooltip);
        setImageDescriptor(getImageDescriptor());
        setDisabledImageDescriptor(getImageDescriptor());
        setText(text);
        // set true by default
        setChecked(true);
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        String imagePath = ScriptConsoleUIConstants.ICONS_PATH + File.separator
                + ScriptConsoleUIConstants.LINK_WITH_DEBUGGER;
        return ImageCache.asImageDescriptor(SharedUiPlugin.getImageCache().getDescriptor(imagePath));
    }

    @Override
    public void run() {
        boolean isChecked = isChecked();
        ScriptConsoleManager.getInstance().linkWithDebugSelection(console, isChecked);
    }

    public void update() {
        setEnabled(true);
    }
}
