package com.gjw.dao;

import java.util.List;

import com.gjw.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

public interface HeadLineDao {

    /**
     * 根据传入的查询条件(头条名查询头像)
     *
     * @return
     */
    List<HeadLine> queryHeadLine(
            @Param("headLineCondition") HeadLine headLineCondition);

    /**
     * @param lineId
     * @return
     */
    HeadLine queryHeadLineById(long lineId);

    /**
     * @param lineIdList
     * @return
     */
    List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

    /**
     * @param headLine
     * @return
     */
    int insertHeadLine(HeadLine headLine);

    /**
     * @param headLine
     * @return
     */
    int updateHeadLine(HeadLine headLine);

    /**
     * @param headLineId
     * @return
     */
    int deleteHeadLine(long headLineId);

    /**
     * @param lineIdList
     * @return
     */
    int batchDeleteHeadLine(List<Long> lineIdList);
}
