/*BEGIN_COPYRIGHT_BLOCK
 *
 * Copyright (c) 2001-2016, JavaPLT group at Rice University (drjava@rice.edu)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the names of DrJava, the JavaPLT group, Rice University, nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software is Open Source Initiative approved Open Source Software.
 * Open Source Initative Approved is a trademark of the Open Source Initiative.
 * 
 * This file is part of DrJava.  Download the current version of this project
 * from http://www.drjava.org/ or http://sourceforge.net/projects/drjava/
 * 
 * END_COPYRIGHT_BLOCK*/

package edu.rice.cs.drjava;

import junit.framework.*;

/** Test that ensures all external dependencies are met!
 *  @version $Id$
 */
public final class DependenciesTest extends DrJavaTestCase {
  public static final String REQUIRED_UTIL_VERSION = "20040521-1616";

  /** Constructor.
   *  @param name the name of the test
   */
  public DependenciesTest(String name) {
    super(name);
  }
  
  /** Creates a test suite for JUnit to run.
   *  @return a test suite based on the methods in this class
   */
  public static Test suite() { return  new TestSuite(DependenciesTest.class); }

  /** This test ensures that the util package version is as new as we expect.
   * It is no longer used (since util is no longer a separate jar), but is
   * left here as an example of what could be done with other modules
   * (although it might be worth discussing whether this is really the right way
   * to test that the right support libs are present).
   * @throws Throwable if something goes wrong
   */
  public void testUtilVersion() throws Throwable {
    /*Date required = new SimpleDateFormat("yyyyMMdd-HHmm z").parse(REQUIRED_UTIL_VERSION + " GMT");

    Date found = edu.rice.cs.util.Version.getBuildTime();

    assertTrue("Util package date is " + found + ", but at least " + required +
                 " was required! You need to update/compile the util package.",
               ! required.after(found));
    */
  }
  
}
