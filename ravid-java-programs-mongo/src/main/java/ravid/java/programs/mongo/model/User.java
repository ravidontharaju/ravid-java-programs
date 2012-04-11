/**
 *  Apr 3, 2012
 */
package ravid.java.programs.mongo.model;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * User definition class.
 *
 * @author Ravi
 */
public class User {

	private String userId;
	private String email;
	private boolean isMale;
	private int age;
	private DateTime birthday;
	
	public User(String userId, String email, String sex, DateTime birthday) {
		this.userId = userId;
		this.email = email;
		this.isMale = (sex.startsWith("M") || sex.startsWith("m")) ? true : false;
		DateTime currentDate = new DateTime();
		Period period = new Period(birthday, currentDate, PeriodType.yearMonthDay());
		this.age = period.getYears();
		this.birthday = birthday;
	}
	
	public static enum UserFieldNames {
		userId, email, isMale, age, birthday;
	}
	
	public int getAge() {
		return age;
	}

	public DateTime getBirthday() {
		return birthday;
	}

	public String getEmail() {
		return email;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getSex() {
		return isMale ? "Male" : "Female";
	}
}
