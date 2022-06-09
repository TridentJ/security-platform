package com.trident.security.dao;

import com.trident.security.bean.LoginUser;
import com.trident.security.bean.LoginUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    long countByExample(LoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int deleteByExample(LoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int insert(LoginUser row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int insertSelective(LoginUser row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    List<LoginUser> selectByExample(LoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    LoginUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") LoginUser row, @Param("example") LoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") LoginUser row, @Param("example") LoginUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LoginUser row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table login_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LoginUser row);
}