package org.confetti.xml.core.time;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bubla Gabor
 */
@XmlRootElement
@XmlType(propOrder = {
		"weight", 
		"activityTag", "maxHoursContinuously", 
		"active", "comment"})
public class ConstraintStudentsActivityTagMaxHoursContinuously extends TimeConstraint {

	@XmlElement(name = "Activity_Tag") private String activityTag;
	@XmlElement(name = "Maximum_Hours_Continuously") private int maxHoursContinuously;

}
