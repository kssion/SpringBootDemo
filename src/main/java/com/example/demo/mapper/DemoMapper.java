package com.example.demo.mapper;

import com.example.demo.model.DemoModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DemoMapper {

    // 插入 并返回自增ID
    @Insert("INSERT INTO tb_test(key, value) VALUES(#{key}, #{value})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'tb_test')", before = false, keyProperty = "id", resultType = int.class)
    int insert(DemoModel model);

    // 根据 ID 查询
    @Select("SELECT * FROM tb_test WHERE id=#{id}")
    DemoModel select(int id);

    // 查询全部
    @Select("SELECT * FROM tb_test")
    List<DemoModel> selectAll();

    // 更新 value
    @Update("UPDATE tb_test SET value=#{value} WHERE id=#{id}")
    int updateValue(DemoModel model);

    // 根据 ID 删除
    @Delete("DELETE FROM tb_test WHERE id=#{id}")
    int delete(Integer id);
}
