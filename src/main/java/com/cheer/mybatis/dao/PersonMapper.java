package com.cheer.mybatis.dao;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    List<Map<String, Object>> selectPerson();
}
