/**
 *    Copyright 2009-2019 the original author or authors.
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
package org.apache.ibatis.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.cache.decorators.LruCache;
import org.apache.ibatis.cache.impl.PerpetualCache;

/**
 * 对应xml配置文件的 <cache/>
 * @author Clinton Begin
 * @author Kazuki Shimizu
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Mapper类上
public @interface CacheNamespace {

  /**
   * 负责存储的 Cache 实现类
   * @return
   */
  Class<? extends org.apache.ibatis.cache.Cache> implementation() default PerpetualCache.class;

  /**
   * 负责过期的 Cache 实现类
   * @return
   */
  Class<? extends org.apache.ibatis.cache.Cache> eviction() default LruCache.class;

  /**
   * 清空缓存的频率。0代表不清空
   * @return
   */
  long flushInterval() default 0;

  /**
   * 缓存器大小
   * @return
   */
  int size() default 1024;

  /**
   * 是否序列化 {@link org.apache.ibatis.cache.decorators.SerializedCache}
   * @return
   */
  boolean readWrite() default true;

  /**
   * 是否阻塞 {@link org.apache.ibatis.cache.decorators.BlockingCache}
   * @return
   */
  boolean blocking() default false;

  /**
   * Property values for a implementation object.
   * @since 3.4.2
   * {@link Property} 数组
   */
  Property[] properties() default {};

}
