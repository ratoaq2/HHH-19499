package org.hibernate.bugs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

public class MyCustomType implements UserType<MyType> {

	@Override
	public int getSqlType() {
		return Types.NUMERIC;
	}

	@Override
	public Class<MyType> returnedClass() {
		return MyType.class;
	}

	@Override
	public MyType deepCopy(MyType value) {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public MyType nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor options, Object owner)
			throws SQLException {
		return rs.wasNull() ? null : MyType.of(rs.getInt(position));
	}

	@Override
	public void nullSafeSet(PreparedStatement st, MyType value, int index, SharedSessionContractImplementor options)
			throws SQLException {
		if (value == null) {
			st.setNull(index, getSqlType());
		} else {
			st.setInt(index, value.getId());
		}
	}
}
