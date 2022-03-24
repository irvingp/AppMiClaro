package configxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement(name = "suite")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suite {
	
	 @XmlElement(name = "test")
	 Test test;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}
	 
	 
	 
	
}
