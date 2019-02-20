package cn.cj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cj.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
     
    /**
     * 根据账号获取当前用户信息
     * @param userAccount
     * @return
     */
    User selectByUserAccount(@Param("userAccount") String userAccount);
    
    /**
     * 获取所有用户列表
     */
    List<User> selectAllUser();
}