/**
 *    Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 类型转换器
 * 两种：执行sql时由Java类型的参数转换为JDBC类型
 *       获取结果集数据将JDBC类型转换为java类型
 * @author Clinton Begin
 */
public interface TypeHandler<T> {

  /**
   * 设置PreparedStatement的指定参数
   * javaType => JDBC Type
   * @param ps 执行sql的对象
   * @param i 参数占位符的位置
   * @param parameter 参数
   * @param jdbcType JDBC类型
   * @throws SQLException
   */
  void setParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException;

  /**
   * 获得ResultSet的指定字段的值
   * JDBC TYPE => JAVA TYPE
   * @param rs 结果集对象
   * @param columnName 字段名
   * @return 值
   * @throws SQLException
   */
  T getResult(ResultSet rs, String columnName) throws SQLException;

  /**
   * 获得ResultSet的指定字段的值
   * JDBC TYPE => JAVA TYPE
   * @param rs 结果集对象
   * @param columnIndex 字段位置
   * @return
   * @throws SQLException
   */
  T getResult(ResultSet rs, int columnIndex) throws SQLException;

  /**
   * 获得 CallableStatement 的指定字段的值
   * JDBC TYPE => JAVA TYPE
   * @param cs CallableStatement对象，支持调用存储过程
   * @param columnIndex 字段位置
   * @return
   * @throws SQLException
   */
  T getResult(CallableStatement cs, int columnIndex) throws SQLException;

}
