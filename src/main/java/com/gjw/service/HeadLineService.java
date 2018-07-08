package com.gjw.service;

import java.io.IOException;
import java.util.List;

import com.gjw.dto.HeadLineExecution;
import com.gjw.entity.HeadLine;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public interface HeadLineService {

    public static final String HLLISTKEY = "headlinelist";

    /**
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition)
            throws IOException;

//	/**
//	 *
//	 * @param headLine
//	 * @param thumbnail
//	 * @return
//	 */
//	HeadLineExecution addHeadLine(HeadLine headLine,
//								  CommonsMultipartFile thumbnail);
//
//	/**
//	 *
//	 * @param headLine
//	 * @param thumbnail
//	 * @return
//	 */
//	HeadLineExecution modifyHeadLine(HeadLine headLine,
//                                     CommonsMultipartFile thumbnail);
//
//	/**
//	 *
//	 * @param headLineId
//	 * @return
//	 */
//	HeadLineExecution removeHeadLine(long headLineId);
//
//	/**
//	 *
//	 * @param headLineIdList
//	 * @return
//	 */
//	HeadLineExecution removeHeadLineList(List<Long> headLineIdList);

}
