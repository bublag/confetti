package org.confetti.xml.core.time;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bubla Gabor
 */
@XmlRootElement
@XmlType(propOrder = {
		"weight", 
		"nrOfActivities", "activityIds",
		"active", "comment"})
public class ConstraintActivitiesSameStartingDay extends TimeConstraint {
	@XmlElement(name = "Number_of_Activities") 		private int nrOfActivities;
	@XmlElement(name = "Activity_Id") 				private List<Long> activityIds;
}