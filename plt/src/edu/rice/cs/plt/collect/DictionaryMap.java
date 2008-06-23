/*BEGIN_COPYRIGHT_BLOCK*

PLT Utilities BSD License

Copyright (c) 2007-2008 JavaPLT group at Rice University
All rights reserved.

Developed by:   Java Programming Languages Team
                Rice University
                http://www.cs.rice.edu/~javaplt/

Redistribution and use in source and binary forms, with or without modification, are permitted 
provided that the following conditions are met:

    - Redistributions of source code must retain the above copyright notice, this list of conditions 
      and the following disclaimer.
    - Redistributions in binary form must reproduce the above copyright notice, this list of 
      conditions and the following disclaimer in the documentation and/or other materials provided 
      with the distribution.
    - Neither the name of the JavaPLT group, Rice University, nor the names of the library's 
      contributors may be used to endorse or promote products derived from this software without 
      specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS AND 
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*END_COPYRIGHT_BLOCK*/

package edu.rice.cs.plt.collect;

import java.util.Dictionary;
import java.util.Iterator;
import java.io.Serializable;
import edu.rice.cs.plt.iter.IterUtil;

/**
 * A map wrapping a {@link Dictionary} object.  Defined for compatibility with legacy APIs.
 */
public class DictionaryMap<K, V> extends AbstractKeyBasedMap<K, V> implements Serializable {
  
  private final Dictionary<K, V> _d;
  
  public DictionaryMap(Dictionary<K, V> d) {
    _d = d;
  }
  
  public V get(Object key) { return _d.get(key); }
  
  public PredicateSet<K> keySet() {
    return new AbstractPredicateSet<K>() {
      public boolean contains(Object o) { return _d.get(o) != null; }
      public Iterator<K> iterator() { return IterUtil.asIterator(_d.keys()); }
      public boolean isInfinite() { return false; }
      public boolean hasFixedSize() { return false; }
      public boolean isStatic() { return false; }
      @Override public int size() { return _d.size(); }
      @Override public int size(int b) { int s = _d.size(); return (s < b) ? s : b; }
      @Override public boolean isEmpty() { return _d.isEmpty(); }
      @Override public boolean remove(Object o) { return _d.remove(o) != null; }
    };
  }
  
  @Override public V value(K key) { return _d.get(key); }
  @Override public int size() { return _d.size(); }
  @Override public boolean isEmpty() { return _d.isEmpty(); }
  @Override public boolean containsKey(Object key) { return _d.get(key) != null; }

  @Override public V put(K key, V value) { return _d.put(key, value); }
  @Override public V remove(Object key) { return _d.remove(key); }
  @Override public void clear() { keySet().clear(); }
}
