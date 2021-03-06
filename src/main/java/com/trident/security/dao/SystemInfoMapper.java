package com.trident.security.dao;

import com.trident.security.bean.SystemInfo;
import com.trident.security.bean.SystemInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    long countByExample(SystemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int deleteByExample(SystemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int insert(SystemInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int insertSelective(SystemInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    List<SystemInfo> selectByExample(SystemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    SystemInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") SystemInfo row, @Param("example") SystemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") SystemInfo row, @Param("example") SystemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SystemInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SystemInfo row);
}