/**
 * 
 */
package edu.cvtc.web.dao;

import java.util.List;

import edu.cvtc.web.dao.impl.MovieDaoException;
import edu.cvtc.web.model.Movie;

/**
 * @author david.kittle
 *
 */
public interface MovieDao {
	
	void populate(String filePath) throws MovieDaoException;

	List<Movie> retrieveMovie() throws MovieDaoException;

	void insertMovie(Movie movie) throws MovieDaoException;

}
