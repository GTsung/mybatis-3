/**
 *    Copyright 2009-2016 the original author or authors.
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.UnknownTypeHandler;

/**
 * @author Clinton Begin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface Result {

  /**
   * 是否是id字段
   * @return
   */
  boolean id() default false;

  /**
   * 数据库字段
   * @return
   */
  String column() default "";

  /**
   * java属性字段
   * @return
   */
  String property() default "";

  /**
   * javaType
   * @return
   */
  Class<?> javaType() default void.class;

  /**
   * JDBC TYPE
   * @return
   */
  JdbcType jdbcType() default JdbcType.UNDEFINED;

  /**
   * TypeHandler处理器
   * @return
   */
  Class<? extends TypeHandler> typeHandler() default UnknownTypeHandler.class;

  /**
   * {@link One}
   * @return
   */
  One one() default @One;

  /**
   * {@link Many}
   * @return
   */
  Many many() default @Many;
}
