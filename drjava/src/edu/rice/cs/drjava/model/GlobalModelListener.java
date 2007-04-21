/*BEGIN_COPYRIGHT_BLOCK
 *
 * This file is part of DrJava.  Download the current version of this project from http://www.drjava.org/
 * or http://sourceforge.net/projects/drjava/
 *
 * DrJava Open Source License
 * 
 * Copyright (C) 2001-2005 JavaPLT group at Rice University (javaplt@rice.edu).  All rights reserved.
 *
 * Developed by:   Java Programming Languages Team, Rice University, http://www.cs.rice.edu/~javaplt/
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal with the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and 
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 *     - Redistributions of source code must retain the above copyright notice, this list of conditions and the 
 *       following disclaimers.
 *     - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the 
 *       following disclaimers in the documentation and/or other materials provided with the distribution.
 *     - Neither the names of DrJava, the JavaPLT, Rice University, nor the names of its contributors may be used to 
 *       endorse or promote products derived from this Software without specific prior written permission.
 *     - Products derived from this software may not be called "DrJava" nor use the term "DrJava" as part of their 
 *       names without prior written permission from the JavaPLT group.  For permission, write to javaplt@rice.edu.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO 
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
 * WITH THE SOFTWARE.
 * 
END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava.model;

import java.io.File;
import edu.rice.cs.drjava.model.repl.InteractionsListener;
import edu.rice.cs.drjava.model.compiler.CompilerListener;
import edu.rice.cs.drjava.model.junit.JUnitListener;
import edu.rice.cs.drjava.model.javadoc.JavadocListener;

import edu.rice.cs.util.FileOpenSelector;
import edu.rice.cs.util.swing.AsyncTask;

/**
 * An interface for responding to events generated by the GlobalModel.
 * TODO: Refactor to remove component listeners from Global level.
 *
 * @version $Id$
 */
public interface GlobalModelListener extends InteractionsListener, JavadocListener, CompilerListener, JUnitListener {
  
  /** Called when an asynchronous task must be run in the model */
  public <P,R> void executeAsyncTask(AsyncTask<P,R> task, P param, boolean showProgress, boolean lockUI);
  
 /**
   * Performs any UI related steps to handle the case in which a file is being opened that
   * is already open and modified. The two choices are to revert to the copy on disk, or to
   * keep the current changes.
   * @param doc  {@code true} if the user wishes to revert the document, {@code false} to ignore
   */
  public void handleAlreadyOpenDocument(OpenDefinitionsDocument doc);
  
  /** Called when trying to open one or more files that do not exist. */
  public void filesNotFound(File... f);
  
  /** Called after a new document is created. */
  public void newFileCreated(OpenDefinitionsDocument doc);

  /** Called after the current document is saved. */
  public void fileSaved(OpenDefinitionsDocument doc);

  /** Called after a file is opened and read into the current document. */
  public void fileOpened(OpenDefinitionsDocument doc);

  /** Called after a document is closed. */
  public void fileClosed(OpenDefinitionsDocument doc);

  /** Called after a document is reverted. */
  public void fileReverted(OpenDefinitionsDocument doc);

  /** Called to ask the listener if it is OK to abandon the current document. */
  public boolean canAbandonFile(OpenDefinitionsDocument doc);

  /** Called to ask the listener if this document should be saved before quitting.
   *  @return true if quitting should continue, false if the user cancelled */
  public boolean quitFile(OpenDefinitionsDocument doc);
  
  /** Called to ask the listener if it is OK to revert the current document to the version saved on disk. */
  public boolean shouldRevertFile(OpenDefinitionsDocument doc);

  /** Called when a file's main method is about to be run. */
  public void runStarted(OpenDefinitionsDocument doc);

  /** Called when the console window is reset. */
  public void consoleReset();

  /** Called when an undoable edit occurs. */
  public void undoableEditHappened();

  /** Called when saving a file whose path contains a '#' symbol. */
  public void filePathContainsPound();
   
  /** Called when a new active document is selected */
  public void activeDocumentChanged(OpenDefinitionsDocument active);
  
  /** Called when the active document is refreshed */
  public void activeDocumentRefreshed(OpenDefinitionsDocument active);
  
  /** Called when the focus must be changed to the active document in the definitions pane */
  public void focusOnDefinitionsPane();
  
  /** Restores the focus in the main frame to the last focus owner. */
  public void focusOnLastFocusOwner();
  
  /** Called when the selection in the navigator changes the current directory without changing the active document. */
  public void currentDirectoryChanged(File dir);
    
  /** Called when the build directory is modified in the model. */
  public void projectBuildDirChanged();
  
  /** Called when the working directory is modified in the model. */
  public void projectWorkDirChanged();
  
  /** Called while the project is being opened.
   *  @param projectFile the location of the project file
   *  @param files The files the gui should open for the model
   */
  public void projectOpened(File projectFile, FileOpenSelector files);

  /** Called when the project is being closed. */
  public void projectClosed();

  /** Called if the project's modified state has changed. */
  public void projectModified();
  
  /** Called when the project runnability changed (ie, when the main file is set/unset). */
  public void projectRunnableChanged();
  
  /** Called when the a document, already opened, is brought back into the cache, and it no longer exists on disk
   *  or cannot be accessed. */
  public void documentNotFound(OpenDefinitionsDocument d, File f);
}

