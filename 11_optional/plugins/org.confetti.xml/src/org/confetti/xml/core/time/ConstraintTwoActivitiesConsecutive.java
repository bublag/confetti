package org.confetti.xml.core.time;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bubla Gabor
 */
@XmlRootElement
@XmlType(propOrder = { "weight", "firstActivityId", "secondActivityId", "active", "comment" })
public class ConstraintTwoActivitiesConsecutive extends TimeConstraint {
	@XmlElement(name = "First_Activity_Id") private int firstActivityId;
	@XmlElement(name = "Second_Activity_Id") private int secondActivityId;
}
