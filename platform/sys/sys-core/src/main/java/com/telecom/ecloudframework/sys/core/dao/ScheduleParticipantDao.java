package com.telecom.ecloudframework.sys.core.dao;
import java.util.Date;
import java.util.List;

import com.telecom.ecloudframework.base.dao.BaseDao;
import com.telecom.ecloudframework.sys.api.model.calendar.ScheduleParticipant;
import org.apache.ibatis.annotations.Param;


public interface ScheduleParticipantDao extends BaseDao<String, ScheduleParticipant> {
	/**
	 * 根据外键获取子表明细列表
	 * @param scheduleId
	 * @return
	 */
	public List<ScheduleParticipant> getScheduleParticipantList(String scheduleId);
	
	/**
	 * 根据外键删除子表记录
	 * @param scheduleId
	 * @return
	 */
	public void delByMainId(String scheduleId);
	/**
	 * 根据参与者姓名获取记录
	 * @param name
	 * @return
	 */
	public ScheduleParticipant getByName(String name);

	/**
	 * 更新参与者的完成比例和完成时间
	 */
	void updateByRateAndCompleteTime(@Param("scheduleId") String scheduleId,
									 @Param("rate") int rate,
									 @Param("completeTime") Date completeTime);
	
}
