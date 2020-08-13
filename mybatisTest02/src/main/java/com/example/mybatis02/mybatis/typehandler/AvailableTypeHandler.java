package com.example.mybatis02.mybatis.typehandler;

import com.example.mybatis02.mybatis.enumeration.AvailableEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value= AvailableEnum.class)
public class AvailableTypeHandler extends BaseTypeHandler<AvailableEnum> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, AvailableEnum aEnum, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, aEnum.getId());
	}

	@Override
	public AvailableEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
		int flag = resultSet.getInt(s);
		if(flag != 1 && flag != 0){
			return null;
		}
		return AvailableEnum.getEnumById(flag);
	}

	@Override
	public AvailableEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
		int flag = resultSet.getInt(i);
		if(flag != 1 && flag != 0){
			return null;
		}
		return AvailableEnum.getEnumById(flag);
	}

	@Override
	public AvailableEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		int flag = callableStatement.getInt(i);
		if(flag != 1 && flag != 0){
			return null;
		}
		return AvailableEnum.getEnumById(flag);
	}
}