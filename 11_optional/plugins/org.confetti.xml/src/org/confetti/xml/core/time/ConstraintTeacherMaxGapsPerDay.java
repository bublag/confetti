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
		"teacherName", "maxGaps",
		"active", "comment"})
public class ConstraintTeacherMaxGapsPerDay extends TimeConstraint {
	@XmlElement(name = "Teacher_Name") 	private String teacherName;
	@XmlElement(name = "Max_Gaps") 		private int maxGaps;
}
