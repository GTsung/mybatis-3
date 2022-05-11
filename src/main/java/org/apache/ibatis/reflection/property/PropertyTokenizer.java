/**
 *    Copyright 2009-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.property;

import java.util.Iterator;

/**
 * 属性分词器，在访问 "order[0].item[0].name" 时，可拆分为 "order[0]"、"item[0]"、"name" 三段
 * @author Clinton Begin
 */
public class PropertyTokenizer implements Iterator<PropertyTokenizer> {

  /**
   * 当前字符串
   */
  private String name;

  /**
   * 索引的{@link #name}，{@link #name}如果存在则 {@link #index} 会被更改
   */
  private final String indexedName;

  /**
   * 编号
   * 对于数组 name[0]，则index = 0
   * 对于 Map map[key]，则index = key
   */
  private String index;

  /**
   * 剩余字符串
   */
  private final String children;

  public PropertyTokenizer(String fullname) {
    // 找到"."分隔符的索引
    int delim = fullname.indexOf('.');
    if (delim > -1) {
      // 分割，name为第一个，剩余的放在children中
      name = fullname.substring(0, delim);
      children = fullname.substring(delim + 1);
    } else {
      // 否则name为整个
      name = fullname;
      children = null;
    }
    // 记录当前name
    indexedName = name;
    delim = name.indexOf('[');
    if (delim > -1) {
      // 如果name = [t] 则最终index = t; name = ""
      // 如果name = k[t] 则最终index = t; name = k
      index = name.substring(delim + 1, name.length() - 1);
      name = name.substring(0, delim);
    }
  }

  public String getName() {
    return name;
  }

  public String getIndex() {
    return index;
  }

  public String getIndexedName() {
    return indexedName;
  }

  public String getChildren() {
    return children;
  }

  @Override
  public boolean hasNext() {
    return children != null;
  }

  @Override
  public PropertyTokenizer next() {
    // 迭代器模式
    return new PropertyTokenizer(children);
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
  }
}
