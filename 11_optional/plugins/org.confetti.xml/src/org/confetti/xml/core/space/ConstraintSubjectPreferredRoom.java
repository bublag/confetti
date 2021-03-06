package org.confetti.xml.core.space;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Bubla Gabor
 */
@XmlRootElement
@XmlType(propOrder = {
		"weight", 
		"subject", "room", 
		"active", "comment"})
public class ConstraintSubjectPreferredRoom extends SpaceConstraint {
	@XmlElement(name = "Subject") private String subject;
	@XmlElement(name = "Room") private String room;
}
