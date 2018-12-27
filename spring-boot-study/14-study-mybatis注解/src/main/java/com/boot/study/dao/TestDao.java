package com.boot.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.boot.study.model.TTest;

@Mapper
public interface TestDao {

	@Select("select * from t_test")
	List<TTest> selectAll();

	@Select("select * from t_test t where t.id = #{id}")
	TTest getById(Long id);

	@Select("select * from t_test t where t.id = #{id} and t.name = #{name}")
	TTest query(@Param("id") Long id, @Param("name") String name);

	@Delete("delete from t_test  where id = #{id}")
	int delete(Long id);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into t_test(name) values(#{name})")
	int save(TTest test);

	@Update("update t_test t set t.name= #{name} where t.id = #{id}")
	int update(TTest test);
//	int update(@Param("id") Long id, @Param("name") String name);
}
