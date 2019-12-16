/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Person;

/**
 * @author david.kittle
 *
 */
public class FavoriteColorComparator implements Comparator<Person> {

	@Override
	public int compare(final Person person1, final Person person2) {	
		return person1.getFavoriteColor().compareTo(person2.getFavoriteColor());
	}

}
