/*
 * This file is part of muCommander, http://www.mucommander.com
 * Copyright (C) 2002-2009 Maxence Bernard
 *
 * muCommander is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * muCommander is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.mucommander.ui.dialog.file;

import com.mucommander.file.AbstractFile;
import com.mucommander.file.util.FileSet;
import com.mucommander.ui.main.MainFrame;

/**
 * Dialog invoked when the user wants to copy a single file to the same directory under a different name.
 * The destination field is pre-filled with the file's name.
 *
 * @author Maxence Bernard
 */
public class LocalCopyDialog extends CopyDialog {

    /**
     * Creates a new <code>LocalCopyDialog</code>.
     *
     * @param mainFrame the main frame that spawned this dialog.
     * @param files files to be copied
     */
    public LocalCopyDialog(MainFrame mainFrame, FileSet files) {
        super(mainFrame, files);
    }


    ////////////////////////
    // Overridden methods //
    ////////////////////////

    protected PathFieldContent computeInitialPath(FileSet files) {
        String fieldText;     // Text to display in the destination field.
        int    endPosition;   // Index of the last selected character in the destination field.

        // Fill text field with the sole file's name
        fieldText     = ((AbstractFile)files.elementAt(0)).getName();
        endPosition   = fieldText.indexOf('.');

        // If the file doesn't have an extension, selection extends to the end of its name.
        if(endPosition <= 0)
            endPosition = fieldText.length();

        return new PathFieldContent(fieldText, 0, endPosition);
    }
}