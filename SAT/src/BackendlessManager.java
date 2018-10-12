import java.util.List;
import java.util.Map;

import com.backendless.Backendless;

import com.backendless.persistence.DataQueryBuilder;

public class BackendlessManager {

	public static List<Map> getDataFromBackendless(String whereClause, String table){
		DataQueryBuilder queryBuilder = createWhereClause(whereClause);
		queryBuilder.setPageSize(100);
		return Backendless.Data.of( table ).find(queryBuilder);
	}


	public static int queryBackendFor(String column, String item,List<Map> items) {
		int counter = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).get(column).equals(item)) {
				counter++;
			}
		}


		return counter;
	}

	public static int queryBackendForRatingPer(String session, List<Map> items) {
		int counter = 0;
		int average = 0;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).get("SessionID").equals(session)) {
				average += (Integer)items.get(i).get("Rating");
				counter++;
			}
		}
		if (average == 0) {
			return average;
		} else {
			return average/counter;
		}

	}


	public static DataQueryBuilder createWhereClause(String whereClause) {
		String clause = String.format(whereClause);
		DataQueryBuilder queryBuilder = DataQueryBuilder.create();
		queryBuilder.setWhereClause( clause );
		queryBuilder.setPageSize(100);

		return queryBuilder;
	}

	public static Boolean queryBackendFor(String course, String session) {
		DataQueryBuilder currentTeacherCourseCountQuery = createWhereClause("courseID = '"+ course +"'" + " and TeacherEmail = '" + Defaults.getUser().getEmail() + "'");
		currentTeacherCourseCountQuery.setPageSize(100);
		DataQueryBuilder sessionCountQuery = createWhereClause("courseID = '"+course+"'" + " and sessionID = '" + session + "'");
		sessionCountQuery.setPageSize(100);
		DataQueryBuilder courseCountQuery = createWhereClause("courseID = '"+ course +"'");
		courseCountQuery.setPageSize(100);

		int 	currentTeacherCourseCount =  Backendless.Data.of( "Teachers" ).getObjectCount(currentTeacherCourseCountQuery);

		int sessionCount = Backendless.Data.of( "Teachers" ).getObjectCount(sessionCountQuery);

		int courseCount = Backendless.Data.of( "Teachers" ).getObjectCount(courseCountQuery);



	
		if (currentTeacherCourseCount > 0) {
			// If current teacher owns course and made session for it already
			if (sessionCount > 0 && courseCount > 0) {
				return false;
			} else {
				return true;
			}
		}


		// Nobody owns the course
		if (courseCount == 0) {
			return true;
		}

		return false;
	}

}
